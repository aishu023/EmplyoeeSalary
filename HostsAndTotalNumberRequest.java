public class Solution {
    private static final Scanner scan = new Scanner(System.in);
  public static void main(String args[]) throws Exception {
        // read the string filename
        String filename;
        filename = scan.nextLine();
        Map<String, Integer> hostnameCountMap = analyzeLogFile(filename);

        // Generate the output filename based on the input filename
        String outputFileName = "records_" + filename;

        // Write the output to the file
        writeOutputToFile(hostnameCountMap, outputFileName);

        System.out.println("Output has been written to " + outputFileName);
    }

    private static Map<String, Integer> analyzeLogFile(String filename) throws IOException {
        Map<String, Integer> hostnameCountMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Use regex to extract the hostname from the log line
                Pattern pattern = Pattern.compile("^([\\S]+)\\s+");
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    String hostname = matcher.group(1);
                    hostnameCountMap.put(hostname, hostnameCountMap.getOrDefault(hostname, 0) + 1);
                }
            }
        }

        return hostnameCountMap;
    }

    private static void writeOutputToFile(Map<String, Integer> hostnameCountMap, String outputFileName) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName))) {
            for (Map.Entry<String, Integer> entry : hostnameCountMap.entrySet()) {
                String hostname = entry.getKey();
                int count = entry.getValue();
                bw.write(hostname + " " + count);
                bw.newLine();
            }
        }
    }
}