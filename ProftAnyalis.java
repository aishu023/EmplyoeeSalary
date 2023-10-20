import java.util.List;

class Result {

    public static long getMaxProfit(List<Integer> pnl, int k) {
        long maxSum = Long.MIN_VALUE;
        long currentSum = 0;

        int start = 0;
        for (int i = 0; i < pnl.size(); i++) {
            currentSum += pnl.get(i);

            if (i - start + 1 > k) {
                currentSum -= pnl.get(start);
                start++;
            }

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
