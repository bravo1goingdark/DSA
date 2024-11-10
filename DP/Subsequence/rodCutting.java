package Subsequence;

import java.util.Arrays;

public class rodCutting {
    public static void main(String[] args) {
        System.out.println(cutRod(new int[] { 2, 5, 7, 8, 10 }, 5));
    }

    public static int cutRod(int price[], int n) {
        int[][] dp = new int[price.length][n + 1];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }

        // return cutRod(price.length - 1, price, n);
        // return cutRodMemo(price.length - 1, price, n, dp);
        // return cutRodTabu(price, n);
        // return cutRodSpaceOpt(price, n);
        return cutRod1DSpaceOpt(price, n);

    }

    private static int cutRod(int index, int[] price, int n) {
        if (index == 0) {
            return n * price[0];
        }

        int np = cutRod(index - 1, price, n);
        int pick = -(int) Math.pow(10, 9);
        int rodLength = index + 1;
        if (rodLength <= n) {
            pick = price[index] + cutRod(index, price, n - rodLength);
        }

        return Math.max(pick, np);
    }

    private static int cutRodMemo(int index, int[] price, int n, int[][] dp) {
        if (index == 0) {
            return n * price[0];
        }
        if (dp[index][n] != -1) {
            return dp[index][n];
        }

        int np = cutRodMemo(index - 1, price, n, dp);
        int pick = -(int) Math.pow(10, 9);
        int rodLength = index + 1;
        if (rodLength <= n) {
            pick = price[index] + cutRodMemo(index, price, n - rodLength, dp);
        }

        return dp[index][n] = Math.max(pick, np);
    }

    private static int cutRodTabu(int[] price, int n) {

        int[][] dp = new int[price.length][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i * price[0];
        }

        for (int i = 1; i < price.length; i++) {
            for (int j = 0; j <= n; j++) {
                int np = dp[i - 1][j];
                int pick = -(int) Math.pow(10, 9);
                int rodLength = i + 1;
                if (rodLength <= j) {
                    pick = price[i] + dp[i][j - rodLength];
                }
                dp[i][j] = Math.max(pick, np);
            }
        }

        return dp[price.length - 1][n];

    }

    private static int cutRodSpaceOpt(int[] price, int n) {

        int[] prev = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            prev[i] = i * price[0];
        }

        for (int i = 1; i < price.length; i++) {
            int[] curr = new int[n + 1];
            for (int j = 0; j <= n; j++) {
                int np = prev[j];
                int pick = -(int) Math.pow(10, 9);
                int rodLength = i + 1;
                if (rodLength <= j) {
                    pick = price[i] + curr[j - rodLength];
                }
                curr[j] = Math.max(pick, np);
            }
            prev = curr;
        }

        return prev[n];
    }
    private static int cutRod1DSpaceOpt(int[] price, int n) {

        int[] prev = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            prev[i] = i * price[0];
        }
        for (int i = 1; i < price.length; i++) {
            for (int j = 0; j <= n; j++) {
                int np = prev[j];
                int pick = -(int) Math.pow(10, 9);
                int rodLength = i + 1;
                if (rodLength <= j) {
                    pick = price[i] + prev[j - rodLength];
                }
                prev[j] = Math.max(pick, np);
            }
        }
        return prev[n];
    }
}
