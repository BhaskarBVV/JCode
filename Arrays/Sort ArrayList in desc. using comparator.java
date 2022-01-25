import java.util.*;

public class editor {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> al = new ArrayList<>();
        System.out.println("Enter the size of arrayList : ");
        int n = sc.nextInt();
        System.out.println("Enter the list : ");
        while (n-- > 0) {
            al.add(sc.nextInt());
        }
        Collections.sort(al, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                if (a == b)
                    return a;
                return b - a;
            }
        });
        System.out.println(al);
    }
}
