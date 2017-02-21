import java.util.*;

/*
	TODO:
	1. vertexes coordinates vector | DONE
	2. generation of vertexes | DONE
	3. spread vertexes by figures
*/

class GeoLab {
	static final int HEIGHT = 6, WIDTH = 6;
	static int field[][] = new int[HEIGHT][WIDTH];
	static Point start = new Point();
	static Point finish = new Point();

	private static void console() {
		Field.set(field, start, finish);
		Field.generate();
		Figure.setField(field);
		Field.print();
		ArrayList<Point> pointsForFigure = new ArrayList<>();
		for (int i = 0; i < 10; i++)
			pointsForFigure.add(new Point(i, i));
		Figure figure1 = new Figure(pointsForFigure);
	}

	private static void window() {
		GUIGeoLab window = new GUIGeoLab();
	}

	public static void main(String[] args) {
		console();
		//window();
	}
}
