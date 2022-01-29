import java.util.*;

public class editor {
    public static Scanner sc = new Scanner(System.in);

    public static int getPath(int i, int j, int n, int m) {
        if (i == 0 && j == 0) {
            return 1;
        }
        int ans = 0;
        if (i - 1 >= 0)
            ans += getPath(i - 1, j, n, m);
        if (j - 1 >= 0)
            ans += getPath(i, j - 1, n, m);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Enter the number of rows :");
        int n = sc.nextInt();
        System.out.println("Enter the number of columns :");
        int m = sc.nextInt();
        int ans = getPath(n - 1, m - 1, n, m);
        System.out.println("Total ways :");
        System.out.println(ans);
    }
}
