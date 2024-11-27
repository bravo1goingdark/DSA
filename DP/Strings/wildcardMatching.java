package Strings;

import java.util.Arrays;

public class wildcardMatching {
    public static void main(String[] args) {
        System.out.println(isMatch("cb", "?a"));
        System.out.println(isMatch("adceb", "*a*b"));
    }

    public static boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length()][p.length()];
        // return isMatchHelper(s.length() - 1, p.length() - 1, s, p);
        return isMatchHelperMemo(s.length() - 1, p.length() - 1, s, p, dp);
    }

    private static boolean isMatchHelper(int first, int second, String s, String p) {
        if (first < 0 && second < 0) {
            return true;
        }

        if (second < 0) {
            return false;
        }

        if (first < 0) {
            for (int i = 0; i <= second; i++) {
                if (p.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        }

        if (s.charAt(first) == p.charAt(second) || p.charAt(second) == '?') {
            return isMatchHelper(first - 1, second - 1, s, p);
        }

        if (p.charAt(second) == '*') {
            return isMatchHelper(first - 1, second, s, p) ||
                    isMatchHelper(first, second - 1, s, p);
        }

        return false;
    }

    private static boolean isMatchHelperMemo(int first, int second, String s, String p, Boolean[][] dp) {
        if (first < 0 && second < 0) {
            return true;
        }

        if (second < 0) {
            return false;
        }

        if (first < 0) {
            for (int i = 0; i <= second; i++) {
                if (p.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        }

        if (dp[first][second] != null) {
            return dp[first][second];
        }

        if (s.charAt(first) == p.charAt(second) || p.charAt(second) == '?') {
            return dp[first][second] = isMatchHelperMemo(first - 1, second - 1, s, p, dp);
        }

        if (p.charAt(second) == '*') {
            return dp[first][second] =  isMatchHelperMemo(first - 1, second, s, p, dp) ||
                   isMatchHelperMemo(first, second - 1, s, p, dp);
        }

        return dp[first][second] = false;
    }
}
