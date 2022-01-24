// done by tabulation
// started forming the dp array from beginning(0,0)
// ans will be found at dp[n-1][m-1].
// dp[i][j]= dp[i-1][j]+dp[i][j-1];
// dp[0][0]=1, bcz the number of ways on its own position =1.
// let source=(0,0) and dest=(0,0), then number of ways will be 1,
// hence dp[0][0]=1.



//QUESTION: 
// A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
// The robot can only move either down or right at any point in time. 
// The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
// Now consider if some obstacles are added to the grids. How many unique paths would there be?
// An obstacle and space is marked as 1 and 0 respectively in the grid.

// Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
// Output: 2
// Explanation: There is one obstacle in the middle of the 3x3 grid above.
// There are two ways to reach the bottom-right corner:
// 1. Right -> Right -> Down -> Down
// 2. Down -> Down -> Right -> Right

// Input: obstacleGrid = [[0,1],[0,0]]
// Output: 1





    import java.util.*;

    public class editor2 {
        public static Scanner sc = new Scanner(System.in);

        public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int n = obstacleGrid.length, m = obstacleGrid[0].length;
            int[][] dp = new int[n][m];
            dp[0][0] = 1;
            int a = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (obstacleGrid[i][j] == 1) { // if there is an obstacle then total paths on it = 0, bcz that position cannot be reached.
                        dp[i][j] = 0;
                        continue;
                    }
                    a = 0;
                    if (i - 1 >= 0 && obstacleGrid[i - 1][j] != 1) // if the previous pos.(i-1,j) is in bound and is not an obstacle.
                        a += dp[i - 1][j];
                    if (j - 1 >= 0 && obstacleGrid[i][j - 1] != 1) // if the previous pos.(i,j-1) is in bound and is not an obstacle.
                        a += dp[i][j - 1];
                    if (a != 0) // ye conditoin (0,0) ki wajah se lagai hai, bcz dp[0][0]=1 hai and a=0 hi rahega bcz i-1, j-1 out of bound honge (0,0) ke liye toh dp[0][0]=0 ho jaayega
                      // aisa na ho isliye use kiya hai ye condition.
                        dp[i][j] = a;
                }
            }
            return dp[n - 1][m - 1];
        }

        public static void main(String[] args) throws Exception {
            System.out.println("Enter the rows : ");
            int n = sc.nextInt();
            System.out.println("Enter the columns : ");
            int m = sc.nextInt();
            int[][] obstacleGrid = new int[n][m];
            System.out.println("Enter the obstacles and open spaces in obstacleGrid matrix ");
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    obstacleGrid[i][j] = sc.nextInt();
            int ans = uniquePathsWithObstacles(obstacleGrid);
            System.out.println("The total number of ways are : " + ans);
        }

    }
