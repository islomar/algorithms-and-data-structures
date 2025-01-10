/* (C)2024 */
package kata;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GenerateNewRandomWordTest {

    @Test
    public void generate_new_random_word() {
        String[] input = {"apple", "banana", "cabbage"};
        Random randomNumbersGenerator = new Random(42);
        int numberOfRandomWordsToGenerate = 20;

        String[] generatedRandomWords = GenerateRandomWord.execute(input, randomNumbersGenerator, numberOfRandomWordsToGenerate);
        System.out.println(Arrays.toString(generatedRandomWords));

        assertThat(generatedRandomWords, arrayWithSize(numberOfRandomWordsToGenerate));
        assertThat(generatedRandomWords, arrayContainingInAnyOrder("cabanage", "bbbbbbbbbba", "cage", "anana", "cana", "canage", "anabbanappple", "cabbbapple", "banapple", "bage", "bbabbbananaple", "a", "bbanage", "cabbbba", "bbbbbanaba", "a", "bana", "cappple", "ca", "bbaple"));

    }

    @Test
    public void generate_new_random_word_by_chat_gpt() {
        String[] input = {"apple", "banana", "cabbage"};
        Random randomNumbersGenerator = new Random(42); // We hardcode a seed for the tests, so that we have a deterministic generation of numbers
        int numberOfRandomWordsToGenerate = 20;

        String[] generatedRandomWords = GenerateRandomWord.execute_by_chat_gpt(input, randomNumbersGenerator, numberOfRandomWordsToGenerate);
        System.out.println(Arrays.toString(generatedRandomWords));

        assertThat(generatedRandomWords, arrayWithSize(numberOfRandomWordsToGenerate));
        assertThat(generatedRandomWords, arrayContainingInAnyOrder("cabaple", "cabanananaple", "canabaple", "apppple", "abbage", "capple", "bbbabbaple", "abbanage", "cappppppple", "babage", "cabage", "banapple", "anapple", "cage", "bananananananabbanabb", "bbabbabanabanabababba", "bananaple", "age", "caple", "age"));

    }
}
