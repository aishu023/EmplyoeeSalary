import java.util.*;

class Result {
    public static List<Integer> cacheContents(List<List<Integer>> callLogs) {
        Map<Integer, Integer> priorityMap = new HashMap<>();
        Set<Integer> cacheItems = new HashSet<>();
        for (List<Integer> log : callLogs) {
            int timestamp = log.get(0);
            int itemId = log.get(1);
            int priority = priorityMap.getOrDefault(itemId, 0);

            if (timestamp > 0) {
                priority = Math.max(0, priority - timestamp);
            }

            int accessCount = Collections.frequency(callLogs, log);
            priority += 2 * accessCount;

            priorityMap.put(itemId, priority);

            if (priority > 5) {
                cacheItems.add(itemId);
            } else if (cacheItems.contains(itemId) && priority <= 3) {
                cacheItems.remove(itemId);
            }
        }
        List<Integer> result = new ArrayList<>(cacheItems);
        Collections.sort(result);
        if (result.isEmpty()) {
            result.add(-1);
        }
        return result;
    }
}
