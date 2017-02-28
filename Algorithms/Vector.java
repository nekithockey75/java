class Vector {

	private double lenght = 0;
	private double x, y;
	public Vertex	first, second;

	Vector(Vertex v1, Vertex v2) {
		x = v2.x - v1.x;
		y = v2.y - v1.y;
		first = v1;
		second = v2;
		lenght = Math.sqrt(x * x + y * y);
	}

	public double length() {
		return lenght;
	}

	public double multiply(Vector arg) {
		return x * arg.y - y * arg.x;
	}
}
