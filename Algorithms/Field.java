import java.util.Random;
import java.util.Arrays;

class Field {
	private static int[][] field;
	private static int HEIGHT;
	private static int WIDTH;
	private static Point start, finish;

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
				field[i][j] = r.nextInt(5) < 3 ? 0 : 3;

		start.x = r.nextInt(WIDTH);	start.y = r.nextInt(HEIGHT);
		finish.x = r.nextInt(WIDTH); finish.y = r.nextInt(HEIGHT);

		field[start.x][start.y] = 1;
		field[finish.x][finish.y] = 2;
	}

	public static void print() {
		for (int[] line : field)
			System.out.println(Arrays.toString(line));
	}
}
