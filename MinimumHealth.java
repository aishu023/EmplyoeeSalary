import java.util.*;

import java.util.List;
import java.util.PriorityQueue;

class Result {
    public static long getMinimumHealth(List<Integer> initial_players, List<Integer> new_players, int rank) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int x : initial_players) {
            heap.add(x);
        }
        while (heap.size() > rank) {
            heap.poll();
        }
        int temp = heap.poll();
        long ans = temp;
        heap.add(temp);
        for (int x : new_players) {
            heap.add(x);
            heap.poll();
            temp = heap.poll();
            ans += temp;
            heap.add(temp);
        }
        return ans;
    }
}
