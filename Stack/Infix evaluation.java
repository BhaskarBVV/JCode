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

    public static int get_val(int a, int b, char ch) {
        if (ch == '+')
            return a + b;
        else if (ch == '*')
            return a * b;
        else if (ch == '/')
            return a / b;
        return a - b;
    }

    public static void main(String[] args)
    {

        String infix = sc.nextLine();
        Stack<Integer> number = new Stack<>();
        Stack<Character> operator = new Stack<>();

        char ch;

        for (int i = 0; i < infix.length(); i++) {
            ch = infix.charAt(i);
            if (ch == '(')       
                operator.push(ch);            
          else if (ch == ')') 
          {
                while (!operator.empty() && operator.peek() != '(')
                {
                    int val2 = number.pop();
                    int val1 = number.pop();
                    char opr = operator.pop();
                    int ans = get_val(val1, val2, opr);
                    number.push(ans);
                }
                operator.pop();// removed opening bracket.
           } 
          else if (ch >= '0' && ch <= '9')
          {
                number.push(ch - '0');
          } 
          else if (is_operator(ch)) 
          {
                while (!operator.empty() && operator.peek() != '(' && precedence(ch) <= precedence(operator.peek())) 
                {
                    int val2 = number.pop();
                    int val1 = number.pop();
                    char opr = operator.pop();
                    int ans = get_val(val1, val2, opr);
                    number.push(ans);
                }
                operator.push(ch);
            }
        }
        while (!operator.empty()) 
        {
            int val2 = number.pop();
            int val1 = number.pop();
            char opr = operator.pop();
            int ans = get_val(val1, val2, opr);
            number.push(ans);
        }
        System.out.println(number.peek());
    }
}
