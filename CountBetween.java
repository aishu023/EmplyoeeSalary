import java.util.*;

class Result {
    public static List<Integer> countBetween(List<Integer> arr, List<Integer> low, List<Integer> high) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < low.size(); i++) {
            int count = 0;
            int l = low.get(i);
            int h = high.get(i);
            for (int num : arr) {
                if (num >= l && num <= h) {
                    count++;
                }
            }
            result.add(count);
        }
        return result;
    }
}
