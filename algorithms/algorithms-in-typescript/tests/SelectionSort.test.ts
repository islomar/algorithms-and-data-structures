// https://www.digitalocean.com/community/tutorials/js-bubble-selection-insertion-sort#selection-sort

import {describe, expect, it} from "vitest";

const selectionSort = arr => {
    const swap = (list, a, b) => [list[a], list[b]] = [list[b], list[a]];

    arr.forEach((item, i) => {
        let min = i;
        for (let j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[min]) min = j;
        };
        swap(arr, i, min);
    });

    return arr;
};

describe("SelectionSort", () => {
    it('should sort an array of positive and zero integers', () => {
        expect(selectionSort([8, 3, 1, 7, 0])).toStrictEqual([0, 1, 3, 7, 8]);
    });
})