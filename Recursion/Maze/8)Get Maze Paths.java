// Done with top down approach,  building the solution while returning, or while coming down in recursive tree.
// can refer to the tree in 6)All Stair Paths.java

import java.util.*;

public class editor2 {
    public static Scanner sc = new Scanner(System.in);

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if (sr == dr && sc == dc) {
            ArrayList<String> end = new ArrayList<>();
            end.add("");
            return end;
        }
        ArrayList<String> ans = new ArrayList<>();
        if (sr + 1 <= dr) // moving in row >
        {
            ArrayList<String> horizontal_res = getMazePaths(sr + 1, sc, dr, dc);
            for (String it : horizontal_res)
                ans.add('H' + it);
        }
        if (sc + 1 <= dc) // moving in column ^
        {
            ArrayList<String> vertical_res = getMazePaths(sr, sc + 1, dr, dc);
            for (String it : vertical_res)
                ans.add('V' + it);
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        int n = sc.nextInt(), m = sc.nextInt();
        ArrayList<String> ans = getMazePaths(0, 0, n - 1, m - 1);
        System.out.println(ans);
    }

}
