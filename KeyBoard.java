
import java.util.HashMap;
import java.util.Map;

class Result {
    public static int entryTime(String s, String keypad) {
        Map<Character, int[]> keyMap = new HashMap<>();
        int[][] coordinates = {{0, 0}, {0, 1}, {0, 2}, {1, 0}, {1, 1}, {1, 2}, {2, 0}, {2, 1}, {2, 2}};
        for (int i = 0; i < 9; i++) {
            keyMap.put(keypad.charAt(i), coordinates[i]);
        }
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            int[] current = keyMap.get(s.charAt(i));
            int[] prev = keyMap.get(s.charAt(i - 1));
            ans += Math.max(Math.abs(current[0] - prev[0]), Math.abs(current[1] - prev[1]));
        }
        return ans;
    }
}
