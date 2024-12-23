import java.util.ArrayList;
import java.util.List;


// leetcode 28
public class KMP {
    public static void main(String[] args) {
        System.out.println(kmp("ababcababcabab", "ababc"));
    }

    public static List<Integer> kmp(String str, String pattern) {
        int[] lps = getLPS(pattern);
        List<Integer> ans = new ArrayList<>();
        int first = 0;
        int second = 0;

        while (first < str.length()) {
            if (str.charAt(first) == pattern.charAt(second)) {
                first++;
                second++;

                if (second == pattern.length()) {
                    ans.add(first - second);
                    second = lps[second - 1];
                }
            } else {
                if (second > 0) {
                    second = lps[second - 1];
                } else {
                    first++;
                }
            }

        }
        return ans;

    }

    public static int[] getLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int first = 0;
        int second = 1;

        lps[0] = 0;

        while (second < pattern.length()) {
            if (pattern.charAt(first) == pattern.charAt(second)) {

                lps[second] = first + 1;
                first++;
                second++;

            } else {

                // mismatch after matching some string
                if (first > 0) {
                    first = lps[first - 1];
                } else {
                    lps[second] = 0;
                    second++;
                }
            }
        }
        return lps;
    }

}