package Stocks;

public class BTSTIV {
    public int maxProfit(int k, int[] prices) {
        return stockProfitTabu(prices,k);
    }

    private static int stockProfitTabu(int[] prices , int noOfTransaction) {
        int[][][] dp = new int[prices.length + 1][2][noOfTransaction + 1];

        for (int i = 0; i <= prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j][0] = 0;
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j <= noOfTransaction; j++) {
                dp[prices.length][i][j] = 0;
            }
        }

        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                for (int k = 1; k <= noOfTransaction; k++) {
                    int profit = 0;

                    if (j == 1) {
                        profit = Math.max(dp[i + 1][1][k], -prices[i] + dp[i + 1][0][k]);
                    } else {
                        profit = Math.max(prices[i] + dp[i + 1][1][k - 1], dp[i + 1][0][k]);
                    }
                    dp[i][j][k] = profit;
                }
            }
        }

        return dp[0][1][noOfTransaction];
    }
    private static int stockProfitSpaceOpt(int[] prices , int noOfTransaction) {
        int[][] ahead = new int[2][noOfTransaction + 1];
        int[][] curr = new int[2][noOfTransaction + 1];

        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                for (int k = 1; k <= noOfTransaction; k++) {
                    int profit = 0;

                    if (j == 1) {
                        profit = Math.max(ahead[1][k], -prices[i] + ahead[0][k]);
                    } else {
                        profit = Math.max(prices[i] + ahead[1][k - 1], ahead[0][k]);
                    }
                    curr[j][k] = profit;
                }
            }
            int[][] temp = ahead;
            ahead = curr;
            curr = temp; 
        }

        return ahead[1][noOfTransaction];
    }
}
