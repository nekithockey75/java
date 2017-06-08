import java.util.*;
import java.io.IOException;
import java.io.File;

class N13
{
	private static Integer n;
	private static Integer[][] graph;

	private static Integer[][] floid;

	private static void processFloid() {
		for (int k = 0; k < n; k++)
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					if (floid[i][k] < Integer.MAX_VALUE && floid[k][j] < Integer.MAX_VALUE)
						floid[i][j] = Math.min(floid[i][j], floid[i][k] + floid[k][j]);
	}
	private static void readData(String fileName) throws IOException {
    	Scanner s = new Scanner(new File(fileName));
		n = s.nextInt();
		graph = new Integer[n][n];
		floid = new Integer[n][n];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				graph[i][j] = s.nextInt();
				floid[i][j] = graph[i][j] == 0 ? Integer.MAX_VALUE : graph[i][j];
			}
	}
	private static void printGraph(Integer[][] g) {
		for (int i = 0; i < g.length; i++) {
			for (int j = 0; j < g.length; j++)
				System.out.print((g[i][j] == Integer.MAX_VALUE ? 0 : g[i][j]) + " ");
			System.out.println();
		}
	}
    public static void main(String[] args) throws IOException {
		readData(args[0]);
		printGraph(floid);
		processFloid();
		printGraph(floid);
    }
}
