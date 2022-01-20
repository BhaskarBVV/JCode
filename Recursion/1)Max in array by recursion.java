import java.util.*;

public class editor3 {
    public static Scanner sc = new Scanner(System.in);

    public static int maxx(int[] a, int i) {
        if (i + 1 == a.length)
            return a[i];
        int maxval = maxx(a, i + 1);
        if (maxval > a[i])
        return maxval;
        return a[i];
        // or
        // return Math.max(a[i], maxx(a, i + 1));
    }

    static void solve() {
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        System.out.println(maxx(a, 0));
    }

    public static void main(String[] args) {
        int n;
        n = 1;
        // n = sc.nextInt();
        while (n-- > 0) {
            solve();
        }
        sc.close();
    }
}
