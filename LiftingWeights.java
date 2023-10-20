import java.util.List;

class Result {

    /*
     * Complete the 'weightCapacity' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY weights
     *  2. INTEGER maxCapacity
     */

    public static int weightCapacity(List<Integer> weights, int maxCapacity) {
        int n = weights.size();
        boolean[] possible = new boolean[maxCapacity + 1];
        possible[0] = true;

        for (int weight : weights) {
            for (int j = maxCapacity - weight; j >= 0; j--) {
                if (possible[j]) {
                    possible[j + weight] = true;
                }
            }
        }

        for (int i = maxCapacity; i >= 0; i--) {
            if (possible[i]) {
                return i;
            }
        }

        return 0;
    }
}
