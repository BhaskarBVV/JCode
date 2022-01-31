// 1. You are given a number n, representing the count of elements.
// 2. You are given n numbers.
// 3. You are given a number "tar".
// 4. You are required to calculate and print true or false, if there is a subset the elements of which add up to "tar" or not.
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

//Sol:

// current taregt = j;
// agar main(x=a[i-1], bcz i toh ek jaada chal rhi hai, matrix main index 1 se array ke elements ko imagine kiya hua hai), khela toh kya remaining target sum mere upar wale generate kr paa rhe hain
// matlab check (remaining target sum = j-a[i-1]) in just above row ( in above rows the sum would/ wouldn't have been achieved by my previous elements).


// agar main ni khela toh remaining target sum = j = j - 0(main ni khela toh maine toh 0 hi run banaye), kya mere upar wale bana paa rhe hain(dp[i-1][j])





import java.util.*;

public class editor {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        int n = sc.nextInt();
        int[] a = new int[n];
//---------------------------------------------
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();
//---------------------------------------------
        int target = sc.nextInt();

        boolean[][] dp = new boolean[n + 1][target + 1];
//---------------------------------------------
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < target + 1; j++)
                dp[i][j] = false;
        }
//---------------------------------------------
        boolean excluded = false, included = false;
      
//---------------------------------------------
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < target + 1; j++) {
              
                if (i == 0 && j == 0)
                    dp[i][j] = true;
              
                else if (i == 0)
                    dp[i][j] = false;
              
                else if (j == 0)
                    dp[i][j] = true;
              
                else {
                    included = false;
                    excluded = false;
                    if (j - a[i - 1] >= 0)
                        included = dp[i - 1][j - a[i - 1]];
                    excluded = dp[i - 1][j];
                    dp[i][j] = included || excluded;
                }
            }
        }
//---------------------------------------------
        System.out.println(dp[n][target]);
        sc.close();
    }
}
