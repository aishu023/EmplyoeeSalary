import java.util.HashMap;
import java.util.Map;

class Result {
    public static int countPerms(int n) {
        long mod = 1000000007L;
        String vowels = "aeiou";
        Map<Character, Long> dp = new HashMap<>();
        for (char c : vowels.toCharArray()) {
            dp.put(c, 1L);
        }
        for (int i = 1; i < n; i++) {
            Map<Character, Long> temp = new HashMap<>();
            temp.put('a', (dp.get('e') + dp.get('i') + dp.get('u')) % mod);
            temp.put('e', (dp.get('a') + dp.get('i')) % mod);
            temp.put('i', (dp.get('e') + dp.get('o')) % mod);
            temp.put('o', dp.get('i') % mod);
            temp.put('u', (dp.get('i') + dp.get('o')) % mod);
            dp = temp;
        }
        long ret = 0;
        for (long val : dp.values()) {
            ret = (ret + val) % mod;
        }
        return (int) ret;
    }
}
