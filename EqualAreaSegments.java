import java.util.*;

class Result {
    public static String largestSegment(List<Integer> radius, int segments) {
        double low = 0;
        double high = 1e16; // Set a high value for the binary search

        while (high - low > 1e-6) {
            double mid = (low + high) / 2;
            if (isValid(radius, segments, mid)) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return String.format("%.4f", low);
    }

    private static boolean isValid(List<Integer> radius, int segments, double area) {
        long count = 0;
        for (int r : radius) {
            count += Math.floor(Math.PI * r * r / area);
        }
        return count >= segments;
    }
}
