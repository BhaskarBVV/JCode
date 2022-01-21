import java.util.*;

public class editor3 {
    public static Scanner sc = new Scanner(System.in);
    static int cnt;

    public static int[] findAllIndices(int i, int val, int[] a) {
        if (i == a.length) {
            int[] indices = new int[cnt];  // this array will be created in heap
            return indices;
        }
        if (a[i] == val)
            cnt += 1;
        int[] res_array = findAllIndices(i + 1, val, a);
        if (a[i] == val) {
            cnt -= 1;
            res_array[cnt] = i;
        }
        return res_array;
    }

    static void solve() {
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
        System.out.println("Enter val whose indices are to stored: ");
        int x = sc.nextInt();
        cnt = 0;
        int[] ans = findAllIndices(0, x, a);
        System.out.println("indices are: ");
        for (int it : ans)
            System.out.print(it + " ");
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
