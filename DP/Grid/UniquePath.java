package Grid;

import java.util.Arrays;

public class UniquePath {
    public static void main(String[] args) {

        int[][] dp = new int[3][3];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        // System.out.println(uniquePathRecur(1, 1));
        // System.out.println(uniquePathMemo(2, 2, dp));
        System.out.println(uniquePathTabu(3, 3));
    }

    public static int uniquePathRecur(int row, int col) {
        if (row == 0 && col == 0) {
            return 1;
        }

        if (row < 0 || col < 0) {
            return 0;
        }

        int left = uniquePathRecur(row, col - 1);
        int up = uniquePathRecur(row - 1, col);

        return left + up;
    }

    public static int uniquePathMemo(int row, int col, int[][] dp) {
        if (row == 0 && col == 0) {
            return 1;
        }

        if (row < 0 || col < 0) {
            return 0;
        }
        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        int left = uniquePathMemo(row, col - 1, dp);
        int up = uniquePathMemo(row - 1, col, dp);

        return dp[row][col] = left + up;
    }

    public static int uniquePathTabu(int row, int col) {
        int[][] dp = new int[row + 1][col + 1];
        dp[0][0] = 1;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int up = (i > 0) ? dp[i - 1][j] : 0 ;
                int left = (j > 0) ? dp[i][j - 1] : 0;
                dp[i][j] = up + left;
            }
        }
        return dp[row - 1][col - 1];
    }
}
