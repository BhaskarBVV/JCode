import java.util.*;

public class editor2A {
    public static Scanner sc = new Scanner(System.in);

    public static int stringHelper(int i, int j, String a, String b) {
      //------------------------------------------------------------------------ agar ek string empty ho jaayegi toh common kahan se milega
        if (i >= a.length() || j >= b.length())
            return 0;
     //------------------------------------------------------------------------- agar dono letters commmon hain i,j par toh common letters ka count  1 se bhada do and dono ko i+1, j+1 se call krdo
        if (a.charAt(i) == b.charAt(j))
            return 1 + stringHelper(i + 1, j + 1, a, b);
    //------------------------------------------------------------------------- agar eqaul ni hain toh, syd i, j+1 equal hoon ya i+1,j equal toh, isliye inse call lagao ab.
        return Math.max(stringHelper(i + 1, j, a, b), stringHelper(i, j + 1, a, b));
    }

    public static int longestCommonSubsequence(String a, String b) {
        return stringHelper(0, 0, a, b);
    }

    public static void main(String args[]) {
        String a = sc.next(), b = sc.next();
        int ans = longestCommonSubsequence(a, b);
        System.out.println(ans);
    }

}
