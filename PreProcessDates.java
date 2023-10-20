package com.cg.havherrank;

public static List<String> preprocessDate(List<String> dates) {
    List<String> ans = new ArrayList<>();

    // Initialize a map for months
    Map<String, Integer> monthDict = new HashMap<>();
    monthDict.put("Jan", 1);
    monthDict.put("Feb", 2);
    monthDict.put("Mar", 3);
    monthDict.put("Apr", 4);
    monthDict.put("May", 5);
    monthDict.put("Jun", 6);
    monthDict.put("Jul", 7);
    monthDict.put("Aug", 8);
    monthDict.put("Sep", 9);
    monthDict.put("Oct", 10);
    monthDict.put("Nov", 11);
    monthDict.put("Dec", 12);

    // Compile a regex pattern to grab the first 1 or 2 digits for day
    Pattern pat = Pattern.compile("[0-9]{1,2}");

    for (String dt : dates) {
        String[] parts = dt.split(" ");
        String d = parts[0];
        String m = parts[1];
        String yr = parts[2];

        // Get the day as an integer
        Matcher matcher = pat.matcher(d);
        matcher.find();
        int day = Integer.parseInt(matcher.group(0));

        // Get the month as an integer
        int mo = monthDict.get(m);

        // Year is OK already

        // Left-fill with 0 to 2 places for day and month
        ans.add(String.format("%s-%02d-%02d", yr, mo, day));
    }
    
    return ans;
}



