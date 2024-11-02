package Subsequence;

public class PartiSubsetMinAbsDiff {
    public int minimumDifference(int[] arr) {
        int totalSum = getTotalSum(arr);
        boolean[][] dp = new boolean[arr.length][totalSum + 1];
        
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = true;
        }
        
        if (arr[0] <= totalSum) {
            dp[0][arr[0]] = true;
        }
    
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= totalSum; j++) {
                boolean notTake = dp[i - 1][j];
                boolean take = (j >= arr[i]) ? dp[i - 1][j - arr[i]] : false;
                dp[i][j] = notTake || take;
            }
        }
        
        int minDiff = Integer.MAX_VALUE;
        for (int s1 = 0; s1 <= totalSum / 2; s1++) {
            if (dp[arr.length - 1][s1]) {
                int s2 = totalSum - s1;
                minDiff = Math.min(minDiff, Math.abs(s2 - s1));
            }
        }
        
        return minDiff;
    }
    
    public static int getTotalSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
}
