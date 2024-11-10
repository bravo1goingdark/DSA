package Subsequence;

import java.util.Arrays;

public class UnboundedKnapSack {
    public static void main(String[] args) {
        System.out.println(unboundedKnapsack(3, 10, new int[] { 5, 11, 13 }, new int[] { 2, 4, 6 }));
    }

    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {

        int[][] dp = new int[profit.length][w + 1];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }

        // return unboundedKnap(n - 1, w, profit, weight);

        // return unboundedKnapMemo(n - 1, w, profit, weight, dp);
        // return unboundedKnapTabu(w, profit, weight);
        // return unboundedKnapSpaceOpt(w, profit, weight);
        return unboundedKnap1DSpaceOpt(w, profit, weight);
    }

    private static int unboundedKnap(int index, int w, int[] profit, int[] weight) {
        if (index == 0) {
            return (int) (w / weight[0]) * profit[0];
        }

        int np = unboundedKnap(index - 1, w, profit, weight);
        int p = -(int) Math.pow(10, 9);

        if (w >= weight[index]) {
            p = profit[index] + unboundedKnap(index, w - weight[index], profit, weight);
        }

        return Math.max(np, p);
    }

    private static int unboundedKnapMemo(int index, int w, int[] profit, int[] weight, int[][] dp) {
        if (index == 0) {
            return (int) (w / weight[0]) * profit[0];
        }

        if (dp[index][w] != -1) {
            return dp[index][w];
        }

        int np = unboundedKnapMemo(index - 1, w, profit, weight, dp);
        int p = -(int) Math.pow(10, 9);

        if (w >= weight[index]) {
            p = profit[index] + unboundedKnapMemo(index, w - weight[index], profit, weight, dp);
        }

        return dp[index][w] = Math.max(np, p);
    }

    private static int unboundedKnapTabu(int w, int[] profit, int[] weight) {

        int[][] dp = new int[profit.length][w + 1];
        for (int i = 0; i <= w; i++) {
            dp[0][i] = (int) (i / weight[0]) * profit[0];
        }

        for (int i = 1; i < profit.length; i++) {
            for (int j = 0; j <= w; j++) {
                int np = dp[i - 1][j];
                int p = -(int) Math.pow(10, 9);

                if (j >= weight[i]) {
                    p = profit[i] + dp[i][j - weight[i]];
                }

                dp[i][j] = Math.max(np, p);
            }
        }

        return dp[profit.length - 1][w];

    }

    private static int unboundedKnapSpaceOpt(int w, int[] profit, int[] weight) {

        int[] prev = new int[w + 1];
        for (int i = 0; i <= w; i++) {
            prev[i] = (int) (i / weight[0]) * profit[0];
        }

        for (int i = 1; i < profit.length; i++) {
            int[] curr = new int[w + 1];
            for (int j = 0; j <= w; j++) {
                int np = prev[j];
                int p = -(int) Math.pow(10, 9);

                if (j >= weight[i]) {
                    p = profit[i] + curr[j - weight[i]];
                }

                curr[j] = Math.max(np, p);
            }
            prev = curr;
        }

        return prev[w];
    }
    private static int unboundedKnap1DSpaceOpt(int w, int[] profit, int[] weight) {

        int[] prev = new int[w + 1];
        for (int i = 0; i <= w; i++) {
            prev[i] = (int) (i / weight[0]) * profit[0];
        }

        for (int i = 1; i < profit.length; i++) {
            for (int j = 0; j <= w; j++) {
                int np = prev[j];
                int p = -(int) Math.pow(10, 9);

                if (j >= weight[i]) {
                    p = profit[i] + prev[j - weight[i]];
                }

                prev[j] = Math.max(np, p);
            }
        }
        return prev[w];
    }
}
