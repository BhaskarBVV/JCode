// 1. You are given a number n, representing the number of stairs in a staircase.
// 2. You are on the 0th step and are required to climb to the top.
// 3. You are given n numbers, where ith element's value represents - till how far from the step you 
//      could jump to in a single move.  
//      You can of course jump fewer number of steps in the move.
// 4. You are required to print the number of different paths via which you can climb to the top.

// Ip: 
// 10
// 3 3 0 2 1 2 4 2 0 0
// Op: 5

import java.util.*;

public class editor {
    public static Scanner sc = new Scanner(System.in);

    public static int totalPaths(int[] arr, int[] dp, int source, int dest) {
        if (source == dest) {
            return dp[source] = 1;
        }
        if (dp[source] != -1)
            return dp[source];
        int cnt = 0;
        for (int jmp = 1; jmp <= arr[source] && source + jmp <= dest; jmp++)
            cnt += totalPaths(arr, dp, source + jmp, dest);
        return dp[source] = cnt;
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        System.out.println(totalPaths(a, dp, 0, n));
    }

}
