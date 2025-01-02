package Stocks;

import java.util.Arrays;

public class BSCooldown {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int[] is : dp) {
            Arrays.fill(is, 1);
        }
        // return stock(0, 1, prices);
        return stockMemo(0, 1, prices, dp);
    }

    private int stock(int index, int isBought, int[] prices) {
        if (index >= prices.length) {
            return 0;
        }

        if (isBought == 1) {
            return Math.max(-prices[index] + stock(index + 1, 0, prices), stock(index + 1, 1, prices));
        }

        return Math.max(prices[index] + stock(index + 2, 1, prices), stock(index + 1, 0, prices));
    }

    private int stockMemo(int index, int isBought, int[] prices, int[][] dp) {
        if (index >= prices.length) {
            return 0;
        }

        if (dp[index][isBought] != -1) {
            return dp[index][isBought];
        }

        if (isBought == 1) {
            return dp[index][isBought] = Math.max(-prices[index] + stockMemo(index + 1, 0, prices, dp),
                    stockMemo(index + 1, 1, prices, dp));
        }

        return dp[index][isBought] = Math.max(prices[index] + stockMemo(index + 2, 1, prices, dp),
                stockMemo(index + 1, 0, prices, dp));
    }

    private int stockTabu(int[] prices) {

        int[][] dp = new int[prices.length + 2][2];

        dp[prices.length][0] = 0;
        dp[prices.length][1] = 0;

        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                if (j == 1) {
                    dp[i][j] = Math.max(-prices[i] + dp[i + 1][0], dp[i + 1][1]);
                } else {
                    dp[i][j] = Math.max(prices[i] + dp[i + 2][1], dp[i + 1][0]);
                }
            }
        }

        return dp[0][1];
    }

}
