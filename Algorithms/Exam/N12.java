import java.util.*;
import java.io.*;

class N12
{
	static Integer[][] graph;
	static Integer n;

	private static boolean containsLoops() {
		for (int i = 0; i < n; i++)
			if (graph[i][i] != 0)
				return true;
		return false;
	}
	private static boolean containsIsolatedVertex() {
		int counter = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) continue;
				else if (graph[i][j] != 0) counter++;
			}
			if (counter == 0) return true;
		}
		return false;
	}
	private static int graphPower() {
		Integer sum = 0;
		Integer max = 0;
		for (int i = 0; i < n; i++) {
			sum = 0;
			for (int j = 0; j < n; j++)
				sum += graph[i][j];
			max = ((sum > max) ? sum : max);
		}
		return max;
	}
	private static void printEdges() {
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (graph[i][j] != 0)
					System.out.println(i + " - " + j);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(new File(args[0]));

		n = s.nextInt();
		graph = new Integer[n][n];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				graph[i][j] = s.nextInt();

		System.out.println((containsLoops() ? "" : "do not ") + "contains loops");
		System.out.println((containsIsolatedVertex() ? "" : "do not ") + "contains isolated vertex");
		System.out.println("Power is " + graphPower());
		printEdges();
	}
}