// https://leetcode.com/problems/range-sum-query-2d-immutable/

import {describe, expect, it} from "vitest";

class NumMatrix {

    private prefix_sum_matrix = [];

    constructor(matrix: number[][]) {
        let prefix_sum = 0;
        for (let row = 0; row < matrix.length; row++) {
            this.prefix_sum_matrix[row] = [];
            for (let col = 0; col < matrix[row].length; col++) {
                prefix_sum += matrix[row][col];
                this.prefix_sum_matrix[row][col] = prefix_sum;
            }
        }
    }

    sumRegion(row1: number, col1: number, row2: number, col2: number): number {
        let result1 = this.prefix_sum_matrix[row2][col2] - this.prefix_sum_matrix[row1][col1 -1];
        let result2 = this.prefix_sum_matrix[row2][col1 -1] - this.prefix_sum_matrix[row1][col2];
        return result1 - result2;
    }
}

describe("sumRegion", () => {
    it('should xxx', () => {
        var numMatrix = new NumMatrix([
            [3, 0, 1, 4, 2],
            [5, 6, 3, 2, 1],
            [1, 2, 0, 1, 5],
            [4, 1, 0, 1, 7],
            [1, 0, 3, 0, 5]
        ]);

        expect(numMatrix.sumRegion(2, 1, 4, 3)).toBe(8);
        //expect(numMatrix.sumRegion(1, 1, 2, 2)).toBe(11);
        //expect(numMatrix.sumRegion(1, 2, 2, 4)).toBe(12);
    });
})