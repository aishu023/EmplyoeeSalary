
import java.util.Arrays;

import java.util.Arrays;

class Result {

    public static int find(int x, String secondString, int[] pre, int[] suff) {
        int n = secondString.length();
        if (x == n) {
            return 1;
        }
        if (suff[x] != -1) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            int st = i;
            int end = i + x + 1;
            if (end >= n) {
                if (pre[st] != -1) {
                    return 1;
                } else {
                    return 0;
                }
            }
            if (pre[st] != -1 && suff[end] != -1 && pre[st] < suff[end]) {
                return 1;
            }
        }
        return 0;
    }

    public static int findDifferenceValue(String firstString, String secondString) {
        int n = secondString.length();
        int[] pre = new int[n];
        int[] suff = new int[n];
        Arrays.fill(pre, -1);
        Arrays.fill(suff, -1);
        int i = 0;
        for (int k = 0; k < firstString.length(); k++) {
            if (firstString.charAt(k) == secondString.charAt(i)) {
                pre[i] = k;
                i += 1;
                if (i == secondString.length()) {
                    break;
                }
            }
        }
        i = secondString.length() - 1;
        for (int k = firstString.length() - 1; k >= 0; k--) {
            if (firstString.charAt(k) == secondString.charAt(i)) {
                suff[i] = k;
                i -= 1;
                if (i == -1) {
                    break;
                }
            }
        }
        int st = 0;
        int end = n;
        int ans = n;
        while (st <= end) {
            int mid = (st + end) / 2;
            int fi = find(mid, secondString, pre, suff);
            if (fi == 1) {
                ans = mid;
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }
        return ans;
    }
}
