// An MxN integer array grid is handed to you. At first, there is a deer in the top-left corner 
// (i.e., grid [0][0]). The deer strives to get to the bottom-right corner of the screen (i.e., 
// grid[m-1] [n-1]). At any given time, the deer can only go down or right. In the grid, a tiger 
// is represented by 1 and a space by 0. Any square that is a tiger cannot be part of the 
// deer's path.
// Return the number of different pathways the deer could take to get to the bottom-right 
// corner.

package Week7;

public class week7 {

    class Grid {

        static int UniquePathHelper(int i, int j, int m, int n,
                                    int[][] A)
        {
            // boundary condition or constraints
            if (i == m || j == n) {
            return 0;
            }
        
            if (A[i][j] == 1) {
            return 0;
            }
        
            // base case
            if (i == m - 1 && j == n - 1) {
            return 1;
            }
        
            return UniquePathHelper(i + 1, j, m, n, A)
            + UniquePathHelper(i, j + 1, m, n, A);
        }
        
        static int uniquePathsWithObstacles(int[][] A)
        {
        
            int m = A.length, n = A[0].length;
        
            return UniquePathHelper(0, 0, m, n, A);
        }
        
        // Driver Code
        public static void main(String[] args)
        {
            int[][] A
            = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        
            System.out.print(uniquePathsWithObstacles(A));
        }
    
}
}