package Grid;

import java.util.Arrays;

public class MinFallingPathSum {
    public static void main(String[] args) {
        System.out.println(minFallingPathSum(new int[][] { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } }));
    }

    public static int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int minPathSum = (int) Math.pow(10, 9);

        int[][] dp = new int[row][col];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }

        for (int i = 0; i < col; i++) { // col could be 0,1,2,...... for last row
            // minPathSum = Math.min(minPathSum, minFallingPathSum(row - 1, i, matrix));
            minPathSum = Math.min(minPathSum, minFallingPathSumMemo(row - 1, i, matrix, dp));
        }

        // return minFallingPathSumTabu(matrix);
        return minFallingPathSumSpaceOpt(matrix);
    }

    private static int minFallingPathSum(int row, int col, int[][] matrix) {
        if (col < 0 || col >= matrix[0].length) {
            return (int) Math.pow(10, 9);
        }

        if (row == 0) {
            return matrix[row][col];
        }

        int straight = matrix[row][col] + minFallingPathSum(row - 1, col, matrix);
        int leftDiagonal = matrix[row][col] + minFallingPathSum(row - 1, col - 1, matrix);
        int rightDiagonal = matrix[row][col] + minFallingPathSum(row - 1, col + 1, matrix);

        return Math.min(straight, Math.min(leftDiagonal, rightDiagonal));
    }

    private static int minFallingPathSumMemo(int row, int col, int[][] matrix, int[][] dp) {
        if (col < 0 || col >= matrix[0].length) {
            return (int) Math.pow(10, 9);
        }

        if (row == 0) {
            return matrix[row][col];
        }
        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        int straight = matrix[row][col] + minFallingPathSumMemo(row - 1, col, matrix, dp);
        int leftDiagonal = matrix[row][col] + minFallingPathSumMemo(row - 1, col - 1, matrix, dp);
        int rightDiagonal = matrix[row][col] + minFallingPathSumMemo(row - 1, col + 1, matrix, dp);

        return dp[row][col] = Math.min(straight, Math.min(leftDiagonal, rightDiagonal));
    }

    private static int minFallingPathSumTabu(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int col = 0; col < matrix[0].length; col++) {
            dp[0][col] = matrix[0][col];
        }
        int upperBound = (int) Math.pow(10, 9);

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int straight = matrix[i][j] + dp[i - 1][j];
                int leftDiagonal = (j - 1 >= 0) ? matrix[i][j] + dp[i - 1][j - 1] : upperBound;
                int rightDiagonal = (j + 1 < matrix[0].length) ? matrix[i][j] + dp[i - 1][j + 1] : upperBound;
                dp[i][j] = Math.min(straight, Math.min(rightDiagonal, leftDiagonal));
            }
        }
        

        int min = upperBound;
        for (int i = 0; i < dp.length; i++) { 
            min = Math.min(min,dp[dp.length - 1][i]);
        }

        return min;
    }

    private static int minFallingPathSumSpaceOpt(int[][] matrix) {
        int n = matrix.length;
        int[] prev = new int[n];
        int[] curr = new int[n];
    
        for (int col = 0; col < n; col++) {
            prev[col] = matrix[0][col];
        }
        int upperBound = (int) Math.pow(10, 9);
    
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int straight = matrix[i][j] + prev[j];
                int leftDiagonal = (j - 1 >= 0) ? matrix[i][j] + prev[j - 1] : upperBound;
                int rightDiagonal = (j + 1 < n) ? matrix[i][j] + prev[j + 1] : upperBound;
                curr[j] = Math.min(straight, Math.min(leftDiagonal, rightDiagonal));
            }

            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
    
        int min = upperBound;
        for (int col = 0; col < n; col++) { 
            min = Math.min(min, prev[col]);
        }
    
        return min;
    }
    
}
