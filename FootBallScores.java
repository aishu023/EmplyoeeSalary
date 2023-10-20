import java.util.*;

class Result {
    public static List<Integer> counts(List<Integer> teamA, List<Integer> teamB) {
        List<Integer> ans = new ArrayList<>();
        teamA.sort(Comparator.naturalOrder());
        for (int score : teamB) {
            int lo = 0, hi = teamA.size() - 1;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (teamA.get(mid) > score) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            ans.add(lo);
        }
        return ans;
    }
}
