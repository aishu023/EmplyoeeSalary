
import java.util.List;

class Result {
    public static List<Integer> performOperations(List<Integer> arr, List<List<Integer>> operations) {
        for (List<Integer> operation : operations) {
            int i = operation.get(0);
            int j = operation.get(1);
            while (i < j) {
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
                i += 1;
                j -= 1;
            }
        }
        return arr;
    }
}
