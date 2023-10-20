import java.util.*;

class Result {
    public static List<Integer> rearrange(List<Integer> arr) {
        // sort the array ascending
        Collections.sort(arr);
        // use two pointers, multiply by lowest value in the upper
        // half of the array, divide by the lowest value in the lower
        // half of the array to get maximum U, minimum order
        int n = arr.size();
        int hi = (n-1)/2;
        int lo = 0;
        // initialize with the first element in the upper half
        // after this, the operations flip between arr[n] and 1/arr[n]
        List<Integer> res = new ArrayList<>();
        res.add(arr.get(hi));
        hi += 1;
        for (int i = 1; i < n; i++) {
            if (i % 2 != 0) {
                res.add(arr.get(hi));
                hi += 1;
            } else {
                res.add(arr.get(lo));
                lo += 1;
            }
        }
        return res;
    }
}
