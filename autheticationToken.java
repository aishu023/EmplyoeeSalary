public static int numberOfTokens(int expiryLimit, List<List<Integer>> commands) {
        int activeTokens = 0;
        TreeMap<Integer, Integer> tokenExpiry = new TreeMap<>();
int maxTime = -1;
        for (List<Integer> command : commands) {
            int type = command.get(0);
            int tokenId = command.get(1);
            int time = command.get(2);

            if (type == 0) {
            maxTime = Math.max(maxTime, time);
                tokenExpiry.put(tokenId, time + expiryLimit);
            } else if (type == 1) {
                maxTime = Math.max(maxTime, time);
                Integer expiryTime = tokenExpiry.get(tokenId);
                if (expiryTime != null && expiryTime >= time) {
                    tokenExpiry.put(tokenId, time + expiryLimit);
                }
            }
        }
        for (int expiryTime : tokenExpiry.values()) {
            if (expiryTime > maxTime) {
                activeTokens++;
            }
        }

        return activeTokens;
    }