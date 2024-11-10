package Subsequence;

import java.util.Arrays;

// only differnece between coin change 1 and II is II have all no of ways we can form that denomination
// and coin change I has minimum denomination

public class coinChangeII {
    public static void main(String[] args) {
        System.out.println(change(4, new int[] { 1, 2, 3 }));
    }

    public static int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];

        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }

        // return change(coins.length - 1, amount, coins);
        // return changeMemo(coins.length - 1, amount, coins, dp);
        // return coinChangeTabu(amount, coins);
        return coinChangeSpaceOpt(amount, coins);
    }

    private static int change(int index, int amount, int[] coins) {
        if (index == 0) {
            return (amount % coins[0] == 0) ? 1 : 0;
        }

        int np = change(index - 1, amount, coins);
        int pick = 0;
        if (coins[index] <= amount) {
            pick = change(index, amount - coins[index], coins);
        }

        return pick + np;
    }

    private static int changeMemo(int index, int amount, int[] coins, int[][] dp) {
        if (index == 0) {
            return (amount % coins[0] == 0) ? 1 : 0;
        }

        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }

        int np = changeMemo(index - 1, amount, coins, dp);
        int pick = 0;
        if (coins[index] <= amount) {
            pick = changeMemo(index, amount - coins[index], coins, dp);
        }

        return dp[index][amount] = pick + np;
    }

    private static int coinChangeTabu(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];

        for (int i = 0; i <= amount; i++) {
            dp[0][i] = (i % coins[0] == 0) ? 1 : 0;
        }

        for (int i = 1; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                int np = dp[i - 1][j];
                int pick = 0;
                if (coins[i] <= j) {
                    pick = dp[i][j - coins[i]];
                }
                dp[i][j] = pick + np;
            }
        }

        return dp[coins.length - 1][amount];

    }

    private static int coinChangeSpaceOpt(int amount, int[] coins) {

        int[] prev = new int[amount + 1];

        for (int i = 0; i <= amount; i++) {
            prev[i] = (i % coins[0] == 0) ? 1 : 0;
        }

        for (int i = 1; i < coins.length; i++) {
            int[] curr = new int[amount + 1];
            for (int j = 0; j <= amount; j++) {
                int np = prev[j];
                int pick = 0;
                if (coins[i] <= j) {
                    pick = curr[j - coins[i]];
                }
                curr[j] = pick + np;
            }
            prev = curr;
        }

        return prev[amount];

    }
}
