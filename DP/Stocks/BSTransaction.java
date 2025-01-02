package Stocks;

public class BSTransaction {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1,3,7,5,10,3}, 3));
    }
    public static int maxProfit(int[] prices, int fee) {
        return stockProfitTabu(prices, fee);
    }
    private static int stockProfitTabu(int[] prices ,int fee) {
        int[][] dp = new int[prices.length + 1][2];
        dp[prices.length][0] = 0;
        dp[prices.length][1] = 0;

        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                int profit = 0;

                if (j == 1) {
                    profit = Math.max(dp[i + 1][1],-prices[i] + dp[i + 1][0]);
                } else {
                    profit = Math.max(prices[i] + dp[i + 1][1] - fee,dp[i + 1][0]);
                }
                dp[i][j] = profit;
            }
        }

        return dp[0][1];
    }
    private static int stockProfitSpaceOpt(int[] prices,int fee) {
        int[] ahead = new int[2];
        int[] curr = new int[2];

        for (int i = prices.length - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                int profit = 0;

                if (j == 1) {
                    profit = Math.max(ahead[1],-prices[i] + ahead[0]);
                } else {
                    profit = Math.max(prices[i] + ahead[1] - fee,ahead[0]);
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
