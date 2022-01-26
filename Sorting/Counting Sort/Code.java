import java.util.*;

public class editor2 {
    public static Scanner sc = new Scanner(System.in);

    public static void countSort(int[] a, int mx_range) {
        int[] b = new int[mx_range];
        int[] c = new int[a.length];

        Arrays.fill(b, 0);

        for (int i = 0; i < a.length; i++)
            b[a[i]]++;
        for (int i = 1; i < mx_range; i++)
            b[i] = b[i] + b[i - 1];

        for (int i = a.length - 1; i >= 0; i--) {
            c[b[a[i]] - 1] = a[i];
            b[a[i]] -= 1;
        }
        for (int i = 0; i < a.length; i++)
            a[i] = c[i];
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Enter the number of elements : ");
        int n = sc.nextInt(), mx_range = Integer.MIN_VALUE;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            mx_range = Math.max(mx_range, a[i]);
        }
        countSort(a, mx_range + 1);
        System.out.println("Array after sorting : ");
        for (int i = 0; i < n; i++)
            System.out.println(a[i]);
    }

}
