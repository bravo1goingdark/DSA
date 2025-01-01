package Strings;

public class wildcardMatching {
    public static void main(String[] args) {
        // System.out.println(isMatch("cb", "?a"));
        System.out.println(isMatch("aa", "*"));
    }

    public static boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length()][p.length()];
        // return isMatchHelper(s.length() - 1, p.length() - 1, s, p);
        // return isMatchHelperMemo(s.length() - 1, p.length() - 1, s, p, dp);
        // return isMatchHelperTabu(s, p);
        return isMatchHelperSpaceOpt(s, p);
    }

    private static boolean isMatchHelper(int first, int second, String s, String p) {
        if (first < 0 && second < 0) {
            return true;
        }

        if (second < 0) {
            return false;
        }

        if (first < 0 && second >= 0) {
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
            return isMatchHelper(first - 1, second, s, p) || isMatchHelper(first, second - 1, s, p);
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

        if (first < 0 && second >= 0) {
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
            return dp[first][second] = isMatchHelperMemo(first - 1, second, s, p, dp) ||
                    isMatchHelperMemo(first, second - 1, s, p, dp);
        }

        return dp[first][second] = false;
    }

    private static boolean isMatchHelperTabu(String s, String p) {
        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
        
        dp[0][0] = true;
        for (int i = 1; i <= s.length(); i++) {
            dp[i][0] = false;
        }
        for (int j = 1; j <= p.length(); j++) {
            dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 1];
        }
    
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1]; 
                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; 
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    private static boolean isMatchHelperSpaceOpt(String s, String p) {
        Boolean[] prev = new Boolean[p.length() + 1];
        Boolean[] curr = new Boolean[p.length() + 1];
        
        prev[0] = true;

        for (int j = 1; j <= p.length(); j++) {
            prev[j] = p.charAt(j - 1) == '*' && prev[j - 1];
        }
    
        for (int i = 1; i <= s.length(); i++) {
            curr[0] = false;
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '*') {
                    curr[j] = prev[j] || curr[j - 1]; 
                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    curr[j] = prev[j - 1]; 
                } else {
                    curr[j] = false;
                }
            }
            Boolean[] temp = prev;
            prev = curr;
            curr = temp;
        }
        return prev[p.length()];
    }
    
}
