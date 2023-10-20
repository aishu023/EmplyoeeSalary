import java.util.List;

class Result {

    public static int maxHeight(List<Integer> wallPositions, List<Integer> wallHeights) {
        int n = wallPositions.size();
        if (n < 2) {
            return 0;
        }

        int maxHeight = 0;
        for (int i = 0; i < n - 1; i++) {
            int pos1 = wallPositions.get(i);
            int pos2 = wallPositions.get(i + 1);
            int h1 = wallHeights.get(i);
            int h2 = wallHeights.get(i + 1);

            if (pos2 - pos1 > 1) {
                int minHeight = Math.min(h1, h2);
                int maxHeightPossible = Math.max(h1, h2);
                int distance = pos2 - pos1;

                if (maxHeightPossible - minHeight <= distance) {
                    maxHeight = Math.max(maxHeight, minHeight + distance - 1);
                } else {
                    int currMax = Math.min(maxHeightPossible, minHeight) + distance - 1;
                    maxHeight = Math.max(maxHeight, currMax);
                }
            }
        }

        return maxHeight;
    }
}
