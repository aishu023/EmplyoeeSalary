import java.util.*;

class Result {

    /*
     * Complete the 'maximumProfit' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY inventory
     *  2. LONG_INTEGER order
     */

    public static long maximumProfit(List<Integer> inventory, long order) {
        // Sort the inventory in descending order to maximize profit
        Collections.sort(inventory, Collections.reverseOrder());
        long result = 0;
        long count = 1;
        int mod = 1000000007;
        
        for (int i = 0; i < inventory.size() && order > 0; i++) {
            if (i < inventory.size() - 1 && inventory.get(i) > inventory.get(i + 1)) {
                long diff = inventory.get(i) - inventory.get(i + 1);
                if (diff * count <= order) {
                    long sum = (inventory.get(i) + inventory.get(i + 1) + 1) * diff / 2 * count;
                    result = (result + sum) % mod;
                    order -= diff * count;
                } else {
                    long rows = order / count;
                    long sum = (inventory.get(i) + inventory.get(i) - rows + 1) * rows / 2 * count;
                    result = (result + sum) % mod;
                    long remain = order % count;
                    result = (result + remain * (inventory.get(i) - rows)) % mod;
                    order = 0;
                }
            } else {
                long rows = order / count;
                long sum = (inventory.get(i) + inventory.get(i) - rows + 1) * rows / 2 * count;
                result = (result + sum) % mod;
                long remain = order % count;
                result = (result + remain * (inventory.get(i) - rows)) % mod;
                order = 0;
            }
            count++;
        }
        return result;
    }

}
