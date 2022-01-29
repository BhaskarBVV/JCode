import java.util.*;

public class editor2 {
    public static Scanner sc = new Scanner(System.in);

    public static int GetMaxOfIRow(int i, int j, int[][] dp, int[][] gold) {
        if (i >= gold.length || i < 0 || j >= gold[0].length || j < 0)
            return 0;
        if (dp[i][j] != 0)
            return dp[i][j];
        int up = GetMaxOfIRow(i - 1, j + 1, dp, gold);
        int straight = GetMaxOfIRow(i, j + 1, dp, gold);
        int down = GetMaxOfIRow(i + 1, j + 1, dp, gold);
        dp[i][j] = gold[i][j] + Math.max(up, Math.max(down, straight));
        return dp[i][j];
    }

    public static void main(String args[]) {
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] gold = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                gold[i][j] = sc.nextInt();
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++)
            GetMaxOfIRow(i, 0, dp, gold);
        // for (int[] it : dp) {
        // for (int i : it)
        // System.out.print(i + " ");
        // System.out.println();
        // }
        int ans = 0;
        for (int i = 0; i < n; i++)
            ans = Math.max(ans, dp[i][0]);
        System.out.println(ans);
        sc.close();
    }
}
