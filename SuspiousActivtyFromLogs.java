class Result {

    /*
     * Complete the 'processLogs' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY logs
     *  2. INTEGER threshold
     */

    public static List<String> processLogs(List<String> logs, int threshold) {
        Map<String, Integer> map = new HashMap<>();

        for (String log : logs) {
            String[] arr = log.split("\\s");
            String sender = arr[0];
            String recipient = arr[1];

            map.put(sender, map.getOrDefault(sender, 0) + 1);
            if (!sender.equals(recipient)) {
                map.put(recipient, map.getOrDefault(recipient, 0) + 1);
            }
        }

        List<String> suspiciousUsers = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= threshold) {
                suspiciousUsers.add(entry.getKey());
            }
        }

        suspiciousUsers.sort(Comparator.comparingLong(Long::parseLong));
        return suspiciousUsers;
    }
}

