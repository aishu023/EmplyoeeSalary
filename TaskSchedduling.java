
class Result {
    public static int getMinTime(List<Integer> task_memory, List<Integer> task_type, int max_memory) {
        int n = task_memory.size();
        
        // Group tasks by type
        Map<Integer, List<Integer>> tasksByType = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int type = task_type.get(i);
            List<Integer> typeTasks = tasksByType.getOrDefault(type, new ArrayList<>());
            typeTasks.add(task_memory.get(i));
            tasksByType.put(type, typeTasks);
        }
        
        int ans = 0;
        
        // Process tasks of each type separately
        for (List<Integer> val : tasksByType.values()) {
            // Sort task memory requirements
            val.sort(Comparator.naturalOrder());
            
            // Keep track of paired tasks
            int[] paired = new int[val.size()];
            Arrays.fill(paired, -1);
            int rightEnd = val.size() - 1;
            
            for (int i = 0; i < val.size(); i++) {
                if (paired[i] != -1) {
                    continue;
                }
                
                // Binary search for the largest task that can be paired with the current task
                int left = i + 1;
                int right = rightEnd;
                int pos = -1;
                
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (val.get(i) + val.get(mid) <= max_memory) {
                        pos = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                
                if (pos != -1) {
                    rightEnd = pos - 1;
                    paired[i] = paired[pos] = 1;
                } else {
                    paired[i] = 1;
                }
                
                ans += 1;
            }
        }
        
        return ans;
    }
}
