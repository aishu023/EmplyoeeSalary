import java.util.*;

class Result {
    public static int findMinCost(List<Integer> efficiency) {
        int n = efficiency.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = efficiency.get(i);
        }
        Arrays.sort(arr);

        List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            diff.add(arr[i + 1] - arr[i]);
        }
        int suffix_odd = 0;
        int prefix_even = 0;
        for (int i = 0; i < n - 1; i++) {
            if (i % 2 == 1) {
                suffix_odd += diff.get(i);
            }
        }
        int ans = suffix_odd;
        for (int i = 0; i < n - 1; i++) {
            if (i % 2 == 1) {
                suffix_odd -= diff.get(i);
            } else {
                prefix_even += diff.get(i);
            }

            ans = Math.min(ans, prefix_even + suffix_odd);
        }
        return ans;
    }
}
