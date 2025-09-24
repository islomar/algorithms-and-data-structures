/**
 * 3Sum - Leetcode 15 - Python
 * https://leetcode.com/problems/3sum/
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Brute force solution: O(n^3)
 */
import {describe, expect, test} from "vitest";

function threeSumByBruteForce(nums: number[]): number[][] {
    let solutions: number[][] = [];
    let currentSolution: number[] = [];
    for (let i = 0; i < nums.length - 1; i++) {
        for (let j = i + 1; j < nums.length - 1; j++) {
            for (let k = j + 1; k < nums.length; k++) {
                if (nums[i] + nums[j] + nums[k] === 0) {
                    currentSolution = [nums[i], nums[j], nums[k]].sort();
                    if (!includesArray(solutions, currentSolution)) {
                        solutions.push(currentSolution);
                    }
                }
            }
        }
    }
    return solutions;
}

function includesArray<T>(matrix: T[][], target: T[]): boolean {
    return matrix.some(a =>
        a.length === target.length &&
        a.every((v, i) => Object.is(v, target[i]))
    );
}


function threeSumOptimized(nums: number[]): number[][] {
    const sortedNums = nums.sort();
    let solutions: number[][] = [];
    for (let left = 0; left < sortedNums.length - 2; left++) {
        // we don't want to repeat the same number twice
        if (left > 0 && sortedNums[left] === sortedNums[left - 1]) continue;
        let mid = left + 1;
        let right = sortedNums.length - 1;
        while (mid < right) {
            const sum = sortedNums[left] + sortedNums[mid] + sortedNums[right];
            if (sum === 0) {
                solutions.push([sortedNums[left], sortedNums[mid], sortedNums[right]]);
                mid++;
                while (mid < right && sortedNums[mid] === sortedNums[mid - 1]) mid++;
            } else if (sum < 0) {
                mid++;
            } else {
                right--;
            }
        }
    }
    return solutions;
}

describe('3Sum', () => {
    const cases = [
        {nums: [-1, 0, 1, 2, -1,-4], expected: [[-1,-1,2],[-1,0,1]]},
        {nums: [0,1,1], expected: []},
        {nums: [0,0,0], expected: [[0,0,0]]},
        {nums: [2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10], expected: [[-10,5,5],[-5,0,5],[-4,2,2],[-3,-2,5],[-3,1,2],[-2,0,2]]}, //case from LeetCode that didn't pass
    ];
    describe('brute force solution', () => {
        test.each(cases)('brute force solution returns all unique triplets that sum up to zero: for $nums the result should be $expected', ({nums, expected}) => {
            const result = threeSumByBruteForce(nums);

            expect(result.length).toBe(expected.length);
            expect(result).toStrictEqual(expect.arrayContaining(expected));
        });
    })

    /**
     * Time: O(N*logN) + O(N^2) = O(N^2)
     * Sort array, then iterate over it applying two pointers technique to find pairs that sum up to -nums[i]
     */
    describe('optimized solution', () => {
        test.each(cases)('returns all unique triplets that sum up to zero: for $nums the result should be $expected', ({nums, expected}) => {
            expect(threeSumOptimized(nums)).toStrictEqual(expected);
        });
    })
});

