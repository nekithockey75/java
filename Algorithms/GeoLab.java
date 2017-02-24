import java.util.*;

class GeoLab {
	public static Vertex start = new Vertex();
	public static Vertex finish = new Vertex();
	public static Figure[] figures = new Figure[3];

	private static void init() {
		ArrayList<Vertex> vertexesForFigure = new ArrayList<>();
		vertexesForFigure.add(new Vertex(0,0)); // 0 
		vertexesForFigure.add(new Vertex(0,4));
		vertexesForFigure.add(new Vertex(2,4));
		vertexesForFigure.add(new Vertex(2,3));
		vertexesForFigure.add(new Vertex(1,3));
		vertexesForFigure.add(new Vertex(1,0)); // 5

		figures[0] = new Figure(vertexesForFigure);
		vertexesForFigure.clear();

		vertexesForFigure.add(new Vertex(3,0)); // 6
		vertexesForFigure.add(new Vertex(3,1));
		vertexesForFigure.add(new Vertex(4,1));
		vertexesForFigure.add(new Vertex(4,0)); // 9

		figures[1] = new Figure(vertexesForFigure);
		vertexesForFigure.clear();

		vertexesForFigure.add(new Vertex(3,2)); // 10
		vertexesForFigure.add(new Vertex(3,5));
		vertexesForFigure.add(new Vertex(4,5));
		vertexesForFigure.add(new Vertex(4,3));
		vertexesForFigure.add(new Vertex(7,3));
		vertexesForFigure.add(new Vertex(7,2)); //15

		figures[2] = new Figure(vertexesForFigure);
		vertexesForFigure.clear();
	}

	private static void window() {
		init();
		GUIGeoLab wind = new GUIGeoLab(figures);
	}

	public static void main(String[] args) {
		window();
	}
}
