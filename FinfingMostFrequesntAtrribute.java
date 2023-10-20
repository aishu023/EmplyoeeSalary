package com.cg.havherrank;

public static List<String> attributesSet(int numberOfAttributes, float supportThreshold) {
    Map<String, Integer> attributeCounts = new HashMap<>();
    List<String> attributeSet = new ArrayList<>();
    List<String> result = new ArrayList<>();
    int totalRecords = 0;

    try (BufferedReader br = new BufferedReader(new FileReader("census.csv"))) {
        String line;
        while ((line = br.readLine()) != null) {
            totalRecords++;
            String[] attributes = line.split(",");
            Set<String> uniqueAttributes = new HashSet<>();
            
            for (String attr : attributes) {
                String[] parts = attr.split("=");
                if (parts.length == 2) {
                    String attribute = parts[0];
                    String value = parts[1];
                    uniqueAttributes.add(attribute + "=" + value);
                }
            }

            for (String uniqueAttr : uniqueAttributes) {
                attributeCounts.put(uniqueAttr, attributeCounts.getOrDefault(uniqueAttr, 0) + 1);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
        return result;
    }

    for (Map.Entry<String, Integer> entry : attributeCounts.entrySet()) {
        float support = (float) entry.getValue() / totalRecords;
        if (support >= supportThreshold) {
            attributeSet.add(entry.getKey());
        }
    }

    findAttributeSets(attributeSet, 0, numberOfAttributes, "", result);
    return result;
}

private static void findAttributeSets(List<String> attributeSet, int index, int numberOfAttributes, String currentSet, List<String> result) {
    if (numberOfAttributes == 0) {
        result.add(currentSet);
        return;
    }
    
    for (int i = index; i < attributeSet.size(); i++) {
        if (!currentSet.isEmpty()) {
            findAttributeSets(attributeSet, i + 1, numberOfAttributes - 1, currentSet + "," + attributeSet.get(i), result);
        } else {
            findAttributeSets(attributeSet, i + 1, numberOfAttributes - 1, attributeSet.get(i), result);
        }
    }
}
}