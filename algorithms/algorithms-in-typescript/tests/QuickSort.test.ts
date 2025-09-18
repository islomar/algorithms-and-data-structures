// https://www.digitalocean.com/community/tutorials/js-big-o-notation#o-log-n
import {describe, expect, it} from "vitest";

const quickSortByDigitalOcean = arr => {
    if (arr.length < 2) return arr;

    let pivot = arr[0];
    let left = [];
    let right = [];

    for (let i = 1, total = arr.length; i < total; i++) {
        if (arr[i] < pivot) left.push(arr[i]);
        else right.push(arr[i]);
    };
    return [
        ...quickSortByDigitalOcean(left),
        pivot,
        ...quickSortByDigitalOcean(right)
    ];
};

describe("QuickSortByDigitalOcean", () => {
    it('should sort an array of positive and zero integers', () => {
        expect(quickSortByDigitalOcean([8, 3, 1, 7, 0])).toStrictEqual([0, 1, 3, 7, 8]);
    });
})