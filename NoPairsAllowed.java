class Result {

    /*
     * Complete the 'minimalOperations' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY words as parameter.
     */
public static List<Integer> minimalOperations(List<String> words) {
    List<Integer> ans = new ArrayList<>();
    
    for (String w : words) {
        int count = 0;
        int i = 1;
        while (i < w.length()) {
            if (w.charAt(i) == w.charAt(i - 1)) {
                count++;
                i += 2;
            } else {
                i++;
            }
        }
        ans.add(count);
    }
    
    return ans;
}

}
