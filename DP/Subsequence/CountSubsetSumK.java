package Subsequence;

import java.util.Arrays;

// this solution does not work for testcase containing 0 at 0,1,2... and so on index before any number > 0 
// like {0,1,3} , {0,0,1}
public class CountSubsetSumK {
    public static void main(String[] args) {
        System.out.println(findWays(new int[] { 0, 1, 3 }, 4));
    }

    public static int findWays(int num[], int tar) {
        int[][] dp = new int[num.length][tar + 1];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        // return countSubsetWithSumK(num.length - 1, tar, num);
        // return countSubsetWithSumKMemo(num.length - 1, tar, num, dp);
        // return countSubsetWithSumKTabu(tar, num);
        return countSubsetWithSumKSpaceOpt(tar, num);

    }

    private static int countSubsetWithSumK(int index, int target, int[] arr) {
        if (index == 0) {
            return arr[index] == target ? 1 : 0;
        }
        if (target == 0) {
            return 1;
        }

        int notPick = countSubsetWithSumK(index - 1, target, arr);
        int pick = 0;
        if (arr[index] <= target) {
            countSubsetWithSumK(index - 1, target - arr[index], arr);
        }

        return pick + notPick;
    }

    private static int countSubsetWithSumKMemo(int index, int target, int[] arr, int[][] dp) {
        if (target == 0) {
            return 1;
        }
        if (index == 0) {
            return arr[0] == target ? 1 : 0;
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

        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }
        if (arr[0] <= target) {
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
        int[] curr = new int[target + 1];

        prev[0] = 1;
        curr[0] = 1;

        if (arr[0] <= target) {
            prev[arr[0]] = 1;
        }

        for (int index = 1; index < arr.length; index++) {
            for (int sum = 0; sum <= target; sum++) {
                int notPick = prev[sum];
                int pick = 0;
                if (arr[index] <= sum) {
                    pick = prev[sum - arr[index]];
                }
                curr[sum] = pick + notPick;
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[target];
    }
}
