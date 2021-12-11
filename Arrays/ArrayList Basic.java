import java.util.*;

public class editor {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Integer> v = new ArrayList<>();
        v.add(19);
        v.add(12);
        v.add(13);
        v.add(14);
        v.add(15);
        for (int it : v)
            System.out.println(it);
      
        System.out.println();
        for (int i = 0; i < 5; i++)
            System.out.println(v.get(i));
        // array array List
        // arr[i] arl.get(i)
        // arr.length arl.size()
        // since Java is purely object oriented, but int is primitive datatype( have no
        // object then how java is pure object based)
        // Hence, a wrapper class Integer was made, now int will be object of Integer.
        System.out.println(v.get(3));
    }
}
