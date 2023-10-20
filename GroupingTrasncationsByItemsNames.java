class Result {

    /*
     * Complete the 'groupTransactions' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY transactions as parameter.
     */

   //Grouping Transaction By Item's Names

public static List<String> groupTransactions(List<String> transactions) {
        // Create a HashMap to store the count of each product
        Map<String, Integer> count = new HashMap<>();

        // Count the occurrences of each product
        for (String prod : transactions) {
            count.put(prod, count.getOrDefault(prod, 0) + 1);
        }

        // Perform a two-way sort, descending by count, increasing by product name
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(count.entrySet());
        Collections.sort(sortedList, (a, b) -> {
            int countComparison = b.getValue().compareTo(a.getValue());
            return countComparison != 0 ? countComparison : a.getKey().compareTo(b.getKey());
        });

        // Convert the sorted entries to the desired format and store in the result list
        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : sortedList) {
            ans.add(entry.getKey() + " " + entry.getValue());
        }

        return ans;
    }

}



