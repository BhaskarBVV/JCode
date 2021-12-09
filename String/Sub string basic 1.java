import java.util.*;

public class editor {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String a = "Hello World";
        System.out.println(a.substring(2));// begin index till end of string.
        System.out.println(a.substring(2, 7));// begin index till end index, end index not included,
        // don't confuse with that of C++ substring, there it was starting index or
        // starting index and length from starting index.

    }
}
