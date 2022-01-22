import java.util.*;

public class editor {
    public static Scanner sc = new Scanner(System.in);

    public static ArrayList<String> getStairPaths(int n) {
        if (n == 0) {
            ArrayList<String> end = new ArrayList<>();
            end.add("");
            return end;
        }
        ArrayList<String> ans = new ArrayList<>();
        if (n - 1 >= 0) {
            ArrayList<String> a1 = getStairPaths(n - 1);
            for (String it : a1)
                ans.add('1' + it);
        }

        if (n - 2 >= 0) {
            ArrayList<String> a2 = getStairPaths(n - 2);
            for (String it : a2)
                ans.add('2' + it);
        }
        if (n - 3 >= 0) {
            ArrayList<String> a3 = getStairPaths(n - 3);
            for (String it : a3)
                ans.add('3' + it);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        ArrayList<String> a = getStairPaths(n);
        System.out.println("The ways are: ");
        for (String it : a)
            System.out.println(it);
    }

}
