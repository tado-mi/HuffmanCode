
public class Line implements Comparable<Line> {
	
	public Point Var2 = new Point();
	Point p1;// = new Point();
	Point p2;// = new Point();
	int name;
	;
	public Line(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;

	}
	
	

	public String toString() {

		return ( p1.toString() + p2.toString()); 
	}
	

	public int magic(Point P) {
		
		Point A = p1;
		Point B = p2;


		
		double dx1 = p1.x - P.x;
		 double dy1 = p1.y - P.y;
		 double dx2 = p2.x - P.x;
		 double dy2 = p2.y - P.y;
		 if (dx1*dy2 > dy1*dx2) return LEFT;
		 else if (dx1*dy2 < dy1*dx2) return RIGHT;
		 else if ((dx1*dx2 < 0) || (dy1*dy2 < 0)) return RIGHT;
		 else if ((dx1*dx1+dy1*dy1) < (dx2*dx2+dy2*dy2)) return LEFT;
		 else return INTERSECT;
		
		



	}
	
	private boolean isRight(Point P) {
		
		return magic(P) == RIGHT;
		
		
		
	}
	
	private boolean isLeft(Point P) {
		return magic(P) == LEFT;
	}
	
	private boolean isOn(Point P) {
		return magic(P) == INTERSECT;
	}
	
	final int LEFT = 1, RIGHT = -1, INTERSECT = 0;
	
	
	
	
	
	//another
	public int compareTo(Line L, Line K) {
		// TODO Auto-generated method stub
		
		
//		return 0;
		
		//Var.compareLines(L, K);
//		Point x = L.p1;
//		Point y = L.p2;
//		
//		if(isLeft(x)) {
//			if(isLeft(y)) {
//				return LEFT; 
//				}else {
//					return INTERSECT;
//				}
//			}
//		if(isRight(x)){
//			if(isLeft(y)) {
//				return INTERSECT;
//				}else {
//					return RIGHT;
//				}
//				
//			}
//
	return Var2.compareLines(L, K);
	}

	@Override
	public int compareTo(Line o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
