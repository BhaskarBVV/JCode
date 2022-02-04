import java.util.*;

class JavaEditor2 {
    public static Scanner sc = new Scanner(System.in);

    public static int longestCommonSubsequence(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i < a.length() + 1; i++) {
            for (int j = 0; j < b.length() + 1; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = 0;
                else if (i == 0)
                    dp[i][j] = 0;
                else if (j == 0)
                    dp[i][j] = 0;
                else {
                    // a.charAt(i-1) and (j-1), bcz the actual alphabets are placed form 1-th index of dp
                    // not from 0, can refer to image.
                    if (a.charAt(i - 1) == b.charAt(j - 1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
        }
        return dp[a.length()][b.length()];
    }

    public static void main(String[] args) {
        String s1 = sc.next(), s2 = sc.next();
        int ans = longestCommonSubsequence(s1, s2);
        System.out.println(ans);
    }
}
