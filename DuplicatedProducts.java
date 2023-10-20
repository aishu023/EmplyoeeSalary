
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Result {
    public static int numDuplicates(List<String> name, List<Integer> price, List<Integer> weight) {
        Set<String> s = new HashSet<>();
        for (int i = 0; i < name.size(); i++) {
            s.add(name.get(i) + " " + price.get(i) + " " + weight.get(i));
        }
        return name.size() - s.size();
    }
}
