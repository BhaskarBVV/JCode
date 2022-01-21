// main approach ye hai ki, let s="abc", then hum 'a' ko nikaal lenge and "bc" ke liye recursion call krenge
// ab 'b' ko nikaal lenge and "c" ke liye recurison call krenge...
// ab 'c' ko nikaal lenge and "" ke liye recurison call krenge...
// "" will become my base case, ab return krte wakt ek baar 'c' {""} isme add hoga and ek baar no hoga => jab hoga add tab {"c"} and jab ni hoga tab {""}, and hume in dono ko ek hi list main rakhna hai {"","c"}
//ab 'b' ek baar add hoga and ek baar ni hoga in {"", "c"}=>{add ni hua-> "","c", add hua-> "b","bc"}
// similarly jab return krke 'a' ke paas aayenge tab 'a' ek baar add ni hoga and ek baar add hoga.

//----------------------------------------------------------------Method 1 passing list as parameter---------------------------------------------------------------------------------
import java.util.ArrayList;
import java.util.Scanner;

public class editor {
    public static Scanner sc = new Scanner(System.in);

    public static void sub(int i, String s, ArrayList<String> a) {
        if (i == s.length()) {
            a.add("");
            return;
        }
        sub(i + 1, s, a);
        int tot_size = a.size();
        for (int k = 0; k < tot_size; k++) {
            a.add(s.charAt(i) + a.get(k));
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter the string");
        String s = sc.next();
        ArrayList<String> a = new ArrayList<>();
        sub(0, s, a);
        System.out.println("The subsequences are : ");
        for (String it : a)
            System.out.println(it + " ");
    }
}

//----------------------------------------------------------------Method 1 Not passing list as parameter---------------------------------------------------------------------------------
import java.util.ArrayList;
import java.util.Scanner;

public class editor {
    public static Scanner sc = new Scanner(System.in);

    public static ArrayList<String> sub(String s) {
        //base case
        if (s == "") {
            ArrayList<String> a = new ArrayList<>();
            a.add("");
            return a;
        }
         
         
        //calls lagate samay, jab string empty ni hui hai...
        char current_extracted = s.charAt(0); // first char nikaal liya, ab baadmein return ke time ye ek baar add hoga and ek baar ni.
        String remaining_of_str = s.substring(1); // poori string end tak from index 1.
        // string ko tod tod ko bhej rhe hain, toh first character hi nikaal rhe hain, and remaining string ke apna subsequence le aayegi, and ab ye nikaala hua char ek baar add hoga and ek baar ni.
        ArrayList<String> a = sub(remaining_of_str);
        
      
        //calls se laute samay, ek baar add krte hue and ek baar bina add krte hue...
        int tot_size_ofList = a.size();
        for (int i = 0; i < tot_size_ofList; i++) {
            a.add(current_extracted + a.get(i));
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println("Enter the string");
        String s = sc.next();
        ArrayList<String> a = sub(s);
        System.out.println("The subsequences are : ");
        for (String it : a)
            System.out.println(it + " ");
    }
}
