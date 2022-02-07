import java.util.*;

public class temp {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int n = sc.nextInt(), k = sc.nextInt();
        if (n == 1) {
            System.out.println(k);
            return;
        }
        if (n == 0) {
            System.out.println(0);
            return;
        }
        int xx = k;
        int xy = k * (k - 1);
        int t1, t2;
        for (int i = 3; i <= n; i++) {
            t1 = xy;
            t2 = xx * (k - 1) + xy * (k - 1);
            xx = t1;
            xy = t2;
        }
        System.out.println(xx + xy);
    }
}
