/**
 * https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/
 */
import {describe, expect, it} from "vitest";


function findMissingInteger(numbers: number[]): number {
    const positiveNumbersSorted = [0].concat(numbers.filter(number => number > 0).sort());
    if (positiveNumbersSorted.length === 0) return 1;
    for (let index = 0; index < positiveNumbersSorted.length - 1; index++) {
        if (positiveNumbersSorted[index + 1] - positiveNumbersSorted[index] > 1) {
            return positiveNumbersSorted[index] + 1; //early exit optimization
        }
    }
    return positiveNumbersSorted[positiveNumbersSorted.length - 1] + 1;
}

describe("MissingInteger", () => {
    it('should find the smallest positive integer does not occur', () => {
        expect(findMissingInteger([1, 3, 6, 4, 1, 2])).toBe(5);
    });

    it('should find the smallest positive integer does not occur', () => {
        expect(findMissingInteger([1, 2, 3])).toBe(4);
    });

    it('should find the smallest positive integer does not occur', () => {
        expect(findMissingInteger([-1, -3])).toBe(1);
    });

    it('should find the smallest positive integer does not occur', () => {
        expect(findMissingInteger([2])).toBe(1);
    });
})