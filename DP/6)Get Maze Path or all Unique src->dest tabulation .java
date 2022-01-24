// done by tabulation
// started forming the dp array from beginning(0,0)
// ans will be found at dp[n-1][m-1].
// dp[i][j]= dp[i-1][j]+dp[i][j-1];
// dp[0][0]=1, bcz the number of ways on its own position =1.
// let source=(0,0) and dest=(0,0), then number of ways will be 1,
// hence dp[0][0]=1.

//Input: m = 3, n = 7
// Output: 28

import java.util.*;

public class editor {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println("Enter the rows : ");
        int n = sc.nextInt();
        System.out.println("Enter the columns : ");
        int m = sc.nextInt();
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
        int a = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a = 0;
                if (i - 1 >= 0)
                    a += dp[i - 1][j];
                if (j - 1 >= 0)
                    a += dp[i][j - 1];
                if (a != 0)
                    dp[i][j] = a;
            }
        }
        System.out.println(dp[n - 1][m - 1]);
    }

}
