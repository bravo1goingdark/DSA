package Strings;

public class MinLenToConvertStrAToStrB {
    public static int minDistance(String word1, String word2) {
        return word1.length() + word2.length() - 2 * longestCommonSubsequenceSpaceOpt(word1, word2);
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
