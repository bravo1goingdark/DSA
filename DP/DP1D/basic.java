package DP1D;

import java.util.Arrays;

public class basic {
    public static void main(String[] args) {
        // System.out.println(FiboSpaceOpt(40));

        // System.out.println(climbStairMemo(45 , dp));
        // System.out.println(FiboMemo(45, dp));
        // System.out.println(FiboTabulation(40));
        // System.out.println(climbStairSpaceOpt(45));
        // System.out.println(minCostClimbingStairs(new int[]{10,15,20}));
        // System.out.println(minCostClimbingStairsTabulation(new int[]{10,15,20}));
        // System.out.println(tribonacci(35));
        int[] arr = new int[] { 0, 1, 3, 5, 6, 8, 12, 6 };
        int[] dp = new int[arr.length + 1];
        Arrays.fill(dp, -1);
        // System.out.println(frogJumpSpaceOpt(arr));
        // System.out.println(frogJumpK(arr.length - 1, arr, 2));
        // System.out.println(frogJumpKMemo(arr.length - 1, arr,2, dp));
        // System.out.println(frogJumpKTabulation(arr, 2));

        // System.out.println(maximumNonAdjacentSumMemo(arr.length - 1, arr, dp));
        // System.out.println(maximumNonAdjacentSumTabulation(arr));

        System.out.println(maximumNonAdjacentSumSpaceOpt(arr));
    }

    public static long FiboMemo(int num, long[] dp) {
        if (num <= 1) {
            return num;
        }

        if (dp[num] != -1) {
            return dp[num];
        }

        return dp[num] = FiboMemo(num - 1, dp) + FiboMemo(num - 2, dp);
    }

    public static long FiboTabulation(int num) {
        if (num <= 1) {
            return num;
        }

        long[] dp = new long[num + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;

        for (int index = 2; index <= num; index++) {
            dp[index] = dp[index - 1] + dp[index - 2];
        }

        return dp[num];
    }

    public static long FiboSpaceOpt(int num) {
        if (num <= 1) {
            return num;
        }

        long first = 0;
        long second = 1;

        for (int index = 2; index <= num; index++) {
            long curr = first + second;
            first = second;
            second = curr;
        }

        return second;
    }

    // https://leetcode.com/problems/climbing-stairs/description/
    public static long climbStair(int stair) {
        if (stair == 1 || stair == 0) {
            return 1;
        }

        return climbStair(stair - 1) + climbStair(stair - 2);
    }

    public static long climbStairMemo(int stair, long[] dp) {
        if (stair == 1 || stair == 0) {
            return 1;
        }

        if (dp[stair] != -1) {
            return dp[stair];
        }

        return dp[stair] = climbStairMemo(stair - 1, dp) + climbStairMemo(stair - 2, dp);
    }

    public static long climbStairTabulation(int stair) {
        if (stair == 1 || stair == 0) {
            return 1;
        }

        long[] dp = new long[stair + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int index = 2; index <= stair; index++) {
            dp[index] = dp[index - 1] + dp[index - 2];
        }
        return dp[stair];
    }

    public static long climbStairSpaceOpt(int stair) {
        if (stair == 1 || stair == 0) {
            return 1;
        }

        int f = 1;
        int s = 1;

        for (int index = 2; index <= stair; index++) {
            int curr = f + s;
            f = s;
            s = curr;
        }
        return s;
    }

    // https://leetcode.com/problems/min-cost-climbing-stairs/
    public static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        Arrays.fill(dp, -1);
        return Math.min(minCostClimbingStairs(cost, 0, dp), minCostClimbingStairs(cost, 1, dp));
    }

    private static int minCostClimbingStairs(int[] cost, int index, int[] dp) {
        if (index >= cost.length) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int costOneStep = cost[index] + minCostClimbingStairs(cost, index + 1, dp);
        int costTwoSteps = cost[index] + minCostClimbingStairs(cost, index + 2, dp);

        dp[index] = Math.min(costOneStep, costTwoSteps);
        return dp[index];
    }

    public static int minCostClimbingStairsTabulation(int[] cost) {

        int[] dp = new int[cost.length + 1];
        for (int index = 0; index < cost.length; index++) {
            if (index < 2) {
                dp[index] = cost[index];
            } else {
                dp[index] = cost[index] + Math.min(dp[index - 1], dp[index - 2]);
            }
        }

        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

    public static int tribonacci(int n) {
        int[] tribo = new int[40];
        tribo[0] = 0;
        tribo[1] = 1;
        tribo[2] = 1;

        for (int index = 0; index <= n; index++) {
            tribo[index + 3] = tribo[index] + tribo[index + 1] + tribo[index + 2];
        }

        return tribo[n];
    }

    private static int frogJumpMemo(int index, int[] arr, int[] dp) {
        if (index == 0) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }

        int left = Math.abs(arr[index] - arr[index - 1]) + frogJumpMemo(index - 1, arr, dp);
        int right = Integer.MAX_VALUE;
        if (index > 1) {
            right = Math.abs(arr[index] - arr[index - 2]) + frogJumpMemo(index - 2, arr, dp);
        }

        return dp[index] = Math.min(left, right);
    }

