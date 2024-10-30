package Grid;

import java.util.Arrays;

public class MinPathSum {
    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }));
    }

    public static int minPathSum(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }

        // return minSum(row - 1, col - 1, grid);
        // return minSumMemo(row - 1, col - 1, grid, dp);
        return minSumTabu(row - 1, col - 1, grid);
    }

    private static int minSum(int row, int col, int[][] grid) {
        if (row == 0 && col == 0) {
            return grid[row][col];
        }

        if (row < 0 || col < 0) {

            // don't take INT_MAX in the base condition for (row < 0 || col < 0)
            // as when we will reach the base condition it will be added to
            // the value of previous state which is grid[row][col] ,
            // and it will lead to integer overflow ,so just use a bigger number like 1e9

            // or we can simply modify return case by using grid[row][col] +
            // Math.min(up,left);
            return (int) Math.pow(10, 9);
        }

        int left = grid[row][col] + minSum(row, col - 1, grid);
        int up = grid[row][col] + minSum(row - 1, col, grid);

        return Math.min(left, up);
    }

    private static int minSumMemo(int row, int col, int[][] grid, int[][] dp) {
        if (row == 0 && col == 0) {
            return grid[row][col];
        }

        if (row < 0 || col < 0) {

            // don't take INT_MAX in the base condition for (row < 0 || col < 0)
            // as when we will reach the base condition it will be added to
            // the value of previous state which is grid[row][col] ,
            // and it will lead to integer overflow ,so just use a bigger number like 1e9

            // or we can simply modify return case by using grid[row][col] +
            // Math.min(up,left);
            return (int) Math.pow(10, 9);
        }
        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        int left = grid[row][col] + minSumMemo(row, col - 1, grid, dp);
        int up = grid[row][col] + minSumMemo(row - 1, col, grid, dp);

        return dp[row][col] = Math.min(left, up);
    }
    
    // wrong tabulation answer
    private static int minSumTabu(int row, int col, int[][] grid) {

        int[][] dp = new int[row + 1][col + 1];
        dp[0][0] = grid[0][0];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[0][0];
                } else {
                    int up = grid[i][j];
                    int left = grid[i][j];
                    if (i > 0) {
                        up += dp[i - 1][j];
                    } else {
                        up += ((int) Math.pow(10, 9));
                    }
                    if (j > 0) {
                        left += dp[i][j - 1];
                    } else {
                        left += ((int) Math.pow(10, 9));
                    }
                    dp[i][j] = Math.min(up, left);
                }
            }
        }

        return dp[row - 1][col - 1];
    }
}
