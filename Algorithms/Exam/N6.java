import java.util.*;
import java.io.File;
import java.io.IOException;

class N6
{
	private static ArrayList<Point> points = new ArrayList<>();
	
	private static Double distance(Integer a, Integer b) {
		Double y = points.get(a).y - points.get(b).y;
		Double x = points.get(a).x - points.get(b).x;
		return Math.sqrt(x*x + y*y);
	}

	private static Double perimeter(Integer a, Integer b, Integer c) {
		return distance(a, b) + distance(b, c) + distance(c, a);
	}

	private static void printTriangle() {
		Double perimeter = 0.0;
		Integer a = 0, b = 1, c = 2;
		for (int i = 0; i < points.size(); i++) {
			for (int j = 0; j < points.size() - 1; j++) {
				for (int k = 0; k < points.size() - 2; k++) {
					if (perimeter(i, j, k) > perimeter) {
						a = i; b = j; c = k;
						perimeter = perimeter(i, j, k);
					}
				}
			}
		}
		System.out.println(points.get(a) + " " + points.get(b) + " " + points.get(c));
	}

	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(new File(args[0]));
		Double x, y;
		while (s.hasNext()) {
			x = s.nextDouble();
			y = s.nextDouble();
			points.add(new Point(x, y));	
		}
		printTriangle();
	}
}