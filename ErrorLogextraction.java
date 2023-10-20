import java.util.*;

class Result {

    public static List<List<String>> extractErrorLogs(List<List<String>> logs) {
        int n = logs.size();
        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] date = logs.get(i).get(0).split("-");
            String[] time = logs.get(i).get(1).split(":");
            logs.get(i).set(0, date[2] + "-" + date[1] + "-" + date[0]);

            if (logs.get(i).get(2).equals("CRITICAL") || logs.get(i).get(2).equals("ERROR")) {
                List<String> logEntry = new ArrayList<>();
                logEntry.add(logs.get(i).get(0));
                logEntry.add(logs.get(i).get(1));
                logEntry.add(logs.get(i).get(2));
                logEntry.add(logs.get(i).get(3));
                ans.add(logEntry);
            }
        }

        Collections.sort(ans, (a, b) -> {
            String[] dateA = a.get(0).split("-");
            String[] dateB = b.get(0).split("-");
            for (int i = 0; i < 3; i++) {
                if (!dateA[i].equals(dateB[i])) {
                    return dateA[i].compareTo(dateB[i]);
                }
            }
            return a.get(1).compareTo(b.get(1));
        });

        for (int i = 0; i < ans.size(); i++) {
            String[] date = ans.get(i).get(0).split("-");
            ans.get(i).set(0, date[2] + "-" + date[1] + "-" + date[0]);
        }

        return ans;
    }
}

