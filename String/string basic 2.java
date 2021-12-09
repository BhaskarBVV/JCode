import java.util.*;

public class editor {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String a = "Hello";
        String b = "Hello";
        if (a == b)
            System.out.println("yes");
        else
            System.out.println("No");  // Ans: Yes. Comparison by address. In java Both Hello will be at same address.

      
      
        String c = "Hello";
        String d = new String("Hello");
        if (c == d)
            System.out.println("yes");
        else
            System.out.println("No");  // Ans: No. Here Hello (of c) and and Hello created by new (of d) are at different address, 
                                       //and in java there is comparison by address in case of strings.

      
      // To compare by values for strings at different locations, use .equals() function.
        String e = "Hello";
        String f = new String("Hello");
        if (e.equals(f) == true)
            System.out.println("yes");
        else
            System.out.println("No"); // Ans: Yes, Here values are compared not addresses. Here both hello are at differnet address.
    }
}
