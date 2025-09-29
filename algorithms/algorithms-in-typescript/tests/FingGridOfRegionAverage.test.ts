/**
 * https://leetcode.com/problems/find-the-grid-of-region-average/description/
 *
 * https://www.youtube.com/watch?v=2e_oF_7RMBU
 * https://www.youtube.com/watch?v=PDzGws_-vuo
 *
 * A region is a 3 x 3 subgrid where the absolute difference in intensity between any two adjacent pixels is less than or equal to threshold.
 */
import {describe, expect, test} from "vitest";



/**
 * Complexity analysis:
 * - Let m = number of rows, n = number of columns.
 * - We examine each possible 3x3 subgrid: O((m-2)(n-2)) = O(mn).
 *   For each subgrid, the validity check (adjacent comparisons within 3x3),
 *   summing 9 cells, and assigning the average to 9 cells are all O(1).
 * - Final pass to build the result grid is O(mn).
 * Overall time: O(mn).
 * Extra space: O(mn) for sumAverages and counts (and O(mn) for the result grid).
 */
function resultGridByJunie(image: number[][], threshold: number): number[][] {
    const numberOfRows = image.length;
    const numberOfColumns = image[0].length;

    // For each pixel, accumulate the averages of all regions it belongs to
    const sumAverages: number[][] = Array.from({ length: numberOfRows }, () => Array(numberOfColumns).fill(0));
    const counts: number[][] = Array.from({ length: numberOfRows }, () => Array(numberOfColumns).fill(0));

    // Helper to check if a 3x3 subgrid with top-left (r, c) is a valid region
    function isValidRegion(row: number, column: number): boolean {
        for (let i = row; i < row + 3; i++) {
            for (let j = column; j < column + 3; j++) {
                // Right neighbor within subgrid
                if (j + 1 < column + 3) {
                    if (Math.abs(image[i][j] - image[i][j + 1]) > threshold) return false;
                }
                // Down neighbor within subgrid
                if (i + 1 < row + 3) {
                    if (Math.abs(image[i][j] - image[i + 1][j]) > threshold) return false;
                }
            }
        }
        return true;
    }

    // Iterate all 3x3 subgrids
    for (let r = 0; r + 2 < numberOfRows; r++) {
        for (let c = 0; c + 2 < numberOfColumns; c++) {
            if (!isValidRegion(r, c)) continue;

            // Compute floored average intensity of this region
            let sum = 0;
            for (let i = r; i < r + 3; i++) {
                for (let j = c; j < c + 3; j++) {
                    sum += image[i][j];
                }
            }
            const regionAvg = Math.floor(sum / 9);

            // Assign this region average to each pixel within the region
            for (let i = r; i < r + 3; i++) {
                for (let j = c; j < c + 3; j++) {
                    sumAverages[i][j] += regionAvg;
                    counts[i][j] += 1;
                }
            }
        }
    }

    // Build result grid
    const result: number[][] = Array.from({ length: numberOfRows }, () => Array(numberOfColumns).fill(0));
    for (let i = 0; i < numberOfRows; i++) {
        for (let j = 0; j < numberOfColumns; j++) {
            if (counts[i][j] > 0) {
                result[i][j] = Math.floor(sumAverages[i][j] / counts[i][j]);
            } else {
                result[i][j] = image[i][j];
            }
        }
    }

    return result;
}


describe('Find the Grid of Region Average', () => {
    const cases = [
        {inputImage: [[5,6,7,10],[8,9,10,10],[11,12,13,10]], threshold: 3, expectedGrid: [[9,9,9,9],[9,9,9,9],[9,9,9,9]]},
        {inputImage: [[10,20,30],[15,25,35],[20,30,40],[25,35,45]], threshold: 12, expectedGrid: [[25,25,25],[27,27,27],[27,27,27],[30,30,30]]},
        {inputImage: [[5,6,7],[8,9,10],[11,12,13]], threshold: 1, expectedGrid: [[5,6,7],[8,9,10],[11,12,13]]},
    ];

    describe('resultGridByJunie should', () => {
        test.each(cases)('return $expected for $input with threshold $threshold', ({inputImage, threshold, expectedGrid}) => {
            expect(resultGridByJunie(inputImage, threshold)).toEqual(expectedGrid);
        });
    })
});