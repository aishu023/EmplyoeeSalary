import java.util.List;

class Result {
    public static int maximumPoints(int k, List<Integer> costs) {
        // Write your code here
        int mx = 0;
        int summ = 0;
        int ans = 0;

        if (costs.stream().mapToInt(Integer::intValue).sum() <= k) {
            return costs.size();
        }

        for (int idx = 0; idx < costs.size(); idx++) {
            int val = costs.get(idx);
            mx = Math.max(mx, val);
            summ += val;
            if (summ - mx <= k) {
                ans = idx;
            }
        }

        return ans;
    }
}
