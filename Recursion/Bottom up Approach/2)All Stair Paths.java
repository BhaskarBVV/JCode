// neeche se hi ans ko jodte hue gye hain

import java.util.*;

public class editor2 {
    public static Scanner sc = new Scanner(System.in);

    // ---------------------Method 1 ---------------------------------
    public static void getStairPathBotUp(int cur_stair, int fianl_stair, String ans_string) {
        if (fianl_stair == cur_stair) {
            System.out.println(ans_string);
            return;
        }
        if (cur_stair + 1 <= fianl_stair) {
            getStairPathBotUp(cur_stair + 1, fianl_stair, 1 + ans_string);
        }
        if (cur_stair + 2 <= fianl_stair) {
            getStairPathBotUp(cur_stair + 2, fianl_stair, 2 + ans_string);
        }
        if (cur_stair + 3 <= fianl_stair) {
            getStairPathBotUp(cur_stair + 3, fianl_stair, 3 + ans_string);
        }
    }

    // ----------------------Method 2----------------------------------
    public static void printStairPaths(int remaining_steps, String ans_string) {
        if (remaining_steps == 0) {
            System.out.println(ans_string);
            return;
        }
        if (remaining_steps - 1 >= 0) {
            printStairPaths(remaining_steps - 1, 1 + ans_string);
        }
        if (remaining_steps - 2 >= 0) {
            printStairPaths(remaining_steps - 2, 2 + ans_string);
        }
        if (remaining_steps - 3 >= 0) {
            printStairPaths(remaining_steps - 3, 3 + ans_string);
        }
    }

    public static void main(String[] args) throws Exception {
        int n = sc.nextInt(), a = 0;
        String s = "";
        System.out.println("M1");
        getStairPathBotUp(a, n, s);
        System.out.println("\nM2");
        printStairPaths(n, s);
    }

}
