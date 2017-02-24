import java.util.*;

class Figure {
	private int vertexCount = 0;
	public Vertex[] vert_array;
	private static int HEIGHT, WIDTH;
	private static final int LEFT = 0, TOP = 1, RIGHT = 2, BOTTOM = 3;

	Figure() {};

	Figure(ArrayList<Vertex> vert_arg) { // non satic begin
		vert_array = new Vertex[vert_arg.size()];
		vert_array = vert_arg.toArray(vert_array);
		vertexCount = vert_arg.size();
	}

	public Vertex[] getVertexes() {
		return vert_array;
	}

	public int count() {
		return this.vertexCount;
	}
}