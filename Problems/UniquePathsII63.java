/* Description
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?
 _ _ _ _ _ _ _ 
|s|_|_|_|_|_|_|
|_|_|_|_|_|_|_|
|_|_|_|_|_|_|f|

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Note: m and n will be at most 100.

Example 1:

Input:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
Output: 2
Explanation:
There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right
*/

//LintCode
/**/

/**
 * UniquePathsII63
 */
public class UniquePathsII63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int n = obstacleGrid.length;
        ;
        int m = obstacleGrid[0].length;
        int[][] paths = new int[n][m];

        for (int i = 0; i < n; i++) {
            if (obstacleGrid[i][0] != 1) {
                paths[i][0] = 1;
            } else {
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[0][i] != 1) {
                paths[0][i] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] != 1) {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                } else {
                    paths[i][j] = 0;
                }
            }
        }
        return paths[n - 1][m - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = { { 1 } };
        System.out.println(new UniquePathsII63().uniquePathsWithObstacles(obstacleGrid));
        int[][] obstacleGrid1 = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        System.out.println(new UniquePathsII63().uniquePathsWithObstacles(obstacleGrid1));
    }
}