package Subsequence;

import java.util.Arrays;

public class SubArraySumK {
    public static void main(String[] args) {
        System.out.println(subsetSumToK(4, 5, new int[] { 4, 3, 2, 1 }));
    }

    public static boolean subsetSumToK(int n, int k, int arr[]) {

        Boolean[][] dp = new Boolean[n][k + 1];
        for (Boolean[] bs : dp) {
            Arrays.fill(bs, null);
        }
        // return subsetSumEqualK(n - 1, k, arr);
        // return subsetSumEqualKMemo(n - 1, k, arr, dp);

        // return subsetSumEqualKTabu(n, k, arr);
        return subsetSumEqualKSpaceOpt(n,k,arr);

    }

    private static boolean subsetSumEqualK(int index, int target, int[] arr) {
        if (target == 0) {
            return true;
        }

        if (index == 0) {
            return target - arr[index] == 0;
        }

        boolean notTake = subsetSumEqualK(index - 1, target, arr);
        boolean take = false;
        if (target >= arr[index]) {
            take = subsetSumEqualK(index - 1, target - arr[index], arr);
        }

        return notTake || take;
    }

    private static boolean subsetSumEqualKMemo(int index, int target, int[] arr, Boolean[][] dp) {
        if (target == 0) {
            return true;
        }

        if (index == 0) {
            return target - arr[0] == 0;
        }
        if (dp[index][target] != null) {
            return dp[index][target];
        }

        boolean notTake = subsetSumEqualKMemo(index - 1, target, arr, dp);
        boolean take = false;
        if (target >= arr[index]) {
            take = subsetSumEqualKMemo(index - 1, target - arr[index], arr, dp);
        }

        return dp[index][target] = (notTake || take);
    }

    private static boolean subsetSumEqualKTabu(int size, int target, int[] arr) {
        boolean[][] dp = new boolean[size + 1][target + 1];
    
        for (int i = 0; i <= size; i++) {
            dp[i][0] = true;
        }
        
        if (arr[0] <= target) {
            dp[0][arr[0]] = true;
        }
    
        for (int i = 1; i < size; i++) {
            for (int j = 1; j <= target; j++) {
                boolean notTake = dp[i - 1][j];
                boolean take = (j >= arr[i]) ? dp[i - 1][j - arr[i]] : false;
                dp[i][j] = notTake || take;
            }
        }
        
        return dp[size - 1][target];
    }

    private static boolean subsetSumEqualKSpaceOpt(int size, int target, int[] arr) {
        boolean[] prev = new boolean[target + 1];
        boolean[] curr = new boolean[target + 1];
    
        prev[0] = true;
        curr[0] = true;
        if (arr[0] <= target) {
            prev[arr[0]] = true;
        }
        
        for (int i = 1; i < size; i++) {
            for (int j = 1; j <= target; j++) {
                boolean notTake = prev[j];
                boolean take = (j >= arr[i]) ? prev[j - arr[i]] : false;
                curr[j] = notTake || take;
            }
            boolean[] temp = prev;
            prev = curr;
            curr = temp;
        }
        
        return prev[target];
    }
    
}
