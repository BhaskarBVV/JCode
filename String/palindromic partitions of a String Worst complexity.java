import java.util.*;

public class editor {
    public static boolean is_palindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next(), temp;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                temp = s.substring(i, j);
                // System.out.println(temp);
                if (is_palindrome(temp))
                    System.out.println(temp);
            }
        }
        sc.close();
    }
}
