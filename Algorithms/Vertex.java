class Vertex extends Point {
	public boolean g; // = {false, true} if {вогнутый, выпуклый}
	public double x, y;

	Vertex() {}

	Vertex(double init_x, double init_y) {
		x = init_x;
		y = init_y;
	}
}
