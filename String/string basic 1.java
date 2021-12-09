import java.util.*;

public class editor {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String s = sc.nextLine();
        String a = "ABC";
        String b = "Hello World";
        String c = new String("Bhaskar Sir");
        String d = new String("Hello Bhaskar Sir");
        String e = new String("Hello");
        char x = s.charAt(3);
        System.out.println(s.length());
        System.out.println(s);
        System.out.println(x);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        String z = e + a;
        System.out.println("Concatenation result : " + z);
        char temp = sc.next().charAt(3);
        System.out.println(temp);
    }
}
