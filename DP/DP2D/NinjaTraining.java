package DP2D;

import java.util.Arrays;

public class NinjaTraining {
    public static void main(String[] args) {
        System.out.println(ninjaTrainingMemo(3, new int[][] { { 1, 2, 5 }, { 3, 1, 1 }, { 3, 3, 3 } }));
    }

    public static int ninjaTrainingRecur(int n, int points[][]) {
        return ninjaTraining(n - 1, 3, points);
    }

    public static int ninjaTrainingMemo(int n, int points[][]) {
        int[][] dp = new int[n][n + 1];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        return ninjaTrainingMemo(n - 1, 3, points,dp);
    }

    private static int ninjaTraining(int day, int last, int[][] points) {
        if (day == 0) {
            int max = 0;

            for (int task = 0; task < 3; task++) {
                if (task != last) {
                    max = Math.max(max, points[0][task]);
                }
            }
            return max;
        }

        int max = 0;
        for (int task = 0; task < 3; task++) {
            if (task != last) {
                int point = points[day][task] + ninjaTraining(day - 1, task, points);
                max = Math.max(max, point);
            }
        }

        return max;
    }

    private static int ninjaTrainingMemo(int day, int last, int[][] points , int[][] dp) {
        if (day == 0) {
            int max = 0;

            for (int task = 0; task < 3; task++) {
                if (task != last) {
                    max = Math.max(max, points[0][task]);
                }
            }
            return max;
        }
        if (dp[day][last] != -1) {
            return dp[day][last];
        }

        int max = 0;
        for (int task = 0; task < 3; task++) {
            if (task != last) {
                int point = points[day][task] + ninjaTrainingMemo(day - 1, task, points,dp);
                max = Math.max(max, point);
            }
        }

        return dp[day][last] = max;
    }
}
