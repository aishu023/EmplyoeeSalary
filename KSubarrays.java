class Result {

    /*
     * Complete the 'kSub' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY nums
     */
public static long kSub(int k, List<Integer> nums) {
        Map<Integer, Integer> remainderFreq = new HashMap<>();
        remainderFreq.put(0, 1);
        int sum = 0;
        long count = 0;

        for (int num : nums) {
            sum = (sum + num) % k;
            if (sum < 0) {
                sum += k;
            }
            count += remainderFreq.getOrDefault(sum, 0);
            remainderFreq.put(sum, remainderFreq.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}


