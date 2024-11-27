package Strings;

import java.util.Arrays;

public class editDistance {
    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));
    }

    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }
        // return minDistance(word1.length() - 1, word2.length() - 1, word1, word2);
        // return minDistanceMemo(word1.length() - 1, word2.length() - 1, word1, word2,
        // dp);
        // return minDistanceTabu(word1, word2);
        // return minDistanceSpaceOpt(word1, word2);
        return minDistance1DSpaceOpt(word1, word2);
    }

    private static int minDistance(int f, int s, String word1, String word2) {
        if (f < 0) {
            return s + 1;
        }

        if (s < 0) {
            return f + 1;
        }

        if (word1.charAt(f) == word2.charAt(s)) {
            return minDistance(f - 1, s - 1, word1, word2);
        }

        int insert = 1 + minDistance(f, s - 1, word1, word2);
        int delete = 1 + minDistance(f - 1, s, word1, word2);
        int replace = 1 + minDistance(f - 1, s - 1, word1, word2);

        return Math.min(insert, Math.min(delete, replace));
    }

    private static int minDistanceMemo(int f, int s, String word1, String word2, int[][] dp) {

        if (f < 0) {
            return s + 1;
        }

        if (s < 0) {
            return f + 1;
        }
        if (dp[f][s] != -1) {
            return dp[f][s];
        }

        if (word1.charAt(f) == word2.charAt(s)) {
            return minDistanceMemo(f - 1, s - 1, word1, word2, dp);
        }

        int insert = 1 + minDistanceMemo(f, s - 1, word1, word2, dp);
        int delete = 1 + minDistanceMemo(f - 1, s, word1, word2, dp);
        int replace = 1 + minDistanceMemo(f - 1, s - 1, word1, word2, dp);

        return dp[f][s] = Math.min(insert, Math.min(delete, replace));
    }

    private static int minDistanceTabu(String word1, String word2) {

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {

                    int insert = 1 + dp[i][j - 1];
                    int delete = 1 + dp[i - 1][j];
                    int replace = 1 + dp[i - 1][j - 1];
                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }

    private static int minDistanceSpaceOpt(String word1, String word2) {

        int[] prev = new int[word2.length() + 1];
        
        for (int i = 0; i <= word2.length(); i++) {
            prev[i] = i;
        }
        for (int i = 1; i <= word1.length(); i++) {
            int[] curr = new int[word2.length() + 1];
            curr[0] = i;
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else {

                    int insert = 1 + curr[j - 1];
                    int delete = 1 + prev[j];
                    int replace = 1 + prev[j - 1];
                    curr[j] = Math.min(insert, Math.min(delete, replace));
                }
            }
            prev = curr;
        }

        return prev[word2.length()];
    }
    
}
