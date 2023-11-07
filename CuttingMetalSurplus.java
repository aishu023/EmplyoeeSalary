import java.util.*;

 class Result {
    public static int maxProfit(int costPerCut, int salePrice, List<Integer> lengths) {
        int maxProfit = 0;

        // Find the maximum length
        int maxLength = Collections.max(lengths);

        for (int saleLength = 1; saleLength <= maxLength; saleLength++) {
            int totalUniformRods = 0;
            int totalCuts = 0;

            for (int i = 0; i < lengths.size(); i++) {
                int rod = lengths.get(i);
                int rodsFromCurrentRod = rod / saleLength;
                if (rod % saleLength == 0) {
                    totalCuts += rodsFromCurrentRod - 1;
                } else {
                    totalCuts += rodsFromCurrentRod;
                }
                totalUniformRods += rodsFromCurrentRod;
            }

            int totalProfit = (totalUniformRods * saleLength * salePrice) - (totalCuts * costPerCut);
            maxProfit = Math.max(maxProfit, totalProfit);
        }

        return maxProfit;
    }
}
