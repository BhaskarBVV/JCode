import java.util.*;

public class editor2 {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] maze = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        int a = 0;
        int[][] dp = new int[n][m];
        dp[0][0] = maze[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a = Integer.MAX_VALUE;
                if (i - 1 >= 0)
                    a = dp[i - 1][j];
                if (j - 1 >= 0)
                    a = Math.min(a, dp[i][j - 1]);
                if (a == Integer.MAX_VALUE)
                    a = 0;
                dp[i][j] = maze[i][j] + a;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(dp[n - 1][m - 1]);
    }

}
