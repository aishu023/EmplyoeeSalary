class Result {

    /*
     * Complete the 'getUniqueCharacter' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int getUniqueCharacter(String s) {
    // Write your code here
 HashMap<Character, Integer> charFrequency = new HashMap<>();

        // Count the frequency of each character in the string
        for (char c : s.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }

        // Find the first unique character and return its index
        for (int i = 0; i < s.length(); i++) {
            if (charFrequency.get(s.charAt(i)) == 1) {
                return i + 1;
            }
        }

        return -1; // 
    
    }
}
