
class Vertex extends Point {
	private byte g; // = {0, 1} if {вогнутый, выпуклый}

	Vertex() {}

	Vertex(int init_x, int init_y) {
		this.x = init_x;
		this.y = init_y;
	}
}