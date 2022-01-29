import java.util.*;

public class editor2 {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {

        // since, in recursive code we moved right into the matrix and answer/ max gold coin values
        // were obtained while returning, hence dp[][] matrix will be filled from backward.

        int n = sc.nextInt(), m = sc.nextInt(), a;
        int[][] gold = new int[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                gold[i][j] = sc.nextInt();

        int[][] dp = new int[n][m];
        // ans will be obtained from the max value of the first column.

        for (int i = 0; i < n; i++) // filling the last column;
            dp[i][m - 1] = gold[i][m - 1];

        for (int j = m - 2; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                a = Integer.MIN_VALUE;
                if (i - 1 >= 0)
                    a = Math.max(a, dp[i - 1][j + 1]);
                if (i + 1 < n)
                    a = Math.max(a, dp[i + 1][j + 1]);
                a = Math.max(a, dp[i][j + 1]);
                dp[i][j] = gold[i][j] + a;
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++)
            ans = Math.max(ans, dp[i][0]);
        System.out.println(ans);
        sc.close();
    }
}
