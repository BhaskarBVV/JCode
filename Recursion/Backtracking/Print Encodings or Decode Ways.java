// A message containing letters from A-Z can be encoded into numbers using the following mapping:
// 'A' -> "1"
// 'B' -> "2"
// ...
// 'Z' -> "26"

// Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
// Input: s = "12"
// Output: 2
// Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).

// Input: s = "226"
// Output: 3
// Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

// Input: s = "06"
// Output: 0

// "303" invalid 
// "101"->ja only
// Given a string s containing only digits, return the number of ways to decode it.


import java.util.*;

public class editor {
    public static Scanner sc = new Scanner(System.in);

    public static char inc(int x) {
        char a = 'a';
        while (x-- > 0)
            ++a;
        return a;
    }

    public static void print(String s, String ans) {
        if (s.length() == 0) {
            System.out.println(ans);
            return;
        }
        if (s.charAt(0) == '0') {
            return;
        } else {
            int x = s.charAt(0) - '0';
            print(s.substring(1), ans + inc(x - 1));
            if (s.length() >= 2) {
                x = (x * 10) + (s.charAt(1) - '0');
                if (x <= 26) {
                    print(s.substring(2), ans + inc(x - 1));
                }
            }
        }
    }

    public static void main(String[] args) {
        String s = sc.next();
        String ans = "";
        print(s, ans);
    }
}
