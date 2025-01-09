/* (C)2024 */
package kata;

import java.util.*;

public class Foo {
    public int add(int firstAddend, int secondAddend) {
        return firstAddend + secondAddend;
    }

    public String generateRandomWord(int wordLength) {
        String randomWord = "";
        Random rnd = new Random();
        for (int i = 0; i < wordLength; i++) {
            randomWord += (char) ('a' + rnd.nextInt(26));
        }
        return randomWord;
    }

    /**
     * Filters out excessive requests based on the per-second limit.
     *
     * @param requests the list of requests in the format "requestId IP timestamp"
     * @param limit    the maximum number of allowed requests per second per IP
     * @return a list of valid requests that conform to the rate limit
     */
    public static List<String> filterRequests(List<String> requests, int limit) {
        // Map to track IP and their request timestamps
        Map<String, List<Long>> ipRequestTimestamps = new HashMap<>();
        List<String> validRequests = new ArrayList<>();

        for (String request : requests) {
            String[] parts = request.split(" ");
            if (parts.length != 3) continue; // Skip malformed entries

            String requestId = parts[0];
            String ip = parts[1];
            long timestamp = Long.parseLong(parts[2]);

            // Initialize the list for the IP if not already present
            ipRequestTimestamps.putIfAbsent(ip, new ArrayList<>());
            List<Long> timestamps = ipRequestTimestamps.get(ip);

            // Filter timestamps to keep only those within the last second
            timestamps.removeIf(ts -> ts < timestamp - 1000);

            // Check if the IP is within the limit
            if (timestamps.size() < limit) {
                validRequests.add(request);
                timestamps.add(timestamp);
            }
        }

        return validRequests;
    }


}
