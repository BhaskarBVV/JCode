import java.util.*;

public class editor2 {
    public static Scanner sc = new Scanner(System.in);
    static boolean found;

    public static void sum(int i, int cur_sum, int target, int[] a) {
        if (cur_sum == target) {
            found = true;
            return;
        }
        if (i >= a.length)
            return;
        if (found == true) // If already found then no need to make calls again.
            return;
        sum(i + 1, cur_sum + a[i], target, a); // ek baar cur sum main add krenge a[i] ko
        sum(i + 1, cur_sum + 0, target, a); // and ek baar ni krenge.
    }

    public static void main(String args[]) {
        int n = sc.nextInt();
      
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
      
        int target = sc.nextInt();
      
        int cur_sum = 0, i = 0;
        found = false;
      
      
        sum(i, cur_sum, target, a);
        System.out.println(found);
        sc.close();
    }
}