    private static int frogJumpTabulation(int[] arr) {

        int[] dp = new int[arr.length];
        dp[0] = 0;

        for (int ind = 1; ind < arr.length; ind++) {
            int fs = dp[ind - 1] + Math.abs(arr[ind] - arr[ind - 1]);
            int ss = Integer.MAX_VALUE;
            if (ind > 1) {
                ss = dp[ind - 2] + Math.abs(arr[ind] - arr[ind - 2]);
            }

            dp[ind] = Math.min(fs, ss);
        }

        return dp[dp.length - 1];
    }

    private static int frogJumpSpaceOpt(int[] arr) {

        int prev = 0;
        int prevprev = 0;

        for (int ind = 1; ind < arr.length; ind++) {
            int fs = prev + Math.abs(arr[ind] - arr[ind - 1]);
            int ss = Integer.MAX_VALUE;
            if (ind > 1) {
                ss = prevprev + Math.abs(arr[ind] - arr[ind - 2]);
            }

            int curr = Math.min(fs, ss);
            prevprev = prev;
            prev = curr;
        }

        return prev;
    }

    public static int frogJumpK(int index, int[] arr, int jump) {
        if (index == 0) {
            return 0;
        }
        int minStep = Integer.MAX_VALUE;

        for (int ind = 1; ind <= jump; ind++) {
            if ((index - ind) >= 0) {
                int kjump = Math.abs(arr[index] - arr[index - ind]) + frogJumpK(index - ind, arr, jump);
                minStep = Math.min(minStep, kjump);
            }
        }

        return minStep;

    }

    public static int frogJumpKMemo(int index, int[] arr, int jump, int[] dp) {
        if (index == 0) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int minStep = Integer.MAX_VALUE;

        for (int ind = 1; ind <= jump; ind++) {
            if ((index - ind) >= 0) {
                int kjump = Math.abs(arr[index] - arr[index - ind]) + frogJumpKMemo(index - ind, arr, jump, dp);
                minStep = Math.min(minStep, kjump);
            }
        }

        return dp[index] = minStep;
    }

    public static int frogJumpKTabulation(int[] arr, int jump) {
        int[] dp = new int[arr.length];
        dp[0] = 0;

        for (int i = 1; i <= arr.length - 1; i++) {
            int minStep = Integer.MAX_VALUE;

            for (int j = 1; j <= jump; j++) {
                if ((i - j) >= 0) {
                    int kjump = Math.abs(arr[i] - arr[i - j]) + dp[i - j];
                    minStep = Math.min(minStep, kjump);
                }
            }
            dp[i] = minStep;
        }

        return dp[arr.length - 1];
    }

    public static int maximumNonAdjacentSum(int index, int[] nums) {
        if (index == 0) {
            return nums[index];
        }

        if (index < 0) {
            return 0;
        }

        int pick = nums[index] + maximumNonAdjacentSum(index - 2, nums);
        int notpick = maximumNonAdjacentSum(index - 1, nums);

        return Math.max(pick, notpick);
    }

    public static int maximumNonAdjacentSumMemo(int index, int[] nums, int[] dp) {
        if (index == 0) {
            return nums[index];
        }

        if (index < 0) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }

        int pick = nums[index] + maximumNonAdjacentSumMemo(index - 2, nums, dp);
        int notpick = maximumNonAdjacentSumMemo(index - 1, nums, dp);

        return dp[index] = Math.max(pick, notpick);
    }

    public static int maximumNonAdjacentSumTabulation(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        int pick = Integer.MIN_VALUE;

        for (int index = 1; index < nums.length; index++) {
            if (index > 1) {
                pick = nums[index] + dp[index - 2];
            }
            int notpick = dp[index - 1];
            dp[index] = Math.max(pick, notpick);
        }

        return dp[nums.length - 1];
    }

    public static int maximumNonAdjacentSumSpaceOpt(int[] nums) {
        int prev = nums[0];
        int prevprev = 0;

        int pick = Integer.MIN_VALUE;

        for (int index = 1; index < nums.length; index++) {
            if (index > 1) {
                pick = nums[index] + prevprev;
            }
            int notpick = prev;
            int curr = Math.max(pick, notpick);
            prevprev = prev;
            prev = curr;
        }
        
        return prev;
    }

}