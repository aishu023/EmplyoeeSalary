import java.util.List;

class Result {
    public static int maxTrailing(List<Integer> arr) {
        if (arr.size() < 2) {
            return -1;
        }

        int maxDiff = -1;
        int minSoFar = arr.get(0);

        for (int i = 1; i < arr.size(); i++) {
            int current = arr.get(i);
            if (current > minSoFar) {
                maxDiff = Math.max(maxDiff, current - minSoFar);
            } else {
                minSoFar = current;
            }
        }

        return maxDiff;
    }
}
