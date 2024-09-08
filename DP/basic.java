import java.util.Arrays;

public class basic {
    public static void main(String[] args) {
        long[] dp = new long[46];
        Arrays.fill(dp, -1);
        // System.out.println(FiboSpaceOpt(40));

        // System.out.println(climbStairMemo(45 , dp));
        // System.out.println(FiboMemo(45, dp));
        // System.out.println(FiboTabulation(40));
        // System.out.println(climbStairSpaceOpt(45));
        // System.out.println(minCostClimbingStairs(new int[]{10,15,20}));
        System.out.println(minCostClimbingStairsTabulation(new int[]{10,15,20}));
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

    public static long climbStairMemo(int stair , long[] dp) {
        if (stair == 1 || stair == 0) {
            return 1;
        }

        if (dp[stair] != -1) {
            return dp[stair];
        }

        return dp[stair] = climbStairMemo(stair - 1 , dp) + climbStairMemo(stair - 2 , dp);
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
            }else {
                dp[index] = cost[index] + Math.min(dp[index - 1], dp[index - 2]);
            }
        }

        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

}