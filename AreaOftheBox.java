import java.util.*;

class Result {

    public static List<Long> numberOfWays(List<List<Integer>> queries) {
        List<Long> result = new ArrayList<>();
        for (List<Integer> query : queries) {
            int rows = query.get(0);
            int columns = query.get(1);
            long ways = 0;
            for (int a = 1; a <= Math.min(rows, columns); a++) {
                ways += (rows - a + 1) * (columns - a + 1);
            }
            result.add(ways);
        }
        return result;
    }
}
