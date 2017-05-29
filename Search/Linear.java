import java.util.*;

class Linear
{
    public static int search(Comparable[] a, Comparable e)
    {
        for (int i = 0; i < a.length; i++)
            if (a[i].compareTo(e) == 0)
                return i;
        return -1;
    }
    public static void main(String[] args)
    {
        Integer[] a = In.readStrings(args[0]);
        Integer element = Integer.parseInt(args[1]);
        int index = search(a, element);
        System.out.println(index);
    }
}
