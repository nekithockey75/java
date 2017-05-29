import java.util.*;

class Heap extends Sort
{
    public static void sort(Comparable[] a)
    {
        heapify(a, a.length);
        int end = a.length - 1;
        while (end > 0)
        {
            exch(a, 0, end);
            shiftDown(a, 0, end - 1);
            end--;
        }
    }
    private static void heapify(Comparable[] a, int count)
    {
        int start = (count - 2) / 2;
        while (start >= 0)
        {
            shiftDown(a, start, count - 1);
            start--;
        }
    }
    private static void shiftDown(Comparable[] a, int start, int end)
    {
        int root = start;
        while ((root * 2 + 1) <= end)
        {
            int child = root * 2 + 1;
            if (child + 1 <= end && less(a[child], a[child + 1]))
                child++;
            if (less(a[root], a[child]))
            {
                exch(a, root, child);
                root = child;
            }
            else
                return;
        }
    }
    public static void main(String[] args)
    {
        Integer[] a = In.readStrings(args[0]);
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
