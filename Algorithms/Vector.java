import java.util.*;

class Vector {

	private int lenght = 0;
	private int x, y;

	Vector(Vertex v1, Vertex v2) {
		x = v2.x - v1.x;
		y = v2.y - v1.y;
		lenght = x * x + y * y;
	}

	public int lenght() {
		return lenght;
	}

	public int multiply(Vector arg) {
		return x * arg.y - y * arg.x;
	}
}
