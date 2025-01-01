package Strings;

public class SCSuperSequence {
    public static void main(String[] args) {
        System.out.println(shortestCommonSupersequence("abac", "cab"));
    }
    public static String shortestCommonSupersequence(String str1, String str2) {
        return printlongestCommonSubsequenceTabu(str1.length(), str2.length(), str1, str2);
    }
    private static String printlongestCommonSubsequenceTabu(int n, int m, String text1, String text2) {
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder lcs = new StringBuilder();
        int i = n, j = m;

        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                lcs.append(text1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                lcs.append(text1.charAt(i - 1));
                i--;
            } else {
                lcs.append(text2.charAt(j - 1));
                j--;
            }
        }

        while (i > 0) {
            lcs.append(text1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            lcs.append(text2.charAt(j - 1));
            j--;
        }

        return lcs.reverse().toString();
    }
}
