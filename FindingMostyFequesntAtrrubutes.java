import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

class Result {
    private static final String FILENAME = "census.csv";

    public static List<String> attributesSet(int numberOfAttributes, float supportThreshold) {
        Map<String, Integer> attributeCounts = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            int totalRecords = 0;
            while ((line = br.readLine()) != null) {
                totalRecords++;
                String[] attributes = line.split(",");
                Set<String> currentAttributes = new HashSet<>();
                for (String attribute : attributes) {
                    String[] parts = attribute.split("=");
                    if (parts.length == 2) {
                        currentAttributes.add(attribute);
                    }
                }
                for (String currentAttribute : currentAttributes) {
                    attributeCounts.put(currentAttribute, attributeCounts.getOrDefault(currentAttribute, 0) + 1);
                }
            }

            List<String> result = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : attributeCounts.entrySet()) {
                if ((float) entry.getValue() / totalRecords >= supportThreshold) {
                    String[] attributes = entry.getKey().split(",");
                    if (attributes.length == numberOfAttributes) {
                        result.add(entry.getKey());
                    }
                }
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
