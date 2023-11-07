
import java.util.List;
import java.util.ArrayList;

class Result {
    public static List<Integer> mergeArrays(List<Integer> a, List<Integer> b) {
        int n1 = a.size();
        int n2 = b.size();
        List<Integer> ret = new ArrayList<>();
        int i = 0, j = 0;

        // Simultaneously iterate over arrays a and b and append whichever is smaller to the merged array
        while (i < n1 && j < n2) {
            if (a.get(i) < b.get(j)) {
                ret.add(a.get(i));
                i++;
            } else {
                ret.add(b.get(j));
                j++;
            }
        }
        // Append any remaining elements to the merged array
        while (i < n1) {
            ret.add(a.get(i));
            i++;
        }
        while (j < n2) {
            ret.add(b.get(j));
            j++;
        }
        return ret;
    }
}
