
import java.util.List;

class Result {
    public static int circularArray(int n, List<Integer> endNode) {
        int[] cnt = new int[n];
        for (int i = 0; i < endNode.size() - 1; i++) {
            int u = endNode.get(i) - 1;
            int v = endNode.get(i + 1) - 1;
            if (u < v) {
                for (int j = u; j <= v; j++) {
                    cnt[j] += 1;
                }
            } else {
                for (int j = u; j < n; j++) {
                    cnt[j] += 1;
                }
                for (int j = 0; j <= v; j++) {
                    cnt[j] += 1;
                }
            }
        }
        int maxFreq = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (cnt[i] > maxFreq) {
                maxFreq = cnt[i];
                ans = i + 1;
            }
        }
        return ans;
    }
}
