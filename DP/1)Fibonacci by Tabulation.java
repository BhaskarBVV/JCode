import java.util.Arrays;
import java.util.Scanner;

public class editor {
    public static Scanner sc = new Scanner(System.in);

    // steps to convert memorization to tabulation
    // return - x
    // memorizatoin - x
    // calls->array
    // public static int fib(int n, int[] dp) {
    public static int fibTabulation(int N, int[] dp) {
        for (int n = 0; n < dp.length; n++) {
            if (n <= 1) {
                dp[n] = n;
                // return dp[n];
                continue;
            }
            // if (dp[n] != -1)
            // return dp[n]; <<--remove it;

            // dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
            dp[n] = dp[n - 1] + dp[n - 2];
            // return dp[n];
            continue;
        }
        return dp[N];
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int ans = fibTabulation(n, dp);
        System.out.println(ans);
    }
}
