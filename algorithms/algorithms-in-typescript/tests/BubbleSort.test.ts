import {describe, it, expect} from "vitest";

function bubbleSort(numbers: number[]) {
    let numberOfElementsSorted: number = 0;
    for (let index = 0; index < numbers.length - numberOfElementsSorted; index++) {
        for (let internalIndex = 0; internalIndex < numbers.length - numberOfElementsSorted; internalIndex++) {
            if (numbers[internalIndex] > numbers[internalIndex + 1]) {
                const temp: number = numbers[internalIndex];
                numbers[internalIndex] = numbers[internalIndex + 1];
                numbers[internalIndex + 1] = temp;
            }
        }
        index = 0;
        numberOfElementsSorted++;
    }
    return numbers;
}

// https://www.digitalocean.com/community/tutorials/js-bubble-selection-insertion-sort#bubble-sort
const bubbleSortByDigitalOcean = arr => {
    const swap = (list, a, b) => [list[a], list[b]] = [list[b], list[a]];

    for (let i = arr.length; i > 0; i--) {
        for (let j = 0; j < i - 1; j++) {
            if (arr[j] > arr[j + 1]) swap(arr, j, j + 1);
        };
    };

    return arr;
};

describe("BubbleSort", () => {
    it('should sort an array of positive and zero integers', () => {
        expect(bubbleSort([8, 3, 1, 7, 0])).toStrictEqual([0, 1, 3, 7, 8]);
    });
})

describe("BubbleSortByDigitalOcean", () => {
    it('should sort an array of positive and zero integers', () => {
        expect(bubbleSortByDigitalOcean([8, 3, 1, 7, 0])).toStrictEqual([0, 1, 3, 7, 8]);
    });
})