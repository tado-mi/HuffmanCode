
public class Point {
	double x, y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
		
	}
	
	public Point() {
		//empty constructor
	}
	public void setPoint(){
		
	}	
	
	public String toString() {
		String thePoint = "(" +  x + ", " + y + ")";
		return thePoint; 
	}
	
	//final int LEFT = 1, RIGHT = -1, INTERSECT = 0;
	
	public static int magic(Point P, Line l) {
		
		Point A = l.p1;
		Point B = l.p2;
		

//		double x = P.x;
//		double y = P.y;
//		
//		double val = (A.x - x) * (B.y - y) - (A.y - y) * (B.x - x);
//
//		if (val < 0) return -1;//right
//
//		if (val > 0) return  1;//left
//
//		return 0;
		
		double dx1 = A.x - P.x;
		 double dy1 = A.y - P.y;
		 double dx2 = B.x - P.x;
		 double dy2 = B.y - P.y;
		 if (dx1*dy2 > dy1*dx2) return 1;
		 else if (dx1*dy2 < dy1*dx2) return -1;
		 else if ((dx1*dx2 < 0) || (dy1*dy2 < 0)) return -1;
		 else if ((dx1*dx1+dy1*dy1) < (dx2*dx2+dy2*dy2)) return 1;
		 else return 0;

	}
	
	public boolean isRight(Point P, Line l) {
		return magic(P, l) < 0;
	}
	
	public boolean isLeft(Point P, Line l) {
		return magic(P, l) > 0;
	}
	
	public boolean isOn(Point P, Line l) {
		return magic(P, l) == 0;
	}
	
	final int LEFT = 1, RIGHT = -1, INTERSECT = 0;
	
	public int compareLines(Line L, Line K) { // degenerate cases: one of the points on line
		Point x = L.p1;
		Point y = L.p2;
		
		if(isLeft(x,K)) {
			if(isLeft(y, K)) {
				return LEFT; 
				}else {
					return INTERSECT;
				}
			}
		if(isRight(x,K)){
			if(isLeft(y,K)) {
				return INTERSECT;
				}else {
					return RIGHT;
				}
				
			}

	return 0;
	}
		
		
	
	public static void main(String[] args) {
//		Point p1 = new Point(1.00, 0.4);
//		System.out.println("p1:" + p1);
//		Point p2 = new Point(3.14, 6.99);
//		Line l = new Line(p1, p2);
//		System.out.println(l.toString());
		
		
		
	}
	
	

}
