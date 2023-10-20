import java.lang.Math;

class Result {
    public static long beacon_signal(int x1, int y1, int x2, int y2, int xl, int yl, int R) {
        long count = 0;
        y1 = Math.max(y1, yl - R);
        y2 = Math.min(y2, yl + R);
        for (int y = y1; y <= y2; y++) {
            int squared_delta = (int) Math.abs(R * R - (y - yl) * (y - yl));
            int delta_x = (int) Math.sqrt(squared_delta);
            int x_approx_start = Math.max(x1, xl - delta_x);
            int x_approx_end = Math.min(x2, xl + delta_x);
            int x_start = binary_search_for_x_start(x_approx_start, y, xl, yl, R, x1, x2);
            int x_end = binary_search_for_x_end(x_approx_end, y, xl, yl, R, x1, x2);
            count += Math.max(0, x_end - x_start + 1);
        }
        return count;
    }

    private static int binary_search_for_x_start(int x, int y, int xl, int yl, int R, int x1, int x2) {
        int left = x1, right = x;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (Math.pow(mid - xl, 2) + Math.pow(y - yl, 2) <= Math.pow(R, 2)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int binary_search_for_x_end(int x, int y, int xl, int yl, int R, int x1, int x2) {
        int left = x, right = x2;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (Math.pow(mid - xl, 2) + Math.pow(y - yl, 2) <= Math.pow(R, 2)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
