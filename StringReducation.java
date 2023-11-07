class Result {
    public static int getMinDeletions(String s) {
        int[] freq = new int[26];
        // get the frequency per character
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        int cnt = s.length();
        // reduce by 1 for each character that occurs
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                cnt--;
            }
        }
        return cnt;
    }
}
