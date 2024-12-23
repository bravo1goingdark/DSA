import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class question {
    public boolean isAnagram(String s, String t) {
        // Check if the lengths of the strings are different
        if (s.length() != t.length()) {
            return false;
        }
        
        // Convert the strings to character arrays
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        
        // Sort the character arrays
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        
        // Compare the sorted arrays
        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] != tChars[i]) {
                return false;
            }
        }
        
        return true;
    }

    public int countDigitOne(int n) {
        int count = 0;
        countDigitOne(count , n);
        return count;
    }

    private void countDigitOne(int count, int n) {
        for (int i = 1; i <=n ; i++) {
            
        }
    }

}
