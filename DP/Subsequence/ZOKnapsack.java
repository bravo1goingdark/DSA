package Subsequence;

import java.util.Arrays;

public class ZOKnapsack {
    public static void main(String[] args) {

        int[] weight = new int[] { 3, 2, 5 };
        int[] value = new int[] { 30, 40, 60 };
        System.out.println(knapsack(weight, value, weight.length, 6));
    }

    public static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[n][maxWeight + 1];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }

        // return knapsack(n - 1, weight, value, maxWeight);
        // return knapsackMemo(n - 1, weight, value, maxWeight, dp);
        // return knapsacTabu(weight, value, maxWeight);
        return knapsacSpaceOpt(weight, value, maxWeight);

    }

    private static int knapsack(int index, int[] weight, int[] value, int maxWeight) {
        if (index == 0) {
            if (weight[index] <= maxWeight) {
                return value[index];
            }
            return 0;
        }

        int notPick = knapsack(index - 1, weight, value, maxWeight);
        int pick = Integer.MIN_VALUE;
        if (weight[index] <= maxWeight) {
            pick = value[index] + knapsack(index - 1, weight, value, maxWeight - weight[index]);
        }

        return Math.max(notPick, pick);
    }

    private static int knapsackMemo(int index, int[] weight, int[] value, int maxWeight,int[][] dp) {
        if (index == 0) {
            if (weight[index] <= maxWeight) {
                return value[index];
            }

            return 0;
        }
        if (dp[index][maxWeight] != -1) {
            return dp[index][maxWeight];
        }

        int notPick = knapsackMemo(index - 1, weight, value, maxWeight, dp);
        int pick = Integer.MIN_VALUE;
        if (weight[index] <= maxWeight) {
            pick = value[index] + knapsackMemo(index - 1, weight, value, maxWeight - weight[index], dp);
        }

        return dp[index][maxWeight] = Math.max(notPick, pick);
    }

    private static int knapsacTabu(int[] weight, int[] value, int maxWeight) {
        int[][] dp = new int[weight.length][maxWeight + 1];

        for (int wt = weight[0]; wt <= maxWeight; wt++) {
            dp[0][wt] = value[0];
        }

        for (int index = 1; index < weight.length; index++) {
            for (int wt = 0; wt <= maxWeight; wt++) {
                int notPick = dp[index - 1][wt];
                int pick = Integer.MIN_VALUE;
                if (weight[index] <= wt) {
                    pick = value[index] + dp[index - 1][wt - weight[index]];
                }

                dp[index][wt] = Math.max(notPick, pick);
            }
        }

        return dp[weight.length - 1][maxWeight];
    }
    private static int knapsacSpaceOpt(int[] weight, int[] value, int maxWeight) {
        int[] prev = new int[maxWeight + 1];

        for (int wt = weight[0]; wt <= maxWeight; wt++) {
            prev[wt] = value[0];
        }

        for (int index = 1; index < weight.length; index++) {
            int[] curr = new int[maxWeight + 1];
            for (int wt = 0; wt <= maxWeight; wt++) {
                int notPick = prev[wt];
                int pick = Integer.MIN_VALUE;
                if (weight[index] <= wt) {
                    pick = value[index] + prev[wt - weight[index]];
                }

                curr[wt] = Math.max(notPick, pick);
            }
            prev = curr;
        }

        return prev[maxWeight];
    }
}
