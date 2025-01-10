/* (C)2024 */
package kata;

import java.util.Random;

/**
 * Input: array of English words
 * Output: new word randomly with a similar spelling
 *
 * Input = ["apple", "banana", "cabbage"]
 * For example abage, it is valid because it starts with a, which is the starting character of apple. The second character b is picked because b follows a in cabbage. The third character is a again because a follows b in banana or cabbage, so forth and so on. It ends with e, because it is the ending character of apple or cabbage and it also follows g in cabbage.
 *
 * Output = bage
 * Output = capple
 * Output = a
 *
 * bana
 */
public class GenerateRandomWord {
  public static String execute(String[] inputWords) {
      Random random = new Random();

      StringBuffer output = new StringBuffer();
      int wordIndex;
      String randomWord;

      wordIndex = random.nextInt(inputWords.length);
      randomWord = inputWords[wordIndex];
      char letter = randomWord.charAt(0);
      output.append(letter);

      while (true) {
          wordIndex = random.nextInt(inputWords.length);
          randomWord = inputWords[wordIndex];

          int letterIndex = inputWords[wordIndex].indexOf(letter, random.nextInt(randomWord.length())) ; // FIX: this is not random inside the word
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
}
