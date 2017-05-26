import java.util.*;

class Exchange extends Sort
{
    public static void sort(Comparable[] a)
    {
        int n = a.length;
        for (int i = 0; i < a.length; i++)
            for (int j = i; j < a.length; j++)
                if (less(a[j], a[i]))
                    exch(a, i, j);
    }
    public static void main(String[] args)
    {
        Integer[] a = In.readStrings(args[0]);
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
