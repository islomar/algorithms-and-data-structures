/* (C)2024 */
package kata;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasLength;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

public class FooTest {

    @Test
    public void please_give_me_a_good_name() {
        Trie trie = new Trie();
        trie.insert("CAR");

        boolean isWordContained = trie.isWordContained("CAR");

        assertThat(isWordContained, is(Boolean.TRUE));
    }

    @Test
    public void please_give_me_a_good_name0() {
        Trie trie = new Trie();
        trie.insert("CAR");

        boolean isWordContained = trie.isWordContained("CA");

        assertThat(isWordContained, is(Boolean.FALSE));
    }

    @Test
    public void please_give_me_a_good_name2() {
        Trie trie = new Trie();
        trie.insert("CAR");

        boolean isWordContained = trie.isWordContained("DO");

        assertThat(isWordContained, is(Boolean.FALSE));
    }

    @Test
    public void please_give_me_a_good_name3() {
        Trie trie = new Trie();
        trie.insert("CAR");
        trie.insert("CA");

        boolean isWordContained = trie.isWordContained("CA");

        assertThat(isWordContained, is(Boolean.TRUE));
    }

}
