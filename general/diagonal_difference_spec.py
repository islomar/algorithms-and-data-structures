# -*- coding: utf-8 -*-

from expects import *


def calculate_diagonal_difference(input_rows):
    all_lines = input_rows.splitlines()
    matrix_size = int(all_lines[0])
    if matrix_size == 1:
        return int(all_lines[1])

    matrix = convert_to_matrix(all_lines[1:])
    primary_diagonal = calculate_primary_diagonal(matrix_size, matrix)
    secondary_diagonal = calculate_secondary_diagonal(matrix_size, matrix)

    result = sum(primary_diagonal) - sum(secondary_diagonal)
    return abs(result)

def convert_to_matrix(all_lines):
    result = []
    for line in all_lines:
        result.append(list(map(lambda element: int(element), line.split())))
    return result

def calculate_primary_diagonal(matrix_size, matrix):
    primary_diagonal = []
    for index in range(matrix_size):
        diagonal_element = matrix[index][index]
        primary_diagonal.append(diagonal_element)
    return primary_diagonal


def calculate_secondary_diagonal(matrix_size, matrix):
    secondary_diagonal = []
    secondary_index = matrix_size - 1
    for index in range(matrix_size):
        secondary_diagonal_element = matrix[index][secondary_index]
        secondary_diagonal.append(secondary_diagonal_element)
        secondary_index -= 1
    return secondary_diagonal



# https://www.hackerrank.com/challenges/diagonal-difference/problem
# https://www.hackerrank.com/challenges/diagonal-difference/submissions/code/72383656
with describe('Diagonal difference'):
    with context('When the matrix has only a 0'):
        with it('returns 0'):
            matrix ="0"

            expect(calculate_diagonal_difference(matrix)).to(equal(0))

    with context('When the matrix has only one element'):
        with it('returns that element'):
            matrix ="1\n1"

            expect(calculate_diagonal_difference(matrix)).to(equal(1))

    with context('When the matrix has size 2'):
        with it('returns the right result'):
            matrix ="2\n1 1\n3 5"

            expect(calculate_diagonal_difference(matrix)).to(equal(2))

    # Sample Input
    # 3
    # 11 2 4
    # 4 5 6
    # 10 8 -12

    # Sample Output
    # 15
    # Solution >> Time complexity = O(2n) ~ O(n)
    # Solution >> Space complexity = O(2n) ~ O(n)
    with context('When the matrix has size 3'):
        with it('returns the right result'):
            matrix ="3\n11 2 4\n4 5 6\n10 8 -12"

            expect(calculate_diagonal_difference(matrix)).to(equal(15))



