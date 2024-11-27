package Strings;

import java.util.Arrays;

public class DistinctSubsequence {
    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
    }

    public static int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for (int[] is : dp) {
            Arrays.fill(is, -1);
        }

        // return numDistinct(s.length() - 1, t.length() - 1, s, t);
        // return numDistinctMemo(s.length() - 1, t.length() - 1, s, t, dp);
        // return numDistinctTabu(s, t);
        return numDistinctSpaceOpt(s, t);

    }

    private static int numDistinct(int first, int second, String s, String t) {
        if (first < 0) {
            return second < 0 ? 1 : 0;
        }
        if (second < 0) {
            return 1;
        }

        if (s.charAt(first) == t.charAt(second)) {
            return numDistinct(first - 1, second - 1, s, t) + numDistinct(first - 1, second, s, t);
        }

        return numDistinct(first - 1, second, s, t);

    }

    private static int numDistinctMemo(int first, int second, String s, String t, int[][] dp) {
        if (first < 0) {
            return second < 0 ? 1 : 0;
        }
        if (second < 0) {
            return 1;
        }
        if (dp[first][second] != -1) {
            return dp[first][second];
        }

        if (s.charAt(first) == t.charAt(second)) {
            return dp[first][second] = numDistinctMemo(first - 1, second - 1, s, t, dp)
                    + numDistinctMemo(first - 1, second, s, t, dp);
        }

        return dp[first][second] = numDistinctMemo(first - 1, second, s, t, dp);

    }

    private static int numDistinctTabu(String s, String t) {

        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }

        // doesn't need to do again , since it is already intialized with 0
        // for (int i = 0; i <= t.length(); i++) {
        //     dp[0][i] = 0;
        // }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[s.length()][t.length()];
    }

    private static int numDistinctSpaceOpt(String s, String t) {

        int[] prev = new int[t.length() + 1];
        int[] curr = new int[t.length() + 1];
        prev[0] = 1;
        curr[0] = 1;
    
        for (int i = 1; i <= s.length(); i++) {
            
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + prev[j];
                } else {
                    curr[j] = prev[j];
                }
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[t.length()];
    }

    private static int numDistinct1DSpaceOpt(String s, String t) {
        int[] prev = new int[t.length() + 1];
        prev[0] = 1;   

        for (int i = 1; i <= s.length(); i++) {
            
            for (int j = t.length(); j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    prev[j] = prev[j - 1] + prev[j];
                } 
            }    
        }
        
        return prev[t.length()];
    }
}
