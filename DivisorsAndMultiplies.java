import java.util.*;

class Result {

    public static List<Integer> getCount(List<Integer> arr) {
        int mx = Collections.max(arr) + 1;
        int[] cnt = new int[mx];
        int[] ans = new int[mx];
        for (int item : arr) {
            cnt[item] += 1;
        }

        for (int i = 1; i < mx; i++) {
            for (int j = i + i; j < mx; j += i) {
                ans[i] += cnt[j];
                ans[j] += cnt[i];
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int item : arr) {
            result.add(cnt[item] - 1 + ans[item]);
        }
        return result;
    }
}
