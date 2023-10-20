import java.util.*;
//3/13
class Result {

    public static List<Integer> predictAnswer(List<Integer> stockData, List<Integer> queries) {
        List<Integer> results = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < stockData.size(); i++) {
            map.put(stockData.get(i), i);
        }

        for (int query : queries) {
            int idx = query - 1;
            Map.Entry<Integer, Integer> entry = map.lowerEntry(stockData.get(idx));
            if (entry == null) {
                results.add(-1);
            } else {
                results.add(entry.getValue() + 1);
            }
        }
        return results;
    }
}
