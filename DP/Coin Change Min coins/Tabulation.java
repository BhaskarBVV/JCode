import java.util.*;

class JavaEditor2 {
    public static Scanner sc = new Scanner(System.in);

    public static int coinChange(int[] coins, int sum) {
        Arrays.sort(coins);

        int[] dp = new int[sum + 1];

        dp[0] = 0; // No. of coins needed for sum=0 is 0, but number of ways/ combination for sum=0 will be 1;

        for (int i = 1; i < sum + 1; i++)
            dp[i] = Integer.MAX_VALUE - 100000;

        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (j - coins[i] >= 0)
                    dp[j] = Math.min(dp[j], 1 + dp[j - coins[i]]);
            }
            // for (int k = 0; k < sum + 1; k++)
            // System.out.print(dp[k] + " ");
            // System.out.println();
        }
        if (dp[sum] == Integer.MAX_VALUE - 100000)
            return -1;
        return dp[sum];
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        int amount = sc.nextInt();
        int ans = coinChange(a, amount);
        System.out.println(ans);
    }
}
