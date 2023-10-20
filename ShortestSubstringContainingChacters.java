import java.util.HashSet;
import java.util.Set;

class Result {
    public static int shortestSubstring(String givenString) {
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : givenString.toCharArray()) {
            uniqueChars.add(c);
        }

        int n = uniqueChars.size();
        int[] charCount = new int[26];
        int left = 0, right = 0, distinct = 0, minLength = Integer.MAX_VALUE;

        while (right < givenString.length()) {
            char currChar = givenString.charAt(right);
            if (charCount[currChar - 'a'] == 0) {
                distinct++;
            }
            charCount[currChar - 'a']++;

            while (distinct == n) {
                minLength = Math.min(minLength, right - left + 1);
                char leftChar = givenString.charAt(left);
                charCount[leftChar - 'a']--;
                if (charCount[leftChar - 'a'] == 0) {
                    distinct--;
                }
                left++;
            }
            right++;
        }

        return minLength;
    }
}
