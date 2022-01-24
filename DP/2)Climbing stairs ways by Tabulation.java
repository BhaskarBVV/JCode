import java.util.Arrays;
import java.util.Scanner;

public class editor {
    public static Scanner sc = new Scanner(System.in);

    public static int climbStairTabulation(int N, int[] dp) {
        dp[0] = 1;
        for (int n = 1; n <= N; n++) {
            int cnt = 0;
            if (n - 1 >= 0)
                cnt += dp[n - 1];
            if (n - 2 >= 0)
                cnt += dp[n - 2];
            dp[n] = cnt;
        }
        return dp[N];
    }

    public static void main(String[] args) {
        System.out.println("Enter the number of stairs : ");
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int ans = climbStairTabulation(n, dp);
        System.out.println("Total Number of ways " + ans);
    }
}
