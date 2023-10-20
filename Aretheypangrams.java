
class Result {

    /*
     * Complete the 'isPangram' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY pangram as parameter.
     */

    public static String isPangram(List<String> pangram) {
     StringBuilder answer = new StringBuilder();

        for (String sentence : pangram) {
            int[] seen = new int[26];
            int count = 0;
            for (char c : sentence.toCharArray()) {
                if (c != ' ') {
                    int idx = c - 'a';
                    if (seen[idx] == 0) {
                        seen[idx] += 1;
                        count += 1;
                    }
                    if (count == 26) {
                        break;
                    }
                }
            }
            answer.append(count == 26 ? '1' : '0');
        }

        return answer.toString();

    }

}
