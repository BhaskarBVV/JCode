import java.util.*;

public class editor2 {
    public static Scanner sc = new Scanner(System.in);

    public static int GetMaxOfIRow(int i, int j, int[][] gold) {
        if (i >= gold.length || i < 0 || j >= gold[0].length || j < 0)
            return 0;
        int up = GetMaxOfIRow(i - 1, j + 1, gold);
        int straight = GetMaxOfIRow(i, j + 1, gold);
        int down = GetMaxOfIRow(i + 1, j + 1, gold);
        return gold[i][j] + Math.max(up, Math.max(down, straight));
    }

    public static void main(String args[]) {
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] gold = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                gold[i][j] = sc.nextInt();
        int ans = 0, temp;
        for (int i = 0; i < n; i++) {
            temp = GetMaxOfIRow(i, 0, gold);
            ans = Math.max(temp, ans);
        }
        System.out.println(ans);
        sc.close();
    }
}
