import java.util.*;

class Result {

    public static List<Integer> commonPrefix(List<String> inputs) {
        List<Integer> results = new ArrayList<>();
        for (String input : inputs) {
            int sum = 0;
            for (int i = 0; i < input.length(); i++) {
                sum += getCommonPrefixLength(input, i);
            }
            results.add(sum);
        }
        return results;
    }

    private static int getCommonPrefixLength(String str, int start) {
        int commonPrefix = 0;
        for (int i = 0; i < str.length() - start; i++) {
            if (str.charAt(i) == str.charAt(start + i)) {
                commonPrefix++;
            } else {
                break;
            }
        }
        return commonPrefix;
    }
}
