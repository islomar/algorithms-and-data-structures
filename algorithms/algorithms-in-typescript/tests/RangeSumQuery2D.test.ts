/**
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 * https://www.youtube.com/watch?v=KE8MQuwE2yA
 *
 * In each position of the matrix, we store the sum of the elements inside a square with the bottom right corner being that position.
 *
 * We assume that each position of the matrix is the bottom right corner of a square, of a submatrix.
 */

import {describe, expect, it} from "vitest";

class NumMatrix {

    private prefix_sum_matrix: Array<Array<number>> = [];

    constructor(matrix: number[][]) {
        this._build_prefix_sum_matrix(matrix);
    }

    private _build_prefix_sum_matrix(matrix: number[][]) {
        let prefix_sum = 0;
        for (let row = 0; row < matrix.length; row++) {
            this.prefix_sum_matrix[row] = [];
            let row_prefix_sum = 0;
            for (let col = 0; col < matrix[row].length; col++) {
                row_prefix_sum += matrix[row][col];
                prefix_sum = row_prefix_sum + this._prefix_cell_above(row, col); //this gives us an area where that cell is the bottom right corner
                this.prefix_sum_matrix[row][col] = prefix_sum;
            }
        }
    }

    private _prefix_cell_above(row: number, col: number): number {
        if (row - 1 < 0) return 0;
        return this.prefix_sum_matrix[row - 1][col];
    }

    private _prefix_cell_on_the_left(row: number, col: number): number {
        if (col - 1 < 0) return 0;
        return this.prefix_sum_matrix[row][col - 1];
    }

    sumRegion(topLeftRow: number, topLeftColumn: number, bottomRightRow: number, bottomRightColumn: number): number {
        const fullSquareSumFromBottomRight = this.prefix_sum_matrix[bottomRightRow][bottomRightColumn];
        const aboveArea = this._prefix_cell_above(topLeftRow, bottomRightColumn);
        const leftArea = this._prefix_cell_on_the_left(bottomRightRow, topLeftColumn);
        const topLeftArea = this.prefix_sum_matrix[topLeftRow - 1][topLeftColumn - 1];

        // We add back the top left area because it is substracted twice: in the above area and left area
        return fullSquareSumFromBottomRight - aboveArea - leftArea + topLeftArea;
    }
}

describe("sumRegion", () => {
    it('should work :-)', () => {
        var numMatrix = new NumMatrix([
            [3, 0, 1, 4, 2],
            [5, 6, 3, 2, 1],
            [1, 2, 0, 1, 5],
            [4, 1, 0, 1, 7],
            [1, 0, 3, 0, 5]
        ]);

        expect(numMatrix.sumRegion(2, 1, 4, 3)).toBe(8);
        expect(numMatrix.sumRegion(1, 1, 2, 2)).toBe(11);
        expect(numMatrix.sumRegion(1, 2, 2, 4)).toBe(12);
    });
})