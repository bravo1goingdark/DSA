package Strings;

import java.util.Arrays;

public class LCS {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }

        // return longestCommonSubsequence(text1.length() - 1, text2.length() - 1,
        // text1, text2);
        // return longestCommonSubsequenceMemo(text1.length() - 1, text2.length() - 1, text1, text2, dp);
        return longestCommonSubsequenceTabu(text1, text2);
        // return longestCommonSubsequenceSpaceOpt(text1, text2);
    }

    private static int longestCommonSubsequence(int firstStr, int secondStr, String text1, String text2) {
        if (firstStr < 0 || secondStr < 0) {
            return 0;
        }

        if (text1.charAt(firstStr) == text2.charAt(secondStr)) {
            return 1 + longestCommonSubsequence(firstStr - 1, secondStr - 1, text1, text2);
        }

        return Math.max(longestCommonSubsequence(firstStr - 1, secondStr, text1, text2),
                longestCommonSubsequence(firstStr, secondStr - 1, text1, text2));

    }

    private static int longestCommonSubsequenceMemo(int firstStr, int secondStr, String text1, String text2,
            int[][] dp) {
        if (firstStr < 0 || secondStr < 0) {
            return 0;
        }

        if (dp[firstStr][secondStr] != -1) {
            return dp[firstStr][secondStr];
        }

        if (text1.charAt(firstStr) == text2.charAt(secondStr)) {
            return 1 + longestCommonSubsequenceMemo(firstStr - 1, secondStr - 1, text1, text2, dp);
        }

        return dp[firstStr][secondStr] = Math.max(
                longestCommonSubsequenceMemo(firstStr - 1, secondStr, text1, text2, dp),
                longestCommonSubsequenceMemo(firstStr, secondStr - 1, text1, text2, dp));

    }

    private static int longestCommonSubsequenceTabu(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 0; i <= text1.length(); i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= text2.length(); i++) {
            dp[0][i] = 0;
        }


        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }
        
        for (int[] is : dp) {
            System.out.println(Arrays.toString(is));
        }

        return dp[text1.length()][text2.length()];
    }

    private static int longestCommonSubsequenceSpaceOpt(String text1, String text2) {
        int[] prev = new int[text2.length() + 1];

        for (int i = 0; i <= text2.length(); i++) {
            prev[i] = 0;
        }


        for (int i = 1; i <= text1.length(); i++) {
            int[] curr = new int[text2.length() + 1];
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                } else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }

            }
            prev = curr;
        }

        return prev[text2.length()];
    }
}
