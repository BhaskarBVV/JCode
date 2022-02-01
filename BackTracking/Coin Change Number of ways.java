// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
// Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
// You may assume that you have an infinite number of each kind of coin.

// for detailed Explainiation see Combination Sum.cpp   https://github.com/BhaskarBVV/PenCode/blob/main/BackTracking/Combination%20Sum.cpp

import java.util.*;

public class JavaEditor2 {
    public static Scanner sc = new Scanner(System.in);

    public static void coinChange(int[] coins, int sum, int csum, ArrayList<Integer> al, int Ithcoin) {
        if (csum > sum)
            return;
        if (sum == csum) {
            System.out.println(al);
            return;
        }
        for (int i = Ithcoin; i < coins.length; i++) {
            csum += coins[i];
            al.add(coins[i]);
            coinChange(coins, sum, csum, al, i);
            csum -= coins[i];
            al.remove(al.size() - 1);
        }
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++)
            coins[i] = sc.nextInt();
        int target = sc.nextInt(), cur_sum = 0;
        ArrayList<Integer> al = new ArrayList<>();
        coinChange(coins, target, cur_sum, al, 0);
    }
}
