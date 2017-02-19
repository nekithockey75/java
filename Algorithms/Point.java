import java.util.*;

class Point implements Comparable<Point> {

	public int x, y;
	Point() {};

	Point(int init_x, int init_y) {
		x = init_x;
		y = init_y;
	}

	@Override
	public int compareTo(Point p2) {
		return ((Integer.compare(this.x, p2.x) != 0) &&	(Integer.compare(this.y, p2.y) != 0) ?
				Integer.compare(this.x, p2.x) : 0);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
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