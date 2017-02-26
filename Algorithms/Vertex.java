class Vertex extends Point {
	public boolean g; // = {false, true} if {вогнутый, выпуклый}
	public double xx, yy;

	Vertex() {}

	Vertex(int init_x, int init_y) {
		x = init_x;
		y = init_y;
		xx = (double)init_x;
		yy = (double)init_y;
	}

	Vertex(double init_x, double init_y) {
		xx = init_x;
		yy = init_y;
	}
}
