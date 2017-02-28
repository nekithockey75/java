import java.util.*;

class Point implements Comparable<Point> {

	public double x, y;
	Point() {};

	Point(double init_x, double init_y) {
		x = init_x;
		y = init_y;
	}

	@Override
	public int compareTo(Point p2) {
		return ((Double.compare(this.x, p2.x) != 0) &&	(Double.compare(this.y, p2.y) != 0) ?
				Double.compare(this.x, p2.x) : 0);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int)x;
		result = prime * result + (int)y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}
