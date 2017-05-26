import java.util.*;

class Shaker extends Sort
{
    public static void sort(Comparable[] a)
    {
        int left = 0;
        int right = a.length - 1;
        
        do
        {
            for (int i = left; i < right; i++)
                if (less(a[i + 1], a[i]))
                    exch(a, i, i + 1);
            right--;
            for (int i = right; i > left; i--)
                if (less(a[i], a[i - 1]))
                    exch(a, i, i - 1);
            left++;
        } while (left <= right);
    }
    public static void main(String[] args)
    {
        Integer[] a = In.readStrings(args[0]);
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
