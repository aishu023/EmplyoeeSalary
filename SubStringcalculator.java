import java.util.HashSet;
import java.util.Set;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
}

class Result {

    public static long substringCalculator(String s) {
        TrieNode root = new TrieNode();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            TrieNode current = root;
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (current.children[c - 'a'] == null) {
                    current.children[c - 'a'] = new TrieNode();
                    count++;
                }
                current = current.children[c - 'a'];
            }
        }

        return count;
    }
}
