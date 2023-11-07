
class Result {
    public static List<Integer> findSubsequence(List<Integer> arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> sequence = new ArrayList<>();
        for (Integer num : new TreeSet<>(arr)) {
            sequence.addAll(Collections.nCopies(countMap.get(num) - 1, num));
        }
        
        int i = 0;
        for (Integer num : arr) {
            if (i < sequence.size() && sequence.get(i).equals(num)) {
                i++;
            }
        }
        
        return i == sequence.size() ? sequence : Collections.singletonList(-1);
    }
}
