package Question;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneKeyPadMapper {
    // Mapping from characters to their corresponding numbers
    private static final Map<Character, String> charToDigitsMap = new HashMap<>();

    static {
        charToDigitsMap.put('a', "2");
        charToDigitsMap.put('b', "2");
        charToDigitsMap.put('c', "2");
        charToDigitsMap.put('d', "3");
        charToDigitsMap.put('e', "3");
        charToDigitsMap.put('f', "3");
        charToDigitsMap.put('g', "4");
        charToDigitsMap.put('h', "4");
        charToDigitsMap.put('i', "4");
        charToDigitsMap.put('j', "5");
        charToDigitsMap.put('k', "5");
        charToDigitsMap.put('l', "5");
        charToDigitsMap.put('m', "6");
        charToDigitsMap.put('n', "6");
        charToDigitsMap.put('o', "6");
        charToDigitsMap.put('p', "7");
        charToDigitsMap.put('q', "7");
        charToDigitsMap.put('r', "7");
        charToDigitsMap.put('s', "7");
        charToDigitsMap.put('t', "8");
        charToDigitsMap.put('u', "8");
        charToDigitsMap.put('v', "8");
        charToDigitsMap.put('w', "9");
        charToDigitsMap.put('x', "9");
        charToDigitsMap.put('y', "9");
        charToDigitsMap.put('z', "9");
    }

    public static void main(String[] args) {
        // Example dictionary
        List<String> dictionary = List.of("at", "on", "good", "no", "home", "gone");

        // Find the input sequence that matches the largest number of words
        String bestMatch = findBestMatchingSequence(dictionary);
        System.out.println("The input sequence that matches the largest number of words is: " + bestMatch);
    }

    private static String findBestMatchingSequence(List<String> dictionary) {
        Map<String, Integer> sequenceCountMap = new HashMap<>();

        // Convert each word to its numeric representation and count occurrences
        for (String word : dictionary) {
            String numericSequence = convertToNumericSequence(word);
            sequenceCountMap.put(numericSequence, sequenceCountMap.getOrDefault(numericSequence, 0) + 1);
        }

        // Find the numeric sequence with the maximum count
        String bestSequence = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : sequenceCountMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                bestSequence = entry.getKey();
            }
        }

        return bestSequence;
    }

    private static String convertToNumericSequence(String word) {
        StringBuilder numericSequence = new StringBuilder();

        // Convert each character in the word to its corresponding number
        for (char c : word.toCharArray()) {
            String digit = charToDigitsMap.get(c);
            if (digit != null) {
                numericSequence.append(digit);
            }
        }

        return numericSequence.toString();
    }
}
