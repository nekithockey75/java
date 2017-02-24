import java.util.*;

class Field {
	private static Vertex start, finish;
	//private static Figure[] figures;
	private static double[][] distance_matrix;

	private static Random r = new Random();

	public static void set(Vertex start_arg, Vertex finish_arg) {
		start = start_arg;
		finish = finish_arg;
	}

	public static void generate() {
		start.x = r.nextInt(HEIGHT); start.y = r.nextInt(WIDTH);
		finish.x = r.nextInt(HEIGHT); finish.y = r.nextInt(WIDTH);
	}
}
