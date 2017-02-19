import java.util.*;

class Field {
	private static int[][] field;
	private static int HEIGHT;
	private static int WIDTH;
	private static Point start, finish;
	private static Figure[] figures;

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
		generateFigures();
	}

	private static void generateFigures() {
		HashSet<Point> vert_set = new HashSet<>();
		Point[] vertex_vector = {};
		for (int i = 0; i < HEIGHT; i++)
			for (int j = 0; j < WIDTH; j++)
				if (field[i][j] == 3) {
					vert_set.add(new Point(j, i));
					vert_set.add(new Point(j + 1, i));
					vert_set.add(new Point(j, i + 1));
					vert_set.add(new Point(j + 1, i + 1));
				}
		vertex_vector = vert_set.toArray(new Point[vert_set.size()]);
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
