import java.util.Arrays;

public class Shell
{
	public static void sort(Comparable[] a)
	{
		int n = a.length;
		int h = 1;
		while (h < n/3) h = 3*h + 1; // 1, 4, 13, 40, 121, 264 ...
		while (h >= 1)
		{
			for (int i = h; i < n; i++)
			{ //insertion of a[i] between a[i-h], a[i-2*h], a[i-3*h] ...
				for (int j = i; j >= h && less(a[j], a[j-h]); j -= h)
					exch(a, j, j - h);
				System.out.println(Arrays.toString(a));
			}
			System.out.println(Arrays.toString(a) + "=");
			h /= 3;
		}
	}

	private static boolean less(Comparable v, Comparable w)
	{ return v.compareTo(w) < 0; }

	public static void exch(Comparable[] a, int i, int j)
	{ Comparable t = a[i]; a[i] = a[j]; a[j] = t; }

	private static void show(Comparable[] a)
	{
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}

	private static boolean isSorted(Comparable[] a)
	{
		for (int i = 1; i < a.length; i++)
			if (less(a[i], a[i - 1])) return false;
		return true;
	}

	public static void main(String[] args)
	{
		Integer[] a = In.readStrings(args[0]);
		sort(a);
		assert isSorted(a);
		show(a);
	}
}