package Strings;

// same as longest common substring queston

public class maxLengthSubarray {

    public static void main(String[] args) {
        System.out.println(findLengthSpaceOpt(new int[] { 0, 0, 0, 0, 0 }, new int[] { 0, 0, 0, 0, 0 }));
    }

    private static int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }
        int ans = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return ans <= Integer.MIN_VALUE ? 0 : ans;
    }

    private static int findLengthSpaceOpt(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] prev = new int[m + 1];

        for (int i = 0; i <= m; i++) {
            prev[i] = 0;
        }

        int ans = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            for (int j = 1; j <= m; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    curr[j] = 1 + prev[j - 1];
                    ans = Math.max(ans, curr[j]);
                } else {
                    curr[j] = 0;
                }
            }
            prev = curr;
        }
        
        return ans <= Integer.MIN_VALUE ? 0 : ans;
    }
}
