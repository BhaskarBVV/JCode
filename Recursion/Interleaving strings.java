import java.util.*;

public class editor {
    public static Scanner sc = new Scanner(System.in);

    public static Boolean StringHelper(String a, int i, String b, int j, String s3) {
        if (i == a.length() && j == b.length())
            return true;
        if (i < a.length() && a.charAt(i) == s3.charAt(i + j)) {
            boolean inc_a = StringHelper(a, i + 1, b, j, s3);
            if (inc_a == true)
                return true;
        }
        if (j < b.length() && b.charAt(j) == s3.charAt(i + j)) {
            boolean inc_b = StringHelper(a, i, b, j + 1, s3);
            if (inc_b == true)
                return true;
        }
        return false;
    }

    public static boolean isInterleave(String s1, String s2, String s3) {

        return StringHelper(s1, 0, s2, 0, s3);
    }

    public static void main(String args[]) {
        boolean ans = isInterleave("abcd", "efgh", "aebfcgdh");
        System.out.println(ans);
        sc.close();
    }
}
