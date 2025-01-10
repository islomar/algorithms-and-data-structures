/* (C)2024 */
package kata;

import java.util.*;

/**
 * Input: array of English words
 * Output: new word randomly with a similar spelling
 * For example abage, it is valid because it starts with a, which is the starting character of apple. The second character b is picked because b follows a in cabbage. The third character is a again because a follows b in banana or cabbage, so forth and so on. It ends with e, because it is the ending character of apple or cabbage and it also follows g in cabbage.
 * <p>
 * Examples:
 * Input = ["apple", "banana", "cabbage"]
 * <p>
 * Acceptable outputs:
 * Output = bage
 * Output = capple
 * Output = a
 * <p>
 */
public class GenerateRandomWord {
    public static String[] execute(String[] inputWords, Random randomNumbersGenerator, int numberOfRandomWordsToGenerate) {
        String[] generatedRandomWords = new String[numberOfRandomWordsToGenerate];
        for (int i = 0; i < numberOfRandomWordsToGenerate; i++) {

            generatedRandomWords[i] = generateRandomWord(inputWords, randomNumbersGenerator);
        }
        return generatedRandomWords;
    }

    private static String generateRandomWord(String[] inputWords, Random randomNumbersGenerator) {
        StringBuilder output = new StringBuilder();
        int wordIndex;
        String randomWord;

        wordIndex = randomNumbersGenerator.nextInt(inputWords.length);
        randomWord = inputWords[wordIndex];
        char letter = randomWord.charAt(0);
        output.append(letter);

        while (true) {
            wordIndex = randomNumbersGenerator.nextInt(inputWords.length);
            randomWord = inputWords[wordIndex];

            int letterIndex = inputWords[wordIndex].indexOf(letter, randomNumbersGenerator.nextInt(randomWord.length())); // FIX: this is not random inside the word
            if (letterIndex == -1) {
                continue;
            }

            if (letterIndex == randomWord.length() - 1) {
                return output.toString();
            }

            letter = inputWords[wordIndex].charAt(letterIndex + 1);
            output.append(letter);
        }
    }

    private static final int MAX_LENGTH = 20; // Arbitrary limit to prevent runaway words


    public static String[] execute_by_chat_gpt(String[] inputWords, Random randomNumbersGenerator, int numberOfRandomWordsToGenerate) {
        String[] generatedRandomWords = new String[numberOfRandomWordsToGenerate];
        for (int i = 0; i < numberOfRandomWordsToGenerate; i++) {

            generatedRandomWords[i] = generateRandomWordByChatGPT(inputWords, randomNumbersGenerator);
        }
        return generatedRandomWords;
    }

    /**
     * Generates one random "similar" word given an array of words.
     * @param words Array of English words, e.g. ["apple", "banana", "cabbage"]
     * @return A randomly generated word that follows the adjacency rules.
     *
     * Given ["apple", "banana", "cabbage"], our adjacency might look like:
     * a -> [p, n, b, g] (from “apple”, “banana”, “cabbage”)
     * p -> [p, l] (from “apple”)
     * l -> [e] (from “apple”)
     * b -> [a, b] (from “banana”, “cabbage”)
     * n -> [a] (from “banana”)
     * g -> [e] (from “cabbage”)
     * c -> [a] (from “cabbage”)
     * ... etc.
     * startChars might be {a, b, c}, and endChars might be {e, a} (from “apple” → e, “banana” → a, “cabbage” → e).
     * A random path could be: c -> a -> b -> a -> g -> e, resulting in cabage. Or you might start with a, get b, pick a, then end if you reach a which is also in endChars, giving just “aba.” The exact result depends on the random choices each time.
     */
    public static String generateRandomWordByChatGPT(String[] words, Random randomNumbersGenerator) {
        // 1. Build adjacency map and sets of start/end characters
        Map<Character, List<Character>> adjacencyMap = new HashMap<>();
        Set<Character> startChars = new HashSet<>();
        Set<Character> endChars = new HashSet<>();

        for (String word : words) {
            if (word == null || word.isEmpty()) {
                continue;
            }
            char firstChar = word.charAt(0);
            char lastChar = word.charAt(word.length() - 1);

            startChars.add(firstChar);
            endChars.add(lastChar);

            // Build adjacency from each pair of consecutive characters
            for (int i = 0; i < word.length() - 1; i++) {
                char current = word.charAt(i);
                char next = word.charAt(i + 1);

                adjacencyMap.putIfAbsent(current, new ArrayList<>());
                adjacencyMap.get(current).add(next);
            }
        }

        // If we have no startChars or adjacency, return empty or handle accordingly
        if (startChars.isEmpty() || adjacencyMap.isEmpty()) {
            return "";
        }

        // 2. Randomly build a new word
        Random random = randomNumbersGenerator;

        // Pick a random starting character
        List<Character> startList = new ArrayList<>(startChars);
        char currentChar = startList.get(random.nextInt(startList.size()));

        StringBuilder result = new StringBuilder();
        result.append(currentChar);

        for (int i = 0; i < MAX_LENGTH; i++) {
            // Check if the current char has any adjacency
            List<Character> possibleNext = adjacencyMap.get(currentChar);
            if (possibleNext == null || possibleNext.isEmpty()) {
                // Can't continue, so break early
                break;
            }

            // Randomly pick the next character
            char nextChar = possibleNext.get(random.nextInt(possibleNext.size()));
            result.append(nextChar);
            currentChar = nextChar;

            // With some probability or condition, stop if it's also a valid ending char
            // For simplicity, let's stop immediately if it's an end char
            // (But you can tweak this logic)
//            if (endChars.contains(currentChar)) {
//                break;
//            }
        }

        return result.toString();
    }
}
