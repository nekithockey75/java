import java.util.*;

class N1
{
    public static int checkDistance(char a, char b) {
        return (a > b ? a - b : b - a);
    }
    public static boolean cycleShift(String s, String t) {
        if (s.length() == t.length()) {
            for (int i = 1; i < s.length(); i++)
                if (checkDistance(s.charAt(i), t.charAt(i)) != checkDistance(s.charAt(i-1), t.charAt(i-1)))
                    return false;
            return true;
        } else
            return false;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input1 = s.nextLine();
        String input2 = s.nextLine();
        System.out.println(cycleShift(input1, input2) ? "is cycle shift" : "is not cycle shift");
    }
}
