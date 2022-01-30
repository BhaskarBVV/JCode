import java.util.*;

public class editor {
    public static Scanner sc = new Scanner(System.in);

    public static Boolean StringHelper(String a, int i, String b, int j, String s3, Boolean[][] dp) {
        if (i == a.length() && j == b.length())
            return true;
        if (dp[i][j] != null)
            return dp[i][j];
        if (i < a.length() && a.charAt(i) == s3.charAt(i + j)) {
            Boolean inc_a = StringHelper(a, i + 1, b, j, s3, dp);
            dp[i][j] = inc_a;
            if (inc_a == true)
                return true;
        }
        if (j < b.length() && b.charAt(j) == s3.charAt(i + j)) {
            Boolean inc_b = StringHelper(a, i, b, j + 1, s3, dp);
            dp[i][j] = inc_b;
            if (inc_b == true)
                return true;
        }
        dp[i][j] = false;
        return false;
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        Boolean[][] dp = new Boolean[s1.length() + 1][s2.length() + 1];
        return StringHelper(s1, 0, s2, 0, s3, dp);
    }

    public static void main(String args[]) {
        boolean ans = isInterleave("abcd", "efgh", "aebfcgdh");
        System.out.println(ans);
        sc.close();
    }
}
