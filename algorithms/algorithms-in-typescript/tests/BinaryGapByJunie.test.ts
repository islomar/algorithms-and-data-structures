// https://app.codility.com/programmers/lessons/1-iterations/binary_gap/

/**
 * A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.
 * 1001 --> 2
 * 1000010001 --> 4
 * 10100 --> 1
 *
 * Write a function that, given a positive integer N, returns the length of its longest binary gap.
 * The function should return 0 if N doesn't contain a binary gap.
 * https://codility.com/media/train/Iterations.pdf
 */

import {describe, expect, it} from "vitest";

/**
 * Time and space complexity
 * - Let L be the length of the binary representation of the input number N (L = floor(log2 N) + 1 for N > 0).
 * - Converting N to its binary string takes O(L) time and O(L) space for the string.
 * - The while loop does a single pass over that string; the inner loop advances the same index, so overall it is O(L).
 * Therefore, time is O(L) which is O(log N) with respect to the numeric value N, not O(N) over an array.
 * Note: There is no input array here; we iterate over the bits of N’s binary form.
 */
function binaryGapByJunieFor(aNumber: number): number {

}

describe('BinaryGap', () => {
    it('return 0 if the number does not contain a binary gap', () => {
        expect(binaryGapByJunieFor(7)).toBe(0);
        expect(binaryGapByJunieFor(32)).toBe(0);
    });

    it('return 1 for 101', () => {
        expect(binaryGapByJunieFor(5)).toBe(1);
    });

    it('return 4 for 529', () => {
        expect(binaryGapByJunieFor(529)).toBe(4);
    });

    it('return 5 for 1041', () => {
        expect(binaryGapByJunieFor(1041)).toBe(5);
    });
});