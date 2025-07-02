package kata;

import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

/**
 * There's a staircase with N steps, and you can climb 1 or 2 steps at a time. Given N, write a function that returns the number of unique ways you can climb the staircase. The order of the steps matters.
 * <p>
 * For example, if N is 4, then there are 5 unique ways:
 * <p>
 * 1, 1, 1, 1
 * 2, 1, 1
 * 1, 2, 1
 * 1, 1, 2
 * 2, 2
 * What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from a set of positive integers X? For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time. Generalize your function to take in X.
 */
public class StaircaseStepsTest {

    @Test
    public void calculate_unique_ways_for_one_step_staircase() {
        List<List<Integer>> numberOfUniqueWays = calculateUniqueWaysToClimbStairwayWith(1);

        assertThat(numberOfUniqueWays, is(List.of(List.of(1))));
    }

    @Test
    public void calculate_unique_ways_for_two_step_staircase() {
        List<List<Integer>> numberOfUniqueWays = calculateUniqueWaysToClimbStairwayWith(2);

        assertThat(numberOfUniqueWays,
                is(List.of(
                                List.of(1, 1),
                                List.of(2)
                        )
                )
        );
    }

    @Test
    public void calculate_unique_ways_for_three_step_staircase() {
        List<List<Integer>> numberOfUniqueWays = calculateUniqueWaysToClimbStairwayWith(3);

        assertThat(numberOfUniqueWays,
                is(List.of(
                                List.of(1, 1, 1),
                                List.of(2, 1),
                                List.of(1, 2)
                        )
                )
        );
    }

    private List<List<Integer>> calculateUniqueWaysToClimbStairwayWith(int numberOfSteps) {
        List<List<Integer>> numberOfUniqueWays = new ArrayList<List<Integer>>() {};

        Integer[] allOnes = new Integer[numberOfSteps];
        Arrays.fill(allOnes, 1);

        numberOfUniqueWays.add(Arrays.asList(allOnes));
        for (int i = 0; i < allOnes.length; i++) {
            Integer[] newUniqueWay = new Integer[i+1];
            if (i  != (allOnes.length) - 1) {
                newUniqueWay[i] = 2;
                Arrays.fill(newUniqueWay, i + 1, allOnes.length - i + 1, 1);
                numberOfUniqueWays.add(Arrays.asList(newUniqueWay));
            }
        }

        return numberOfUniqueWays;
    }
}


