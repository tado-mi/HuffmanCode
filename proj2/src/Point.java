package src;

public class Point {

	// coordinates
	double x, y;

	public Point(double x, double y) {

		this.x = x;
		this.y = y;

	}

	public String toString() {

		return "(" +  x + ", " + y + ")";

	}

	public int sideOf(Line line) {

		Point A = line.A;
		Point B = line.B;

		double val = (A.x - x) * (B.y - y) - (A.y - y) * (B.x - x);

		if (val < 0) {
			return Line.LEFT;
		}

		if (val > 0) {
			return Line.RIGHT;
		}

		return Line.INTERSECT;

	}


}
