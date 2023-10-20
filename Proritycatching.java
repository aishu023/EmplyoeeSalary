import java.util.*;
//2 testcases
 class Result {
    public static List<Integer> cacheContents(List<List<Integer>> callLogs) {
        Map<Integer, Integer> priorities = new HashMap<>();
        Set<Integer> cache = new HashSet<>();

        for (List<Integer> log : callLogs) {
            int timestamp = log.get(0);
            int item = log.get(1);

            for (int i = 0; i < timestamp; i++) {
                System.out.println("Time: " + i);
                for (Map.Entry<Integer, Integer> entry : new HashMap<>(priorities).entrySet()) {
                    int itemId = entry.getKey();
                    int priority = entry.getValue();
                    if (cache.contains(itemId)) {
                        if (priority <= 3) {
                            cache.remove(itemId);
                            System.out.println("Removing item " + itemId + " from cache at time " + i);
                        } else {
                            priorities.put(itemId, Math.max(3, priority - 1));
                            System.out.println("Decreasing priority of item " + itemId + " to " + Math.max(3, priority - 1) + " at time " + i);
                        }
                    } else {
                        priorities.put(itemId, Math.max(0, priority - 1));
                        if (priority > 5) {
                            cache.add(itemId);
                            System.out.println("Adding item " + itemId + " to cache at time " + i);
                        }
                    }
                }
            }

            if (!priorities.containsKey(item)) {
                priorities.put(item, 0);
            }

            int prevCount = priorities.getOrDefault(item, 0);
            priorities.put(item, Math.max(0, prevCount + 2 * timestamp));
            System.out.println("Updated priority of item " + item + " to " + Math.max(0, prevCount + 2 * timestamp) + " at time " + timestamp);
        }

        List<Integer> result = new ArrayList<>(cache);
        result.sort(Comparator.naturalOrder());
        if (result.isEmpty()) {
            System.out.println("Returning [-1]");
            return Collections.singletonList(-1);
        } else {
            System.out.println("Returning " + result.toString());
            return result;
        }
    }
}
