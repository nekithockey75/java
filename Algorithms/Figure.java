import java.util.*;

class Figure {
	public int id;
	private int pointCount = 0;
	public List<Point> vertexes;
	private static int[][] field;
	private static int HEIGHT, WIDTH;
	private static final int LEFT = 0, TOP = 1, RIGHT = 2, BOTTOM = 3;

	public static void setField(int[][] f) {
		HEIGHT = f.length; WIDTH = f[0].length;
		field = new int[HEIGHT][WIDTH];
		for (int i = 0; i < HEIGHT; i++)
			for (int j = 0; j < WIDTH; j++)
				field[i][j] = (f[i][j] == 1 || f[i][j] == 2 || f[i][j] == 0 ? 0 : 1);
		}

	}

	public void addPoint(Point point) {
		vertexes.add(point);
		this.pointCount++;
	}


	public int count() {
		return this.pointCount;
	}

	private static boolean empty(Point p, int direction) {
		switch (direction) {
			case LEFT: // <- \ |
				if (p.x > 0 && p.y > 0)
					return (space(p.x, p.y-1) && space(p.x-1, p.y-1) && space(p.x-1, p.y));
				else if (p.x == 0 && p.y > 0)
					return space(p.x, p.y-1);
				else if (p.x > 0 && p.y == 0)
					return space(p.x-1, p.y);
				else if (p.x == 0 && p.y == 0)
					return true;
				return false;
			case TOP: // | / ->
				if (p.x > 0 && p.y < WIDTH-1)
					return (space(p.x-1, p.y) && space(p.x-1, p.y+1) && space(p.x, p.y+1));
				else if (p.x  == 0 && p.y < WIDTH-1)
					return space(p.x, p.y+1);
				else if (p.x > 0 && p.y == WIDTH-1)
					return space(p.x-1, p.y);
				else if (p.x == 0 && p.y == WIDTH-1)
					return true;
				return false;
			case RIGHT: // -> \ |
				if (p.x < HEIGHT-1 && p.y < WIDTH-1)
					return (space(p.x, p.y+1) && space(p.x+1, p.y+1) && space(p.x+1, p.y));
				else if (p.x  == HEIGHT-1 && p.y < WIDTH-1)
					return space(p.x, p.y+1);
				else if (p.x < HEIGHT-1 && p.y == WIDTH-1)
					return space(p.x+1, p.y);
				else if (p.x == HEIGHT-1 && p.y == WIDTH-1)
					return true;
				return false;
			case BOTTOM: // | / <-
				if (p.x < HEIGHT-1 && p.y > 0)
					return (space(p.x+1, p.y) && space(p.x+1, p.y-1) && space(p.x, p.y-1));
				else if (p.x == HEIGHT-1 && p.y > 0)
					return space(p.x, p.y-1);
				else if (p.x < HEIGHT-1 && p.y == 0)
					return space(p.x+1, p.y);
				else if (p.x == HEIGHT-1 && p.y == 0)
					return true;
				return false;
			default: System.out.println("ERROR"); return false;
		}
	}

	private static boolean space(int x, int y) {
		return field[x][y] == 0;
	}

	private static boolean wall(int x, int y) {
		return field[x][y] == 3;
	}

}