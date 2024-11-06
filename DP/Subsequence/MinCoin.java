package Subsequence;

import java.util.Arrays;

public class MinCoin {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[] { 1, 2, 3 }, 8));
    }

    public static int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }

        // return coinChange(coins.length - 1, coins, amount);
        // return coinChangeMemo(coins.length - 1, coins, amount, dp);
        // return coinChangeTabu(coins, amount);
        return coinChangeSpaceOpt(coins, amount);
    }

    private static int coinChange(int index, int[] coins, int amount) {
        if (index == 0) {
            if (amount % coins[0] == 0) {
                return amount / coins[0];
            }
            return (int) Math.pow(10, 9);
        }

        int np = coinChange(index - 1, coins, amount);
        int pick = (int) Math.pow(10, 9);
        if (coins[index] <= amount) {
            pick = 1 + coinChange(index, coins, amount - coins[index]);
        }

        return Math.min(np, pick);
    }

    private static int coinChangeMemo(int index, int[] coins, int amount, int[][] dp) {
        if (index == 0) {
            if (amount % coins[0] == 0) {
                return amount / coins[0];
            }
            return (int) Math.pow(10, 9);
        }
        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }

        int np = coinChangeMemo(index - 1, coins, amount, dp);
        int pick = (int) Math.pow(10, 9);
        if (coins[index] <= amount) {
            pick = 1 + coinChangeMemo(index, coins, amount - coins[index], dp);
        }

        return dp[index][amount] = Math.min(np, pick);
    }

    private static int coinChangeTabu(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        int MAX = (int) Math.pow(10, 9); 
    

        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) {
                dp[0][i] = i / coins[0]; 
            } else {
                dp[0][i] = MAX; 
            }
        }
    

        for (int index = 1; index < coins.length; index++) {
            for (int target = 0; target <= amount; target++) {
                int notPick = dp[index - 1][target]; 
                int pick = MAX; 
                if (coins[index] <= target) {
                    pick = 1 + dp[index][target - coins[index]]; 
                }
                dp[index][target] = Math.min(notPick, pick); 
            }
        }
    
        return dp[coins.length - 1][amount] >= MAX ? -1 : dp[coins.length - 1][amount];
    }
    private static int coinChangeSpaceOpt(int[] coins, int amount) {
        int[] prev = new int[amount + 1];
        int MAX = (int) Math.pow(10, 9); 
    

        for (int i = 0; i <= amount; i++) {
            if (i % coins[0] == 0) {
                prev[i] = i / coins[0]; 
            } else {
                prev[i] = MAX; 
            }
        }
    

        for (int index = 1; index < coins.length; index++) {
            int[] curr = new int[amount + 1];
            for (int target = 0; target <= amount; target++) {
                int notPick = prev[target]; 
                int pick = MAX; 
                if (coins[index] <= target) {
                    pick = 1 + curr[target - coins[index]]; 
                }
                curr[target] = Math.min(notPick, pick); 
            }
            prev = curr;
        }
    
        return prev[amount] >= MAX ? -1 : prev[amount];
    }
    
}
