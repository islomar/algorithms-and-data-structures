/**
 * Given an array of positive integers, return the number of elements that are strictly greater than the average of all previous elements. Skip the first element.
 *
 * https://www.hackerrank.com/contests/software-engineer-prep-kit/challenges/count-elements-greater-than-previous-average/problem?isFullScreen=true
 */
import {describe, expect, test} from "vitest";


function countResponseTimeRegressionsNaive(responseTimes: number[]): number {
    let currentNumberOfElementsGreaterThanAverage: number = 0;

    const averageTime = responseTimes.reduce((a, b) => a + b) / responseTimes.length;
    for (const responseTime of responseTimes) {
        if (responseTime > averageTime) {
            currentNumberOfElementsGreaterThanAverage++;
        }
    }
    return currentNumberOfElementsGreaterThanAverage;
}


describe('Count elements greater than previous average', () => {
    const cases = [
        {input: [100, 200], expected: 1},
        {input: [100, 200, 150], expected: 1},
        {input: [100, 200, 150, 300], expected: 2},
    ];

    describe('countResponseTimeRegressionsNaive should', () => {
        test.each(cases)('return $expected for $input', ({input, expected}) => {
            expect(countResponseTimeRegressionsNaive(input)).toBe(expected);
        });
    })
});