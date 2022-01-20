import java.util.*;

public class editor3 {
    public static Scanner sc = new Scanner(System.in);

    public static int firstOccur(int[] a, int val, int i) {
        if (i == a.length)
            return -1;
        if (a[i] == val)
            return i;
        return firstOccur(a, val, i + 1);
    }

    static void solve() {
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        System.out.println("Enter the value whose first index is to be calculated: ");
        int val = sc.nextInt();
        System.out.println(firstOccur(a, val, 0));
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
