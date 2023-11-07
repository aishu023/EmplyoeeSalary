
import java.util.Collections;
import java.util.List;

class Result {

    public static int efficientJanitor(List<Float> weight) {
        Collections.sort(weight);
        int n = weight.size();
        int lo = 0;
        int hi = n - 1;
        int ans = 0;
        while (lo < hi) {
            // too big to pair, so decrement hi
            if (weight.get(lo) + weight.get(hi) > 3.0) {
                hi = hi - 1;
            }
            // small enough to pair, so increment lo, decrement hi
            else {
                lo = lo + 1;
                hi = hi - 1;
            }
            // increment trip counter in either case
            ans = ans + 1;
        }
        // a bag is left, so 1 more trip
        if (lo == hi) {
            ans = ans + 1;
        }
        return ans;
    }
}
