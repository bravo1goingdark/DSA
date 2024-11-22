package Subsequence;

import java.util.Arrays;

public class maxAltSubseq {
    public static void main(String[] args) {
        System.out.println(maxAlternatingSum(new int[] { 4, 2, 5, 3 }));
    }

    public static long maxAlternatingSum(int[] nums) {

        long[][] dp = new long[nums.length][2];

        for (long[] ls : dp) {
            Arrays.fill(ls, -1);
        }

        // 1 -> true , 0 -> false
        // return maxAlternatingSum(nums.length - 1, nums, 1);
        // return maxAlternatingSumMemo(nums.length - 1, nums, 1, dp);
        return maxAlternatingSumTabu(nums);
    }

    private static long maxAlternatingSum(int index, int[] nums, int isAdding) {
        if (index < 0) {
            return 0;
        }

        long p = isAdding == 1 ? nums[index] + maxAlternatingSum(index - 1, nums, 0)
                : -nums[index] + maxAlternatingSum(index - 1, nums, 1);
        long np = maxAlternatingSum(index - 1, nums, isAdding);

        return Math.max(p, np);
    }

    private static long maxAlternatingSumMemo(int index, int[] nums, int isAdding, long[][] dp) {
        if (index < 0) {
            return 0;
        }
        if (dp[index][isAdding] != -1) {
            return dp[index][isAdding];
        }

        long p = isAdding == 1 ? nums[index] + maxAlternatingSumMemo(index - 1, nums, 0, dp)
                : -nums[index] + maxAlternatingSumMemo(index - 1, nums, 1, dp);
        long np = maxAlternatingSumMemo(index - 1, nums, isAdding, dp);

        return dp[index][isAdding] = Math.max(p, np);
    }

    private static long maxAlternatingSumTabu(int[] nums) {
        long[][] dp = new long[nums.length][2];
        

        dp[0][1] = nums[0]; 
        dp[0][0] = 0;        
        
        for (int i = 1; i < nums.length; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + nums[i]);  
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - nums[i]);  
        }
    
        return dp[nums.length - 1][1];
    }
    
}
