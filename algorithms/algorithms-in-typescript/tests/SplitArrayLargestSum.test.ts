/**
 * https://leetcode.com/problems/split-array-largest-sum/description/
 */
import {describe, expect, test} from "vitest";

function splitArrayLargestSum(nums: number[], numberOfSubarrays: number): number {
    const prefixSums: number[] = [nums[0]];
    for (let i = 0; i < nums.length - 1; i++) {
        prefixSums[i + 1] = prefixSums[i] + nums[i + 1];
    }

    const differencesBetweenPrefixSums: number[] = computeAdjacentDifferences(prefixSums);
    const maxDifference = Math.max(...differencesBetweenPrefixSums);
    const indexOfMaxDifference = differencesBetweenPrefixSums.indexOf(maxDifference);

    const subarray1 = nums.slice(0, indexOfMaxDifference + 1);
    const subarray2 = nums.slice(indexOfMaxDifference + 1);

    const subarray1Sum = subarray1.reduce((a, b) => a + b, 0);
    const subarray2Sum = subarray2.reduce((a, b) => a + b, 0);

    return Math.max(subarray1Sum, subarray2Sum);
}

function computeAdjacentDifferences(arr: number[]): number[] {
    return arr.slice(1).reduce<number[]>((acc, curr, i) => {
        acc.push(curr - arr[i]);
        return acc;
    }, []);
}



describe('Find the Grid of Region Average', () => {
    const cases = [
        // {nums: [7,2,5,10,8], numberOfSubarrays: 2, expected: 18},
        {nums: [1,2,3,4,5], numberOfSubarrays: 2, expected: 9},
        // {nums: [5, 1, 2, 7, 3, 4], numberOfSubarrays: 3, expected: 8},
    ];

    describe('splitArrayLargestSum should', () => {
        test.each(cases)('return $expected for array $nums with numberOfSubarrays $numberOfSubarrays', ({nums, numberOfSubarrays, expected}) => {
            expect(splitArrayLargestSum(nums, numberOfSubarrays)).toEqual(expected);
        });
    })
});