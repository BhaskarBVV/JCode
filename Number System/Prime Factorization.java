import java.util.*;

public class editor {
    public static Scanner sc = new Scanner(System.in);

    public static void prime_factors(int n, ArrayList<Integer> v) {
        int flag;
        for (int i = 2; i * i <= n; i++) {
            flag = 1;
            while (n % i == 0) {
                flag = 0;
                n /= i;
            }
            if (flag == 0)
                v.add(i);
        }
        if (n != 1)
            v.add(n);
    }

    public static void main(String[] args) {

        int n = sc.nextInt();
        ArrayList<Integer> v = new ArrayList<>();
        prime_factors(n, v);
        System.out.println("Prime Factors of " + n + " are : ");
        for (Integer it : v)
            System.out.println(it);
        sc.close();
    }
}
