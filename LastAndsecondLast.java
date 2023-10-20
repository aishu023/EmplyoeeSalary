import java.util.*;

class Result {

    /*
     * Complete the 'lastLetters' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING word as parameter.
     */

    public static String lastLetters(String word) {
        if (word.length() < 2) {
            // return an empty string if the length of the word is less than 2
            return "";
        } else {
            // extract the last two characters and return them in reverse order
            char last = word.charAt(word.length() - 1);
            char secondLast = word.charAt(word.length() - 2);
            return last + " " + secondLast;
        }
    }

}
