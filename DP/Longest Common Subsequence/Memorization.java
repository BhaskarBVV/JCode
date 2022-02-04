import java.util.*;

class JavaEditor2 {
    public static Scanner sc = new Scanner(System.in);

    public static int stringHelper(int i, int j, String a, String b, int[][] dp) {
        if (i >= a.length() || j >= b.length())
            return 0;
        if (dp[i][j] != 0)
            return dp[i][j];
        if (a.charAt(i) == b.charAt(j))
            return dp[i][j] = 1 + stringHelper(i + 1, j + 1, a, b, dp);
        return dp[i][j] = Math.max(stringHelper(i + 1, j, a, b, dp), stringHelper(i, j + 1, a, b, dp));
    }

    public static int longestCommonSubsequence(String a, String b) {
        int[][] dp = new int[a.length()][b.length()];
        stringHelper(0, 0, a, b, dp);
        return dp[0][0];
    }

    public static void main(String[] args) {
        String s1 = sc.next(), s2 = sc.next();
        int ans = longestCommonSubsequence(s1, s2);
        System.out.println(ans);
    }
}
