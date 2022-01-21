import java.util.Scanner;

public class editor {
    public static Scanner sc = new Scanner(System.in);

    public static int climbStair(int n) {
        if (n == 0) {
            return 1;
        }
        int cnt = 0;
        if (n - 1 >= 0)
            cnt += climbStair(n - 1);
        if (n - 2 >= 0)
            cnt += climbStair(n - 2);
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println("Enter the number of stairs : ");
        int n = sc.nextInt();
        int ans = climbStair(n);
        System.out.println("Total Number of ways " + ans);
    }
}
