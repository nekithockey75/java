import java.util.*;

class Quick extends Sort
{
    public static void sort(Comparable[] a)
    {
        quickSort(a, 0, a.length - 1);
    }
    public static void quickSort(Comparable[] a, int left, int right)
    {
        Comparable x = a[left + (right - left) / 2];
        int i = left, j = right;
        do
        {
            while (less(a[i], x)) i++;
            while (less(x, a[j])) j--;
            if (i <= j)
            {
                exch(a, i, j);
                i++; j--;
            }
        } while (i <=  j); 
        if (less(left, j))
            quickSort(a, left, j);
        if (less(i, right))
            quickSort(a, i, right);
    }
    private static boolean lessOrEqual(Comparable v, Comparable w)
    { return v.compareTo(w) <= 0; }
    public static void main(String[] args)
    {
        Integer[] a = In.readStrings(args[0]);
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
