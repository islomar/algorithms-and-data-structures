/**
 * LeetCode 3
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * https://www.youtube.com/watch?v=wiGpQwVHdE0&list=PLot-Xpze53lfOdF3KwpMSFEyfE77zIwiP&index=4
 * https://neetcode.io/problems/longest-substring-without-duplicates
 *
 * Given a string s, find the length of the longest substring without duplicate characters.
 */
import {describe, expect, test} from "vitest";

/**
 * O(n²), brute force
 * Sliding window
 */
function lengthOfLongestSubstringUsingAutocomplete(input: string): number {
    let maxLengthOfLongestSubstring = 1;
    for (let leftPointer = 0; leftPointer < input.length; leftPointer++) {
        let currentCharacter = input[leftPointer];
        let currentLengthOfCurrentSubstring = 1;
        let rightPointer = leftPointer + 1;
        while (rightPointer < input.length && input[rightPointer] !== currentCharacter) {
            currentLengthOfCurrentSubstring++;
            rightPointer++;
        }
        maxLengthOfLongestSubstring = Math.max(maxLengthOfLongestSubstring, currentLengthOfCurrentSubstring);
    }
    return maxLengthOfLongestSubstring;
}

/**
 * O(n²)
 * Sliding window
 * The funcion "includes()" on an array is O(k) where k is the current window size (up to n)
 * currentLongestSubstring.shift(), which is O(k) because it reindexes the array.
 */
function lengthOfLongestSubstring(input: string): number {
    let currentLongestSubstring: string[] = [];
    let lengthOfLongestSubstring: number = currentLongestSubstring.length;
    for (let index = 0; index < input.length; index++) {
        while (!currentLongestSubstring.includes(input[index]) && index < input.length) {
            currentLongestSubstring.push(input[index]);
            index++;
            lengthOfLongestSubstring = Math.max(lengthOfLongestSubstring, currentLongestSubstring.length);
        }
        currentLongestSubstring.shift();
    }
    return lengthOfLongestSubstring;
}

/**
 * O(n)
 * - The algorithm uses a sliding window with two pointers (left and right) that each move forward monotonically across the string at most n times.
 * - Each character is added to the Set at most once and removed from the Set at most once, so total Set operations are O(n).
 * - Set operations (has/add/delete) are O(1) on average.
 * - Although there are nested while loops, the total number of iterations across the entire run is linear because the pointers never move backward.
 */
function lengthOfLongestSubstringWithHashSet(input: string): number {
    let uniqueLettersInCurrentSubstring: Set<string> = new Set();
    let leftPointer: number = 0;
    let rightPointer: number = 0;
    let lengthOfLongestSubstring: number = uniqueLettersInCurrentSubstring.size;
    while (rightPointer < input.length) {
        while (!uniqueLettersInCurrentSubstring.has(input[rightPointer])) {
            uniqueLettersInCurrentSubstring.add(input[rightPointer]);
            rightPointer++;
            lengthOfLongestSubstring = Math.max(lengthOfLongestSubstring, uniqueLettersInCurrentSubstring.size);
        }
        while (uniqueLettersInCurrentSubstring.has(input[rightPointer])) {
            uniqueLettersInCurrentSubstring.delete(input[leftPointer]);
            leftPointer++;
        }
        uniqueLettersInCurrentSubstring.add(input[rightPointer]);
        rightPointer++;
    }
    return lengthOfLongestSubstring;
}

describe('Longest Substring Without Repeating Characters', () => {
    const cases = [
        {input: "zxyzxyz", expected: 3},
        {input: "xxxx", expected: 1},
        {input: "abcabcbb", expected: 3},
        {input: "pwwkew", expected: 3},
    ];

    describe.skip('lengthOfLongestSubstringUsingAutocomplete should', () => {
        test.each(cases)('return $expected for $input', ({input, expected}) => {
            expect(lengthOfLongestSubstringUsingAutocomplete(input)).toBe(expected);
        });
    })

    describe('lengthOfLongestSubstring should', () => {
        test.each(cases)('return $expected for $input', ({input, expected}) => {
            expect(lengthOfLongestSubstring(input)).toBe(expected);
        });
    })

    describe('lengthOfLongestSubstringWithHashSet should', () => {
        test.each(cases)('return $expected for $input', ({input, expected}) => {
            expect(lengthOfLongestSubstringWithHashSet(input)).toBe(expected);
        });
    })

});