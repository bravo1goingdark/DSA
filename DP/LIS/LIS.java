package LIS;

import java.util.Arrays;

public class LIS {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[] { 0,1,0,3,2,3 }));
    }

    public static int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length + 1];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        // return lengthOfLIS(0, -1, nums);
        return lengthOfLISMemo(0, -1, nums, dp);
    }

    private static int lengthOfLIS(int index, int prev, int[] nums) {
        if (index == nums.length) {
            return 0;
        }

        int length = lengthOfLIS(index + 1, prev, nums);

        if (prev == -1 || nums[index] > nums[prev]) {
            length = Math.max(length, 1 + lengthOfLIS(index + 1, index, nums));
        }
        return length;
    }

    private static int lengthOfLISMemo(int index, int prev, int[] nums, int[][] dp) {
        if (index == nums.length) {
            return 0;
        }
        if (dp[index][prev + 1] != -1) {
            return dp[index][prev + 1];
        }

        int length = lengthOfLISMemo(index + 1, prev, nums, dp);

        if (prev == -1 || nums[index] > nums[prev]) {
            length = Math.max(length, 1 + lengthOfLISMemo(index + 1, index, nums, dp));
        }
        return dp[index][prev + 1] = length;
    }

    
}
