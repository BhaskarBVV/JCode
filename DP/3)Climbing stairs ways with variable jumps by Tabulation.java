import java.util.*;

public class editor {
    public static Scanner sc = new Scanner(System.in);

    public static int totalPathsT(int[] arr, int[] dp, int SRC, int dest) {
        for (int src = dp.length - 1; src >= SRC; src--) {
            if (src == dest) {
                dp[src] = 1;
                continue;
            }

            int count = 0;
            for (int jump = 1; jump <= arr[src] && jump + src <= dest; jump++) {
                count += dp[src + jump];
            }
            dp[src] = count;
        }
        return dp[SRC];
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        System.out.println(totalPathsT(a, dp, 0, n));
    }

}
