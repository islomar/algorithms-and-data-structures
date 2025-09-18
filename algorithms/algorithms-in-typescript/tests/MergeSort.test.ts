/**
 * https://www.digitalocean.com/community/tutorials/js-understanding-merge-sort
 * https://dev.to/jaimaldullat/how-merge-sort-works-in-javascript-5c1e
 * 
 * Similar to binary search, mergeAlreadySortedArrays sort is a divide and conquer algorithm. The goal being to break down our problem into sub-problems and recursively continue to break those down until we have a lot of simple problems that we can easily put back together.
 *
 * Merge sort is built off the idea of comparing whole arrays instead of individual items. First, we need to take the entire array and break it into many sub-arrays by continuously splitting everything in half until everything is alone in its own array. Since the amount of sub-arrays will be some multiple of the number of items in our main array, that’s what gives us the log in O(nlogn).
 */
import {describe, expect, it} from "vitest";

const mergeAlreadySortedArrays = (arr1, arr2) => {
    let sorted = [];

    while (arr1.length && arr2.length) {
        if (arr1[0] < arr2[0]) sorted.push(arr1.shift());
        else sorted.push(arr2.shift());
    };

    return sorted.concat(arr1.slice().concat(arr2.slice()));
};

const mergeSort = arr => {
    if (arr.length <= 1) return arr;
    let mid = Math.floor(arr.length / 2),
        left = mergeSort(arr.slice(0, mid)),
        right = mergeSort(arr.slice(mid));

    return mergeAlreadySortedArrays(left, right);
};

describe("MergeSort", () => {
    it('should sort an array of positive and zero integers', () => {
        expect(mergeSort([8, 3, 1, 7, 0])).toStrictEqual([0, 1, 3, 7, 8]);
    });
})