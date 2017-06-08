import java.util.*;
import java.io.File;
import java.io.IOException;

class N3
{
	private static ArrayList<Integer> mergeSimilar(Integer[] a, Integer[] b) {
		Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
		ArrayList<Integer> r = new ArrayList<Integer>();
		for (Integer e : a)
			map.put(e, false);
		for (Integer e : b) {
			if (map.get(e) != null)
				map.put(e, true);
		}
		for (Integer key : map.keySet()) {
			if (map.get(key))
				r.add(key);
		}

		return r;
	}
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(new File(args[0]));
		Integer n = s.nextInt();
		Integer[] a1 = new Integer[n];
		Integer[] a2 = new Integer[n];
		for (Integer i = 0; i < n; i++)
			a1[i] = s.nextInt();
		for (Integer i = 0; i < n; i++)
			a2[i] = s.nextInt();
		System.out.println(mergeSimilar(a1, a2));
	}
}