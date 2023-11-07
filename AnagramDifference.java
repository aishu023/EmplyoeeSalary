
import java.util.List;
import java.util.ArrayList;

class Result {
    public static List<Integer> getMinimumDifference(List<String> a, List<String> b) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            String s1 = a.get(i);
            String s2 = b.get(i);
            // Strings can't become anagrams if lengths are different
            if (s1.length() != s2.length()) {
                ans.add(-1);
                continue;
            }
            int[] a1 = new int[26];
            int[] a2 = new int[26];
            // Storing counts of all characters in both strings
            for (char c : s1.toCharArray()) {
                a1[c - 'a'] += 1;
            }
            for (char c : s2.toCharArray()) {
                a2[c - 'a'] += 1;
            }

            int cnt = 0;
            for (int j = 0; j < 26; j++) {
                cnt += Math.abs(a1[j] - a2[j]);
            }
            ans.add((int) Math.ceil(cnt / 2.0));
        }
        return ans;
    }
}
