import java.util.*;

public class JavaEditor2 {
    public static Scanner sc = new Scanner(System.in);

  // DP wali array ke indexes current taregt sum ko represent kr rhe hain.
  // jab target = 0, toh number of ways 1 hain, kuki koi coin mat do.
  // First Loop coins par hai and second loop current target sum pr.
  
  //let current target be = 5 and current coin =4, toh 4-5<0 toh koi treeka ni
  //let current target be = 5 and current coin =5, toh 5-5>=0 and 0 ko pay krne 1 tareeka hai, isliye 1 ways for 5,5
//   let current target be = 6 and current coin =5, toh 6-5=1(>=0) toh number of ways = number of ways to pay 1.
  
  
  
    public static int coinChange(int[] coins, int sum, int[] dp) {
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (j - coins[i] >= 0)
                    dp[j] += dp[j - coins[i]];
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        System.out.println("Enter the number of coins : ");
        int n = sc.nextInt();
        int[] coins = new int[n];
        System.out.println("Enter the array : ");
        for (int i = 0; i < n; i++)
            coins[i] = sc.nextInt();
        System.out.println("Enter the target sum : ");
        int target = sc.nextInt();
        int[] dp = new int[target + 1];
        coinChange(coins, target, dp);
        System.out.println("Total number of ways : ");
        System.out.println(dp[target]);
    }
}
