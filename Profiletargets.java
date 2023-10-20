import java.util.*;

public class Result {

    public static int stockPairs(List<Integer> stocksProfit, long target) {
        Set<Integer> stockValues = new HashSet<>(stocksProfit);
        int ans = 0;
        for (int value : stockValues) {
            if (stockValues.contains((int) (target - value)) && target != 2 * value) {
                ans += 1;
            }
        }
        if (target % 2 == 0 && stocksProfit.indexOf((int) (target / 2)) != stocksProfit.lastIndexOf((int) (target / 2))) {
            ans += 2;
        }
        return ans / 2;
    }
}

