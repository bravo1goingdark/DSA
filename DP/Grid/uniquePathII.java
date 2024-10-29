package Grid;

import java.util.Arrays;

public class uniquePathII {
    public static void main(String[] args) {
        int[][] maze = new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 }, { 1, 0, 0 } };
        System.out.println(uniquePathsWithObstacles(maze));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // return uniquePathsWithObstacles(obstacleGrid.length - 1,
        // obstacleGrid[0].length - 1, obstacleGrid);
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        // return uniquePathsWithObstaclesMemo(obstacleGrid.length - 1,
        // obstacleGrid[0].length - 1, obstacleGrid, dp);
        return uniquePathsWithObstaclesTabu(obstacleGrid.length - 1, obstacleGrid[0].length - 1, obstacleGrid);
    }

    private static int uniquePathsWithObstacles(int row, int col, int[][] obstacleGrid) {
        if (row == 0 && col == 0 && obstacleGrid[0][0] == 0) {
            return 1;
        }

        if (row < 0 || col < 0 || obstacleGrid[row][col] == 1) {
            return 0;
        }

        int left = uniquePathsWithObstacles(row, col - 1, obstacleGrid);
        int up = uniquePathsWithObstacles(row - 1, col, obstacleGrid);

        return left + up;

    }

    public static int uniquePathsWithObstaclesMemo(int row, int col, int[][] obstacleGrid, int[][] dp) {
        if (row == 0 && col == 0 && obstacleGrid[0][0] == 0) {
            return 1;
        }

        if (row < 0 || col < 0 || obstacleGrid[row][col] == 1) {
            return 0;
        }
        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        int left = uniquePathsWithObstaclesMemo(row, col - 1, obstacleGrid, dp);
        int up = uniquePathsWithObstaclesMemo(row - 1, col, obstacleGrid, dp);

        return dp[row][col] = left + up;
    }


    // wrong tabulation answer
    public static int uniquePathsWithObstaclesTabu(int row, int col, int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1)
            return 0;

        int[][] dp = new int[row][col];
        dp[0][0] = 1; // Starting position

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0)
                    continue;

                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    int left = (j > 0) ? dp[i][j - 1] : 0;
                    int up = (i > 0) ? dp[i - 1][j] : 0;
                    dp[i][j] = left + up;
                }
            }
        }
        return dp[row - 1][col - 1];
    }

}
