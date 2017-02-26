import java.util.ArrayList;

class Field {
	private static Vertex start, finish;
	private static int vertex_count;
	private static Vertex[] vertexes;
	private static Figure[] figures;
	private static double[][] distance_matrix;
	private static final double EPS = 0.01;

	public static void set(Vertex start_arg, Vertex finish_arg, Figure[] figures_arg) {
		start = start_arg;
		finish = finish_arg;
		figures = figures_arg;

		ArrayList<Vertex> vert_list = new ArrayList<>();
		for (Figure figure : figures)
			for (Vertex vertex : figure.vert_array)
				vert_list.add(vertex);

		vertex_count = vert_list.size();

		vertexes = new Vertex[vert_list.size() + 2];
		vert_list.add(start); vert_list.add(finish);
		vertexes = vert_list.toArray(vertexes);

		distance_matrix = new double[vertexes.length][vertexes.length];

		for (double[] line : distance_matrix)
			for (double cell : line)
				cell = 0.0;
	}

	public static void process() {
		for (int i = 0; i < vertexes.length; i++)
			for (int j = i; j < vertexes.length; j++)
			j:
				for (int k = 0; k < vertexes.length; k++)
					for (int c = k; c < vertexes.length; c++) {
						try {
							if (can_shoot(i, j, k, c)) distance_matrix[i][j] = distance(i, j);
							else {
								distance_matrix[i][j] = Double.POSITIVE_INFINITY;
								break j; // continue j
							}
						} catch (Exception e) {
							distance_matrix[i][j] = Double.POSITIVE_INFINITY;
						}
					}
	}

	private static boolean can_shoot(int from, int to, int first, int second) {
		if (!intersect(from, to, first, second))
			if (vertexes[from].g == true && eps_intersect(from, to)) return true;
			else if (vertexes[from].g == false && !eps_intersect(from, to)) return true;
		return false;
	}

	private static boolean eps_intersect(int from, int to) {
		double alpha_x = 0, alpha_y = 0, beta_x = 0, beta_y = 0;

		if (vertexes[from].y - vertexes[from + 1].y == 0) { // ALPHA
			alpha_y = vertexes[from].y;
			if (vertexes[from].x - vertexes[from + 1].x < 0)
				alpha_x = vertexes[from].x + EPS;
			else
				alpha_x = vertexes[from].x - EPS;
		}
		else if (vertexes[from].x - vertexes[from + 1].y == 0) {
			alpha_x = vertexes[from].x;
			if (vertexes[from].y - vertexes[from + 1].y < 0)
				alpha_y = vertexes[from].y + EPS;
			else
				alpha_y = vertexes[from].y - EPS;
		}

		if (vertexes[from].y - vertexes[from - 1].y == 0) { // BETA
			beta_y = vertexes[from].y;
			if (vertexes[from].x - vertexes[from - 1].x < 0)
				beta_x = vertexes[from].x + EPS;
			else
				beta_x = vertexes[from].x - EPS;
		}
		else if (vertexes[from].x - vertexes[from - 1].y == 0) {
			beta_x = vertexes[from].x;
			if (vertexes[from].y - vertexes[from - 1].y < 0)
				beta_y = vertexes[from].y + EPS;
			else
				beta_y = vertexes[from].y - EPS;
		}

		Vector v1, v2, v3;
		v1 = new Vector(vertexes[from], vertexes[to]);
		v2 = new Vector(vertexes[from], new Vertex(alpha_x, alpha_y));
		v3 = new Vector(vertexes[from], new Vertex(beta_x, beta_y));
		return Math.signum(v1.multiply(v2)) != Math.signum(v1.multiply(v3));

	}

	private static boolean intersect(int from, int to, int first, int second) {
		Vector v1, v2, v3;
		v1 = new Vector(vertexes[from], vertexes[to]);
		v2 = new Vector(vertexes[from], vertexes[first]);
		v3 = new Vector(vertexes[from], vertexes[second]);
		return Math.signum(v1.multiply(v2)) != Math.signum(v1.multiply(v3));
	}

	private static double distance(int i, int j) {
		Vector v = new Vector(vertexes[i], vertexes[j]);
		return v.length();
	}

	public static void print() {
		for (Vertex vertex : vertexes)
			System.out.print(vertex.x + " " + vertex.y + " " + vertex.g + "\n");
		for (double[] line : distance_matrix) {
			for (double cell: line)
				System.out.print(cell + " ");
			System.out.println();
		}
	}

}
