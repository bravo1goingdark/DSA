package DP1D;

import java.util.Arrays;

public class binomialCoeff {
    public static void main(String[] args) {
        // System.out.println(nCr(5, 2));
        int[][] dp = new int[11][3];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        // System.out.println(nCrMemo(10, 2, dp));
        System.out.println(nCrTabu(5, 2));
    }

    public static int nCr(int n, int r) {
        if (r == 0 || n == r) {
            return 1;
        }

        return nCr(n - 1, r - 1) + nCr(n - 1, r);
    }

    public static int nCrMemo(int n, int r, int[][] dp) {
        if (r == 0 || n == r) {
            return 1;
        }
        if (dp[n][r] != -1) {
            return dp[r][n];
        }

        return dp[n][r] = nCr(n - 1, r - 1) + nCr(n - 1, r);
    }

    public static int nCrTabu(int n, int r) {
        int[][] dp = new int[n + 1][r + 1];
    
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1; 
            if (i <= r) {
                dp[i][i] = 1; 
            }
        }
    
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= r; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
    
        return dp[n][r];
    }

}
