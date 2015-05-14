package com.islomar.cracking;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


@Test
public class MyStringUtilsTest {

  /**
   * Implement an algorithm to determine if a string has all unique characters.
   * You can NOT use additional data structures.
   */
  public void assert_that_a_string_has_all_unique_characters() {

    String strinWithUniqueCharacters = "abc";

    assertTrue(MyStringUtils.hasAllUniqueCharacters(strinWithUniqueCharacters));
  }

  public void assert_that_string_aabc_has_not_all_unique_characters() {

    String strinWithUniqueCharacters = "abca";

    assertFalse(MyStringUtils.hasAllUniqueCharacters(strinWithUniqueCharacters));
  }

  /**
   * Implement an algorithm to determine if a string has all unique characters.
   * You can use additional data structures.
   */
  public void assert_that_a_string_has_all_unique_characters_with_optimized_algorithm() {

    String strinWithUniqueCharacters = "abc";

    assertTrue(MyStringUtils.isUniqueChars(strinWithUniqueCharacters));
  }

  public void assert_that_string_aabc_has_not_all_unique_characters_with_optimized_algorithm() {

    String strinWithUniqueCharacters = "abca";

    assertFalse(MyStringUtils.isUniqueChars(strinWithUniqueCharacters));
  }

}
