// It is a top down approach with recurion, building the solution while returning, or while coming down in recursive tree.
// The Bottom up approach with recursion, building the solution while going up in the recursion tree in done in C++, refer Pencode/.

import java.util.*;

public class editor2 {
    public static Scanner sc = new Scanner(System.in);
    static String[] codes = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public static ArrayList<String> KeyComb(String s) {
        if (s.length() == 0) {
            ArrayList<String> res = new ArrayList<>();
            res.add("");
            return res;
        }
        int cur_num = s.charAt(0) - '0';
        ArrayList<String> returned_list = KeyComb(s.substring(1));
        ArrayList<String> ans = new ArrayList<>();
        String cur_num_keys = codes[cur_num];
        for (int i = 0; i < cur_num_keys.length(); i++) {
            for (String it : returned_list)
                ans.add(cur_num_keys.charAt(i) + it);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = sc.next();
        ArrayList<String> ans = KeyComb(s);
        for (String it : ans) {
            System.out.println(it);
        }
    }
}
