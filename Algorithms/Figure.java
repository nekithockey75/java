import java.util.*;

class Figure {
	private int vertexCount = 0;
	public Vertex[] vert_array;
	private static int HEIGHT, WIDTH;
	private static final int LEFT = 0, TOP = 1, RIGHT = 2, BOTTOM = 3;

	Figure() {};

	Figure(ArrayList<Vertex> vert_arg) {
		vert_array = new Vertex[vert_arg.size()];
		vert_array = vert_arg.toArray(vert_array);
		vertexCount = vert_arg.size();

		Vector v1 = new Vector(vert_array[0], vert_array[1]);
		Vector v2 = new Vector(vert_array[0], vert_array[vertexCount - 1]);
		vert_array[0].g = (v1.multiply(v2) > 0 ? false : true);

		v1 = new Vector(vert_array[vertexCount - 1], vert_array[0]);
		v2 = new Vector(vert_array[vertexCount - 1], vert_array[vertexCount - 2]);
		vert_array[vertexCount - 1].g = (v1.multiply(v2) > 0 ? false : true);

		for (int i = 1; i < vertexCount - 1; i++) {
			v1 = new Vector(vert_array[i], vert_array[i + 1]);
			v2 = new Vector(vert_array[i], vert_array[i - 1]);
			vert_array[i].g = (v1.multiply(v2) > 0 ? false : true);
		}

	}

	public Vertex[] getVertexes() {
		return vert_array;
	}

	public int count() {
		return vertexCount;
	}
}
