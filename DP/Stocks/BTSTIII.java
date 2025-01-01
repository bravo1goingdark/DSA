package Stocks;

import java.util.Arrays;

class BTSTIII {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] { 3, 3, 5, 0, 0, 3, 1, 4 }));
    }

    public static int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][3];
        for (int[][] is : dp) {
            for (int[] is2 : is) {
                Arrays.fill(is2, -1);
            }
        }
        // return stockProfit(0, 1, 2, prices);
        // return stockProfitMemo(0, 1, 2, prices, dp);
        // return stockProfitTabu(prices);
        return stockProfitSpaceOpt(prices);

    }

    private static int stockProfit(int index, int isBought, int cap, int[] prices) {
        if (index == prices.length || cap == 0) {
            return 0;
        }

        int profit = 0;
        if (isBought == 1) {
            profit = Math.max(stockProfit(index + 1, 1, cap, prices),
                    -prices[index] + stockProfit(index + 1, 0, cap, prices));
        } else {
            profit = Math.max(prices[index] + stockProfit(index + 1, 1, cap - 1, prices),
                    stockProfit(index + 1, 0, cap, prices));
        }

        return profit;
    }

    private static int stockProfitMemo(int index, int isBought, int cap, int[] prices, int[][][] dp) {
        if (index == prices.length || cap == 0) {
            return 0;
        }
        if (dp[index][isBought][cap] != -1) {
            return dp[index][isBought][cap];
        }
        int profit = 0;

        if (isBought == 1) {
            profit = Math.max(stockProfitMemo(index + 1, 1, cap, prices, dp),
                    -prices[index] + stockProfitMemo(index + 1, 0, cap, prices, dp));
        } else {
            profit = Math.max(prices[index] + stockProfitMemo(index + 1, 1, cap - 1, prices, dp),
                    stockProfitMemo(index + 1, 0, cap, prices, dp));
        }

        return dp[index][isBought][cap] = profit;
    }

    private static int stockProfitTabu(int[] prices) {
        int[][][] dp = new int[prices.length + 1][2][3];

        for (int i = 0; i <= prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j][0] = 0;
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j <= 2; j++) {
                dp[prices.length][i][j] = 0;
            }
        }

        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                for (int k = 1; k <= 2; k++) {
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

        return dp[0][1][2];
    }

    private static int stockProfitSpaceOpt(int[] prices) {
        int[][] ahead = new int[2][3];
        int[][] curr = new int[2][3];

        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                for (int k = 1; k <= 2; k++) {
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

        return ahead[1][2];
    }
}