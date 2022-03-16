import java.util.*;

public class JavaEditor1 {
    public static Scanner sc = new Scanner(System.in);

    public static boolean is_operator(char ch) {
        if (ch == '+' || ch == '-' || ch == '*' || ch == '/')
            return true;
        return false;
    }

    public static int precedence(char ch) {
        if (ch == '+' || ch == '-')
            return 1;
        return 2;
    }

    public static void main(String[] args) {

        String infix = sc.nextLine();
        // System.out.println(infix);
      
        Stack<String> postfix = new Stack<>();
        Stack<String> prefix = new Stack<>();
        Stack<Character> operator = new Stack<>();
      
        char ch;
      
        for (int i = 0; i < infix.length(); i++) {
            ch = infix.charAt(i);
          //----------------------------------------------------------------------------------------------
            if (ch == '(') {
                operator.push(ch);
            } 
          //----------------------------------------------------------------------------------------------
          else if ((ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
                prefix.push(ch + "");
                postfix.push(ch + "");
            } 
          //----------------------------------------------------------------------------------------------
          else if (ch == ')') {
                while (!operator.empty() && operator.peek() != '(') {
                    String prefixV2 = prefix.pop();
                    String prefixV1 = prefix.pop();
                    prefix.push(operator.peek() + prefixV1 + prefixV2);

                    String postfixV2 = postfix.pop();
                    String postfixV1 = postfix.pop();
                    postfix.push(postfixV1 + postfixV2 + operator.peek());
                    operator.pop();
                }
                operator.pop(); // removed the opening bracket;
            } 
          //----------------------------------------------------------------------------------------------
          else if (is_operator(ch) == true) {
                while (!operator.empty() && operator.peek() != '('
                        && precedence(ch) <= precedence(operator.peek())) {
                    String postfixV2 = postfix.pop();
                    String postfixV1 = postfix.pop();
                    postfix.push(postfixV1 + postfixV2 + operator.peek());

                    String prefixV2 = prefix.pop();
                    String prefixV1 = prefix.pop();
                    prefix.push(operator.peek() + prefixV1 + prefixV2);
                    operator.pop();
                }
                operator.push(ch);
            }
        }
      //----------------END OF FOR LOOP--------------------------------------------------------------|
      //---------------------------------------------------------------------------------------------|
        while (!operator.empty()) {
            String postfixV2 = postfix.pop();
            String postfixV1 = postfix.pop();
            postfix.push(postfixV1 + postfixV2 + operator.peek());

            String prefixV2 = prefix.pop();
            String prefixV1 = prefix.pop();
            prefix.push(operator.peek() + prefixV1 + prefixV2);
            operator.pop();
        }
        System.out.println(prefix.peek());
        System.out.println(postfix.peek());
    }
}
