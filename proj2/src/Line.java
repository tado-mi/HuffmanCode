public class Line implements Comparable<Line> {

	static final int LEFT = 1, RIGHT = -1, INTERSECT = 0;
	Point A, B;

	public Line(Point A, Point B) {

		this.A = A;
		this.B = B;

	}

	public String toString() {

		return A.toString() + "\t-- " + B.toString();

	}

	@Override
	public int compareTo(Line line) {

		if (A.sideOf(line) == LEFT) {

			if (B.sideOf(line) == LEFT) {
				return LEFT;
			}
			return INTERSECT;

		} else if (A.sideOf(line) == RIGHT) {

			if (B.sideOf(line) == RIGHT) {
				return RIGHT;
			}
			return INTERSECT;

		}

		// todo: degenerate cases: one of the points on line
		return INTERSECT;

	}


}
