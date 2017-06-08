class Point
{
	Double x;
	Double y;
	Point(Double x, Double y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "(" + this.x + "; " + this.y + ")";
	}
}