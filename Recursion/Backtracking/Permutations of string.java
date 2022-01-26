import java.util.*;

public class editor {
    public static Scanner sc = new Scanner(System.in);

    public static void print(String s, String ans) {
        if (s.length() == 0) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            String rem = s.substring(0, i) + s.substring(i + 1);
            print(rem, ans + c);
        }
    }

    public static void main(String[] args) {
        String s = sc.next();
        String ans = "";
        print(s, ans);
    }
}


