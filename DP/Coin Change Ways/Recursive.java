import java.util.*;

public class JavaEditor2 {
    public static Scanner sc = new Scanner(System.in);

    public static int coinChange(int[] coins, int sum, int csum, int Ithcoin) {
        if (csum > sum)
            return 0;
        if (sum == csum) {
            return 1;
        }
        int cnt = 0;
        for (int i = Ithcoin; i < coins.length; i++) {
            cnt += coinChange(coins, sum, csum + coins[i], i);
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println("Enter the number of coins : ");
        int n = sc.nextInt();
        int[] coins = new int[n];
        System.out.println("Enter the array : ");
        for (int i = 0; i < n; i++)
            coins[i] = sc.nextInt();
        System.out.println("Enter the target sum : ");
        int target = sc.nextInt(), cur_sum = 0;
        int ans = coinChange(coins, target, cur_sum, 0);
        System.out.println("Total number of ways : ");
        System.out.println(ans);
    }
}
