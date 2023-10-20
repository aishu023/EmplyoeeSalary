import java.util.Collections;
import java.util.List;

class Result {

    /*
     * Complete the 'getMaximumMEX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int getMaximumMEX(List<Integer> arr) {
        Collections.sort(arr);
        int ans = 0;
        for (int elem : arr) {
            System.out.println(elem);
            ans = ans + ((elem >= ans) ? 1 : 0);
        }
        return ans;
    }
}
