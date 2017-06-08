import java.util.*;
import java.io.File;
import java.io.IOException;

class N4
{
	private static Integer[] group;
	private static HashMap<Integer, Integer> collection = new HashMap<>();

	private static boolean connected(Integer a, Integer b) {
		return group[a] == group[b];
	}
	private static void connect(Integer a, Integer b) {
		group[a] = group[b];
	}
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(new File(args[0]));
		Integer n = s.nextInt(), p, q;
		group = new Integer[2 * n];
		for (int i = 0; i < group.length; i++) {
			group[i] = i;
		}
		for (int i = 0; i < n; i++) {
			p = s.nextInt(); q = s.nextInt();
			if (!connected(p, q)) {
				collection.put(p, q);
				connect(p, q);
				System.out.println("Adding " + p + " " + q);
			}
		}
	}
}