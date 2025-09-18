import {describe, expect, it} from "vitest";

const insertionSort = arr => {
    arr.forEach((item, i) => {
        let num = arr[i];
        let j;

        for (j = i - 1; j >= 0 && arr[j] > num; j--) {
            arr[j + 1] = arr[j];
        };
        arr[j + 1] = num;
    });

    return arr;
};


describe("InsertionSort", () => {
    it('should sort an array of positive and zero integers', () => {
        expect(insertionSort([8, 3, 1, 7, 0])).toStrictEqual([0, 1, 3, 7, 8]);
    });
})