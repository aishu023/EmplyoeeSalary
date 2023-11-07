import java.util.Arrays;
import java.util.Comparator;

class Result {

    public static String arrange(String sentence) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll("[^a-zA-Z]", "");
        }
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String a, String b) {
                if (a.length() != b.length()) {
                    return a.length() - b.length();
                } else {
                    return 0;
                }
            }
        });
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                result.append(Character.toUpperCase(words[i].charAt(0)) + words[i].substring(1));
            } else {
                result.append(" " + words[i].toLowerCase());
            }
        }
        result.append(".");
        return result.toString();
    }

}
