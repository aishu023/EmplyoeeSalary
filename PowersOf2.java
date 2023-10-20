import java.util.*;

class Result {

    /*
     * Complete the 'isPower' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> isPower(List<Integer> arr) {
        List<Integer> ans = new ArrayList<>();
        for (int x : arr) {
            if (x == 0) {
                ans.add(0);
            } else if ((x & (x - 1)) == 0) {
                ans.add(1);
            } else {
                ans.add(0);
            }
        }
        return ans;
    }
}
