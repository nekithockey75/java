import java.util.ArrayList;

class Field {
	private static Vertex start, finish;
	private static int vertex_count;
	private static Vertex[] vertexes;
	private static Figure[] figures;
	private static double[][] distance_matrix;
	private static final double EPS = 0.1;

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
		System.out.println("Start processing...");
		for (int i = 0; i < vertexes.length; i++)
			for (int j = i; j < vertexes.length; j++)
			j: // sides of figure, not all the vertexes
				for (int k = 0; k < vertexes.length; k++)
					for (int c = k; c < vertexes.length; c++) {
						try {
							if (can_shoot(i, j, k, c))
								distance_matrix[i][j] = distance(i, j);
							else {
								distance_matrix[i][j] = Double.POSITIVE_INFINITY;
								break j; // continue j
							}
						} catch (Exception e) {
							distance_matrix[i][j] = 1;
						}
					}
	}

	private static boolean can_shoot(int from, int to, int first, int second) {
		if (!intersect(from, to, first, second)) {
			if (vertexes[from].g == true && !eps_intersect(from, to))
				return true;
			else if (vertexes[from].g == false && eps_intersect(from, to))
				return true;
		}
		return false;
	}

	private static boolean eps_intersect(int from, int to) {
		Vertex alpha, beta;
		alpha = new Vertex(0.0, 0.0);
		beta = new Vertex(0.0, 0.0);
		Point delta = new Point(0, 0);
		/**
		ALPHA
		**/
		delta.x = vertexes[from].x - vertexes[from + 1].x;
		delta.y = vertexes[from].y - vertexes[from + 1].y;

		if (delta.y == 0) { // delta y = 0
			alpha.y = vertexes[from].y;
			if (delta.x < 0) // delta x < 0
				alpha.x = vertexes[from].x + EPS;
			else // delta x  > 0
				alpha.x = vertexes[from].x - EPS;
		} else if (delta.x == 0) {
			alpha.x = vertexes[from].x;
			if (delta.y < 0)
				alpha.y = vertexes[from].y + EPS;
			else
				alpha.y = vertexes[from].y - EPS;
		}
		/**
		BETA
		**/
		delta.x = vertexes[from].x - vertexes[from - 1].x;
		delta.y = vertexes[from].y - vertexes[from - 1].y;

		if (delta.y == 0) { // BETA
			beta.y = vertexes[from].y;
			if (delta.x < 0)
				beta.x = vertexes[from].x + EPS;
			else
				beta.x = vertexes[from].x - EPS;
		} else if (delta.x == 0) {
			beta.x = vertexes[from].x;
			if (delta.y < 0)
				beta.y = vertexes[from].y + EPS;
			else
				beta.y = vertexes[from].y - EPS;
		}

		System.out.println("BETA = ( " + beta.x + " , " + beta.y + " )  ALPHA = ( " + alpha.x + " , " + alpha.y + " )");

		Vector v1, v2, v3;
		v1 = new Vector(vertexes[from], vertexes[to]);
		v2 = new Vector(vertexes[from], alpha);
		v3 = new Vector(vertexes[from], beta);

		boolean r = Math.signum(v1.multiply(v2)) != Math.signum(v1.multiply(v3));
		System.out.println(r);

		return r;

	}

	private static boolean intersect(int from, int to, int first, int second) { //
		Vector v1, v2, v3;
		v1 = new Vector(vertexes[from], vertexes[to]);
		v2 = new Vector(vertexes[from], vertexes[first]);
		v3 = new Vector(vertexes[from], vertexes[second]);
		return Math.signum(v1.multiply(v2)) != Math.signum(v1.multiply(v3));
	}

	private static double distance(int i, int j) { // works
		Vector v = new Vector(vertexes[i], vertexes[j]);
		return v.length();
	}

	public static void print() { // works
		for (Vertex vertex : vertexes)
			System.out.print(vertex.x + " " + vertex.y + " " + vertex.g + "\n");
		for (double[] line : distance_matrix) {
			for (double cell: line)
				System.out.print(cell + " ");
			System.out.println();
		}
	}

}
