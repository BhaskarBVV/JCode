//  In a single move you are allowed to jump 1 or more steps horizontally (as h1, h2, .. ), 
// or 1 or more steps vertically (as v1, v2, ..) or 1 or more steps diagonally (as d1, d2, ..). 

//Top down approach, added the V,H,D while returning, into the returned list.

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
        for (int jump = 1; sr + jump <= dr; jump++) {
            ArrayList<String> horizontal_res = getMazePaths(sr + jump, sc, dr, dc);
            for (String it : horizontal_res)
                ans.add("H" + (jump) + it);
        }
        for (int jump = 1; sc + jump <= dc; jump++) {
            ArrayList<String> vertical_res = getMazePaths(sr, sc + jump, dr, dc);
            for (String it : vertical_res)
                ans.add("V" + (jump) + it);
        }
        for (int jump = 1; sc + jump <= dc && sr + jump <= dr; jump++) {
            ArrayList<String> vertical_res = getMazePaths(sr + jump, sc + jump, dr, dc);
            for (String it : vertical_res)
                ans.add("D" + (jump) + it);
        }
        return ans;
    }

    public static void main(String[] args) throws Exception {
        int n = sc.nextInt(), m = sc.nextInt();
        ArrayList<String> ans = getMazePaths(0, 0, n - 1, m - 1);
        System.out.println(ans);
    }

}
