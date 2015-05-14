package com.islomar.cracking;

/**
 *
 */
public class MyStringUtils {

  private static final int MAX_NUMBER_OF_CHARACTERS_IN_ASCII = 128;

  /**
   * It takes O(n^2) time and O(1) space. No additional data structure is used.
   *
   * @return true if the String has only unique characters, false otherwise.
   */
  public static boolean hasAllUniqueCharacters(String strinWithUniqueCharacters) {

    if (strinWithUniqueCharacters == null ||
        strinWithUniqueCharacters.trim().isEmpty() ||
        strinWithUniqueCharacters.length() > MAX_NUMBER_OF_CHARACTERS_IN_ASCII) {
      return true;
    }

    int totalNumberOfChars = strinWithUniqueCharacters.length();
    for (int i = 0; i < totalNumberOfChars; i++) {
      char currentChar = strinWithUniqueCharacters.charAt(i);
      for (int j = i + 1; j < totalNumberOfChars; j++) {
        if (currentChar == strinWithUniqueCharacters.charAt(j)) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * It takes O(n) time and O(1/8) space. Using a bit vector, we can reduce our space usage by a factor of eight.
   *
   * @return true if the String has only unique characters, false otherwise.
   */
  public static boolean isUniqueChars(String strinWithUniqueCharacters) {
    int checker = 0;
    for (int i = 0; i < strinWithUniqueCharacters.length(); i++) {
      int val = strinWithUniqueCharacters.charAt(i) - 'a';
      if ((checker & (1 << val)) > 0) {
        return false;
      }
      checker |= (1 << val);
    }
    return true;
  }

}
