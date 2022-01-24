import java.util.*;

public class editor2 {
    public static Scanner sc = new Scanner(System.in);

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static void getMazePaths(int sr, int sc, int dr, int dc, String ans) {
        if (sr == dr && sc == dc) {
            System.out.println(ans);
            return;
        }
        if (sr + 1 <= dr) // moving in row >
        {
            getMazePaths(sr + 1, sc, dr, dc, "H" + ans);
        }
        if (sc + 1 <= dc) // moving in column ^
        {
            getMazePaths(sr, sc + 1, dr, dc, "V" + ans);
        }
    }

    public static void main(String[] args) throws Exception {
        int n = sc.nextInt(), m = sc.nextInt();
        String ans = "";
        getMazePaths(0, 0, n - 1, m - 1, ans);
    }

}
