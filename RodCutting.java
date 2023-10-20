import java.util.ArrayList;
import java.util.List;

 class Result {

    public static List<Integer> rodOffcut(List<Integer> lengths) {
        List<Integer> result = new ArrayList<>();
        result.add(lengths.size());

        while (!lengths.isEmpty()) {
            int min = Integer.MAX_VALUE;
            for (int length : lengths) {
                min = Math.min(min, length);
            }

            List<Integer> offcuts = new ArrayList<>();
            for (int i = 0; i < lengths.size(); i++) {
                if (lengths.get(i) == min) {
                    lengths.remove(i);
                    i--;
                } else {
                    offcuts.add(lengths.get(i) - min);
                }
            }
            lengths.clear();
            lengths.addAll(offcuts);
            if (!lengths.isEmpty()) {
                result.add(lengths.size());
            }
        }

        return result;
    }
}
