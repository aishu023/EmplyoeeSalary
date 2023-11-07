
public static List<Integer> subsetA(List<Integer> arr) {
    // sort descending
    Collections.sort(arr, Collections.reverseOrder());

    // sum the entire array
    int S = arr.stream().mapToInt(Integer::intValue).sum();

    List<Integer> ans = new ArrayList<>();
    int currSum = 0;

    // add elements to A and remove from B until A > B
    for (int i = 0; i < arr.size(); i++) {
        currSum = currSum + arr.get(i);
        if (currSum > S - currSum) {
            // sort ascending for return
            List<Integer> result = arr.subList(0, i + 1);
            result.sort(Comparator.naturalOrder());
            return result;
        }
    }
    return new ArrayList<>(); // return an empty list if no subset found
}