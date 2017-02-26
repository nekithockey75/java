import java.util.*;

class Field {
	private static Vertex start, finish;
	private static Vertex[] vertexes;
	private static Figure[] figures;
	private static double[][] distance_matrix;

	private static Random r = new Random();

	public static void set(Vertex start_arg, Vertex finish_arg, Figure[] figures_arg) {
		start = start_arg;
		finish = finish_arg;
		figures = figures_arg;

		ArrayList<Vertex> vert_list = new ArrayList<>();
		for (Figure figure : figures)
			for (Vertex vertex : figure.vert_array)
				vert_list.add(vertex);

		vertexes = new Vertex[vert_list.size()];
		vertexes = vert_list.toArray(vertexes);
	}

	public static void print() {
		for (Vertex vertex : vertexes)
			System.out.print(vertex.x + " " + vertex.y + " " + vertex.g + "\n");
	}

}
