import {describe, it, expect} from "vitest";

function bubbleSortByJunie(numbers: number[]) {
    const arr = numbers; // sort in place
    const n = arr.length;
    if (n < 2) return arr;

    for (let i = 0; i < n - 1; i++) {
        let swapped = false;
        for (let j = 0; j < n - 1 - i; j++) {
            if (arr[j] > arr[j + 1]) {
                const tmp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = tmp;
                swapped = true;
            }
        }
        if (!swapped) break; // everything is already sorted: early exit optimization, no need to keep on iterating
    }
    return arr;
}

describe("BubbleSortByJunie", () => {
    it('should sort an array of positive and zero integers', () => {
        expect(bubbleSortByJunie([8, 3, 1, 7, 0])).toStrictEqual([0, 1, 3, 7, 8]);
    });
})    