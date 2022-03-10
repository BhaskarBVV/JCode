// 1. You are given a string exp representing an expression. 
// 2. Assume that the expression is balanced i.e. the opening and closing brackets match with each other.
// 3. But, some of the pair of brackets maybe extra/needless. 
// 4. You are required to print true if you detect extra brackets and false otherwise. 
// e.g. ((a + b) + (c + d)) -> false 
// (a + b) + ((c + d)) -> true

import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static boolean no_dup(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (st.empty())
                st.push(s.charAt(i));
            else if (s.charAt(i) == ')') {
                if (st.peek() == '(')
                    return true;
                while (!st.empty() && st.peek() != '(') {
                    st.pop();
                }
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }
        return false;
    }

    public static void main(String args[]) {
        String s = sc.nextLine();
        if (no_dup(s) == true)
            System.out.println("true");
        else
            System.out.println("false");
    }
}
