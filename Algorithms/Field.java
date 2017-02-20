import java.util.*;

class Field {
	private static int[][] field;
	private static int HEIGHT, WIDTH;
	private static Point start, finish;
	private static Figure[] figures;
	private static Point[] vertex_vector = {};
	private static double[][] distance_matrix;

	private static Random r = new Random();

	public static void set(int[][] f, Point start_arg, Point finish_arg) {
		field = f;
		start = start_arg;
		finish = finish_arg;
		HEIGHT = field.length;
		WIDTH = field[0].length;
	}

	public static void generate() {
		for (int i = 0; i < HEIGHT; i++)
			for (int j = 0; j < WIDTH; j++)
				field[i][j] = r.nextInt(4) < 3 ? 0 : 3;

		start.x = r.nextInt(HEIGHT); start.y = r.nextInt(WIDTH);
		finish.x = r.nextInt(HEIGHT); finish.y = r.nextInt(WIDTH);

		field[start.x][start.y] = 1;
		field[finish.x][finish.y] = 2;
		generateVertexes();
		generateDistMatrix();
	}

	private static void generateVertexes() {
		HashSet<Point> vert_set = new HashSet<>();
		for (int i = 0; i < HEIGHT; i++)
			for (int j = 0; j < WIDTH; j++)
				if (field[i][j] == 3) {
					vert_set.add(new Point(j, i));
					vert_set.add(new Point(j + 1, i));
					vert_set.add(new Point(j, i + 1));
					vert_set.add(new Point(j + 1, i + 1));
				}
		/**
			ADDING START AND FINISH INTO VERTEXES MATRIX
		**/
		vert_set.add(start); vert_set.add(finish);
		vertex_vector = vert_set.toArray(new Point[vert_set.size()]);
	}

	private static void generateDistMatrix() {
		int size = vertex_vector.length;
		distance_matrix = new double[size][size];
		for (int i = 0; i < size; i++)
			for (int j = i; j < size; j++)
				for (int k = 0; k < size; k++)
					for (int c = 0; c < size; c++) { // continue from here
						if (intersect(vertex_vector[i], vertex_vector[j], vertex_vector[k], vertex_vector[c])) distance_matrix[i][j] = Double.POSITIVE_INFINITY;
						else distance_matrix[i][j] = distance(vertex_vector[i], vertex_vector[j]);
					}
	}

	private static double distance(Point begin, Point end) {
		return Math.sqrt(Math.pow(begin.x-end.x,2) + Math.pow(begin.y-end.y,2));
	}

	private static boolean intersect(Point begin, Point end, Point wallBegin, Point wallEnd) {
		//write verification here
		return false;
	}

	private static void printDistanceMatrix() {
		for (double[] line : distance_matrix)
			System.out.println(Arrays.toString(line));
	}

	public static void print() {
		String ch;
		for (int[] line : field) {	
			for (int cell : line) {
				switch (cell) {
					case 0:
						ch = "░░"; break;
					case 1:
						ch = "SS"; break;
					case 2:
						ch = "FF"; break;
					case 3:
						ch = "██"; break;
					default:
						ch = "88"; break;
				}
				System.out.print(ch);
			}
			System.out.println();
		}
	}
}
