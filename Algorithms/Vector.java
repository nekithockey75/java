class Vector {

	private double lenght = 0;
	private int x, y;
	private double xx, yy;

	Vector(Vertex v1, Vertex v2) {
		x = v2.x - v1.x;
		y = v2.y - v1.y;
		xx = v2.xx - v1.xx;
		yy = v2.yy - v1.yy;
		lenght = Math.sqrt(x * x + y * y);
	}

	public double length() {
		return lenght;
	}

	public double multiply(Vector arg) {
		return xx * arg.yy - yy * arg.xx;
	}
}
