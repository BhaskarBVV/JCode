import java.util.Arrays;
import java.util.Scanner;

public class editor {
    public static Scanner sc = new Scanner(System.in);

    public static int fib(int n, int[] dp) {
        if (n <= 1) {
            dp[n] = n;
            return dp[n];
        }
        if (dp[n] != -1)
            return dp[n];

        dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
        return dp[n];
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int ans = fib(n, dp);
        System.out.println(ans);
    }
}
