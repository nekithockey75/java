import java.util.*;
import java.io.File;

public class In
{
	public static Integer[] readStrings(String fileName) {
		Integer[] a;
		try {
			File file = new File(fileName);
			if (file.exists())
			{
				Scanner s = new Scanner(file);
				int k = 0;
				while (s.hasNext())
				{
					s.next();
					k++;
				}
				a = new Integer[k];
				k = 0;
				s.close();
				s = new Scanner(file);
				while (s.hasNext())
				{
					a[k] = s.nextInt();
					k++;
				}
				for (int l = 0; l < a.length; l++)
				s.close();
				return a; 
			}
			return null;
		} catch (Exception e) {
			return null;
		}
	}
}