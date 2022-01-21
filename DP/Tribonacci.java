import java.util.Arrays;
import java.util.Scanner;

public class editor {
    public static Scanner sc = new Scanner(System.in);

    public static int tib(int n, int[] dp) {
        if (n <= 1) {
            dp[n] = n;
            return dp[n];
        }
        if (n == 2) {
            dp[2] = 1;
            return dp[2];
        }
        if (dp[n] != -1)
            return dp[n];

        dp[n] = tib(n - 1, dp) + tib(n - 2, dp) + tib(n - 3, dp);
        return dp[n];
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int ans = tib(n, dp);
        System.out.println(ans);
    }
}
