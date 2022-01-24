import java.util.Arrays;
import java.util.Scanner;

public class editor {
    public static Scanner sc = new Scanner(System.in);

    public static int climbStairMemorisation(int n, int[] dp) {
        if (n == 0) {
            dp[0] = 1;
            return dp[0];
        }
        if (dp[n] != -1)
            return dp[n];
        int cnt = 0;
        if (n - 1 >= 0)
            cnt += climbStairMemorisation(n - 1, dp);
        if (n - 2 >= 0)
            cnt += climbStairMemorisation(n - 2, dp);
        dp[n] = cnt;
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println("Enter the number of stairs : ");
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int ans = climbStairMemorisation(n, dp);
        System.out.println("Total Number of ways " + ans);
    }
}
