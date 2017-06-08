import java.util.*;

class N2
{
	private static int findNext(String s, int n) {
		
	}
	private static String insert(String c, String s, int p) {
		return s.substring(0, p) + c + s.substring(p, s.length());
	}
	private static String complete(String original) {
		String modified = original;
		int index = original.length();
		while (index != 0) {
			index = findNext(modified, index);
			modified = insert("(", modified, index);
		}
		return modified;
	}

	public static void main(String[] args) {
		Scanner s = new Scaner(System.in);
		String expression = s.nextLine();
		System.out.println(complete(expression));
	}
}