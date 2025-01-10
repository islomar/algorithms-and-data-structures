/* (C)2024 */
package kata;

import org.junit.jupiter.api.Test;

public class GenerateNewRandomWordTest {

  @Test
  public void generate_new_random_word() {
    String[] input = {"apple", "banana", "cabbage"};
      for (int i = 0; i < 20; i++) {
          System.out.println(GenerateRandomWord.execute(input));
      }
  }
}
