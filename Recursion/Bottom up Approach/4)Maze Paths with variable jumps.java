// 1. You are given a number n and a number m representing number of rows and columns in a maze.
// 2. You are standing in the top-left corner and have to reach the bottom-right corner. 
// 3. In a single move you are allowed to jump 1 or more steps horizontally (as h1, h2, .. ), or 1 or more steps vertically (as v1, v2, ..) or 1 or more steps diagonally (as d1, d2, ..). 
// 4. Complete the body of printMazePath function - without changing signature - to print the list of all paths that can be used to move from top-left to bottom-right


//-------------------------------------------------------------Method 1------------------------------------

import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void getMazePaths(int sr, int sc, int dr, int dc, String ans) {
        if (sr == dr && sc == dc) {
            System.out.println(ans);
            return;
        }
        for (int i = 1; sc + i <= dc; i++) // moving in column ^
        {
            getMazePaths(sr, sc + i, dr, dc,ans+ "h" + i);
        }
        for (int i = 1; sr + i <= dr; i++) // moving in row >
        {
            getMazePaths(sr + i, sc, dr, dc, ans+"v" + i);
        }
        for (int i = 1; sc + i <= dc && sr + i <= dr; i++) {
            getMazePaths(sr + i, sc + i, dr, dc, ans+"d" + i);
        }
    }

    public static void main(String[] args) {
        int n = sc.nextInt(), m = sc.nextInt();
        String ans = "";
        getMazePaths(0, 0, n - 1, m - 1, ans);
    }

}



//-------------------------------------------------------------Method 2 Using direction array------------------------------------
import java.util.*;

public class editor {
    public static Scanner sc = new Scanner(System.in);

    static int[][] dir = { { 0, 1 }, { 1, 0 }, { 1, 1 } };
    static char[] dirName = { 'h', 'v', 'd' };

    public static void getMazePaths(int sr, int sc, int dr, int dc, String ans) {
        if (sr == dr && sc == dc) {
            System.out.println(ans);
            return;
        }
        for (int d = 0; d < dir.length; d++)
            for (int jmp = 1; jmp <= Math.max(dr, dc); jmp++) {
                int nxt_row_val = sr + jmp * (dir[d][0]);
                int nxt_col_val = sc + jmp * (dir[d][1]);
                if (nxt_row_val >= 0 && nxt_row_val <= dr && nxt_col_val >= 0 && nxt_col_val <= dc)
                    getMazePaths(nxt_row_val, nxt_col_val, dr, dc, ans + dirName[d] + jmp);
            }
    }

    public static void main(String[] args) throws Exception {
        int n = sc.nextInt(), m = sc.nextInt();
        String ans = "";
        getMazePaths(0, 0, n - 1, m - 1, ans);
    }

}
