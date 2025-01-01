package Stocks;

import java.util.Arrays;

public class BTSTII {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
    }

    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        // return stockProfit(0, 1, prices);
        // return stockProfitMemo(0, 1, prices, dp);
        // return stockProfitTabu(prices);
        return stockProfitSpaceOpt(prices);

    }
     

    // 1 -> Buy   
    // 0 -> Sell
    private static int stockProfit(int index, int isBought, int[] prices) {
        if (index == prices.length) {
            return 0;
        }

        int profit = 0;
        if (isBought == 1) {
            profit = Math.max(stockProfit(index + 1, 1, prices), -prices[index] + stockProfit(index + 1, 0, prices));
        } else {
            profit = Math.max(prices[index] + stockProfit(index + 1, 1, prices), stockProfit(index + 1, 0, prices));
        }

        return profit;
    }

    private static int stockProfitMemo(int index, int isBought, int[] prices, int[][] dp) {
        if (index == prices.length) {
            return 0;
        }
        if (dp[index][isBought] != -1) {
            return dp[index][isBought];
        }
        int profit = 0;

        if (isBought == 1) {
            profit = Math.max(stockProfitMemo(index + 1, 1, prices, dp),
                    -prices[index] + stockProfitMemo(index + 1, 0, prices, dp));
        } else {
            profit = Math.max(prices[index] + stockProfitMemo(index + 1, 1, prices, dp),
                    stockProfitMemo(index + 1, 0, prices, dp));
        }

        return dp[index][isBought] = profit;
    }

    private static int stockProfitTabu(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        dp[prices.length][0] = 0;
        dp[prices.length][1] = 0;

        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                int profit = 0;

                if (j == 1) {
                    profit = Math.max(dp[i + 1][1],-prices[i] + dp[i + 1][0]);
                } else {
                    profit = Math.max(prices[i] + dp[i + 1][1],dp[i + 1][0]);
                }
                dp[i][j] = profit;
            }
        }

        return dp[0][1];
    }


    private static int stockProfitSpaceOpt(int[] prices) {
        int[] ahead = new int[2];
        int[] curr = new int[2];

        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                int profit = 0;

                if (j == 1) {
                    profit = Math.max(ahead[1],-prices[i] + ahead[0]);
                } else {
                    profit = Math.max(prices[i] + ahead[1],ahead[0]);
                }
                curr[j] = profit;
            }
            int[] temp = ahead;
            ahead = curr;
            curr = temp;
        }

        return ahead[1];
    }
}
