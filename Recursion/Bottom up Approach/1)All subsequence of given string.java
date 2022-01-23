//------------------------------------------------------------Method 1--------------------------------------------------------
// returning the entire list of subsequences with out printing.
import java.util.*;

public class editor2 {
    public static Scanner sc = new Scanner(System.in);
    static ArrayList<String> fin;

    public static void getSeq(String s, ArrayList<String> res) {
        if (s.length() == 0) {
            for (String it : res)
                fin.add(it);
            return;
        }
        char a = s.charAt(0);
        ArrayList<String> ans = new ArrayList<>();
        for (String it : res)
            ans.add(it);
        for (String it : res)
            ans.add(it + a);
        getSeq(s.substring(1), ans);
    }

    public static void main(String[] args) throws Exception {
        String s = sc.next();
        fin = new ArrayList<>();
        ArrayList<String> res = new ArrayList<>();
        res.add("");
        getSeq(s, res);
        System.out.println(fin);
    }

}


//------------------------------------------------------------Method 2--------------------------------------------------------
// without returning the entire list of subsequences and by printing on reaching the base case.

import java.util.*;

public class editor2 {
    public static Scanner sc = new Scanner(System.in);
    static ArrayList<String> fin;

    public static void getSeq(String s, String ans) {
        if (s.length() == 0) {
            System.out.println(ans);
            return;
        }
        getSeq(s.substring(1), ans + s.charAt(0));
        getSeq(s.substring(1), ans + "");
    }

    public static void main(String[] args) throws Exception {
        String s = sc.next(), ans = "";
        getSeq(s, ans);
    }

} 
