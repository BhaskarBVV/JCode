import java.util.*;

public class editor {
    public static Scanner sc = new Scanner(System.in);

    public static int getPath(int i, int j, int n, int m, int[][] dp) {
        if (i == 0 && j == 0) {
            return dp[0][0] = 1;
        }
        if (dp[i][j] != 0)
            return dp[i][j];
        int ans = 0;
        if (i - 1 >= 0)
            ans += getPath(i - 1, j, n, m, dp);
        if (j - 1 >= 0)
            ans += getPath(i, j - 1, n, m, dp);
        dp[i][j] = ans;
        return dp[i][j];
    }

    public static void main(String[] args) {
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] dp = new int[n][m];
        for (int[] it : dp)
            Arrays.fill(it, 0);
        int ans = getPath(n - 1, m - 1, n, m, dp);
        System.out.println(ans);
    }
}
