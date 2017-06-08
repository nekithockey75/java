import java.util.*;
import java.io.File;
import java.io.IOException;

class N5
{
	private static ArrayList<Integer> c1 = new ArrayList<>(), c2 = new ArrayList<>();

	private static ArrayList<Integer> merge(ArrayList<Integer> a1, ArrayList<Integer> a2) {
		int count1 = 0;
		int count2 = 0;

		ArrayList<Integer> m = new ArrayList<>();

		while (count1 != a1.size() || count2 != a2.size()) {
			if (count1 == a1.size()) {
				for (int i = count2; i < a2.size(); i++)
					m.add(a2.get(i));
				break;
			} else if (count2 == a2.size()) {
				for (int i = count1; i < a1.size(); i++)
					m.add(a1.get(i));
				break;
			} else {
				if (a1.get(count1) <= a2.get(count2)) {
					m.add(a1.get(count1));
					count1++;
				} else {
					m.add(a2.get(count2));
					count2++;
				}
			}
		}
		return m;
	}

	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(new File(args[0]));
		Integer buffer;
		boolean first = true;

		while (s.hasNext()) {
			buffer = s.nextInt();
			if (buffer < 0) {
				first = !first;
				continue;
			}
			if (first)
				c1.add(buffer);
			else
				c2.add(buffer);
		}

		Collections.sort(c1);
		Collections.sort(c2);

		ArrayList<Integer> m = merge(c1, c2);
		System.out.println(m);
	}
}