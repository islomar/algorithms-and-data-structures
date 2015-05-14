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
   * This solution assumes that the string only uses the lower case letter a through z.
   *
   * Probably int may be a little bit faster, because operations with bits are very low level and can be executed as-is by CPU.
   *
   * @return true if the String has only unique characters, false otherwise.
   */
  public static boolean isUniqueChars(String strinWithUniqueCharacters) {
    int checker = 0;
    for (int i = 0; i < strinWithUniqueCharacters.length(); i++) {
      // if the char is 'b', val=1
      int val = strinWithUniqueCharacters.charAt(i) - 'a';
      /**
       * First, it moves the 1 'val' positions to the left. E.g. 1 << 2 = 100
       * Then, it makes bitwise AND to see if that position was already marked.
       */
      if ((checker & (1 << val)) > 0) {
        return false;
      }
      checker |= (1 << val);  // inclusive OR: set flag at index val to true
    }
    return true;
  }

}
