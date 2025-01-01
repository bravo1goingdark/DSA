package Subsequence;

import java.util.Arrays;

public class CountSubsetSumK {
    private static final int MOD = 1000000007;
    public static void main(String[] args) {
        System.out.println(findWays(new int[] { 0, 0, 1 }, 1));
    }

    public static int findWays(int num[], int tar) {
        int[][] dp = new int[num.length][tar + 1];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        // return countSubsetWithSumK(num.length - 1, tar, num);
        // return countSubsetWithSumKMemo(num.length - 1, tar, num, dp);
        return countSubsetWithSumKTabu(tar, num);
        // return countSubsetWithSumKSpaceOpt(tar, num);

    }

    private static int countSubsetWithSumK(int index, int target, int[] arr) {
        if (index == 0) {
            if (target == 0 && arr[0] == 0) {
                return 2;
            }
            if (target == 0 || target == arr[0]) {
                return 1;
            }
            return 0;
        }

        int notPick = countSubsetWithSumK(index - 1, target, arr);
        int pick = 0;
        if (arr[index] <= target) {
            pick = countSubsetWithSumK(index - 1, target - arr[index], arr);
        }

        return pick + notPick;
    }

    private static int countSubsetWithSumKMemo(int index, int target, int[] arr, int[][] dp) {
        if (index == 0) {
            if (target == 0 && arr[0] == 0) {
                return 2;
            }
            if (target == 0 || target == arr[0]) {
                return 1;
            }
            return 0;
        }

        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        int notPick = countSubsetWithSumKMemo(index - 1, target, arr, dp);
        int pick = 0;
        if (arr[index] <= target) {
            pick = countSubsetWithSumKMemo(index - 1, target - arr[index], arr, dp);
        }

        return dp[index][target] = pick + notPick;
    }

    private static int countSubsetWithSumKTabu(int target, int[] arr) {

        int[][] dp = new int[arr.length][target + 1];

        dp[0][0] = arr[0] == 0 ? 2 : 1;
        
        if (arr[0] != 0 && arr[0] <= target) {
            dp[0][arr[0]] = 1;
        }

        for (int index = 1; index < arr.length; index++) {
            for (int sum = 0; sum <= target; sum++) {
                int notPick = dp[index - 1][sum];
                int pick = 0;
                if (arr[index] <= sum) {
                    pick = dp[index - 1][sum - arr[index]];
                }
                dp[index][sum] = pick + notPick;
            }
        }

        return dp[arr.length - 1][target];
    }

    private static int countSubsetWithSumKSpaceOpt(int target, int[] arr) {
        int[] prev = new int[target + 1];
        
        prev[0] = 1; 
        
        if (arr[0] == 0) {
            prev[0] = 2; // two choices when arr[0] == 0 either to pick it or not pick it
        } else if (arr[0] <= target) {
            prev[arr[0]] = 1; 
        }

        for (int index = 1; index < arr.length; index++) {
            int[] curr = new int[target + 1];
            for (int sum = 0; sum <= target; sum++) {
                int notPick = prev[sum];
                int pick = 0;
                if (arr[index] <= sum) {
                    pick = prev[sum - arr[index]];
                }
                curr[sum] = (pick + notPick) % MOD;
            }
            prev = curr; 
        }

        return prev[target];
    }
}
