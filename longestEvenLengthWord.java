import java.util.*;

class Result {

    /*
     * Complete the 'longestEvenWord' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING sentence as parameter.
     */

    public static String longestEvenWord(String sentence) {
        String[] words = sentence.split(" ");
        String longestWord = "00";
        for (String word : words) {
            if (word.length() % 2 == 0 && word.length() > longestWord.length() && word.matches("[a-zA-Z]+")) {
                longestWord = word;
            }
        }
        return longestWord.equals("00") ? longestWord : longestWord.trim();
    }
}
