# -*- coding: utf-8 -*-

from expects import *


def calculate_diagonal_difference(input_rows):
    all_lines = input_rows.splitlines()
    matrix_size = int(all_lines[0])
    if matrix_size == 1:
        return int(all_lines[1])
    matrix = convert_to_matrix(all_lines[1:])
    primary_diagonal = []
    secondary_diagonal = []
    for index in range(matrix_size):
        diagonal_element = int(matrix[index][index])
        primary_diagonal.append(diagonal_element)

    secondary_index = matrix_size - 1
    for index in range(matrix_size):
        secondary_diagonal_element = int(matrix[index][secondary_index])
        secondary_diagonal.append(secondary_diagonal_element)
        secondary_index -= 1

    result = sum(primary_diagonal) - sum(secondary_diagonal)
    return abs(result)


def convert_to_matrix(all_lines):
    result = []
    for line in all_lines:
        result.append(line.split())
    return result



# https://www.hackerrank.com/challenges/diagonal-difference/problem
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
    with context('When the matrix has size 3'):
        with it('returns the right result'):
            matrix ="3\n11 2 4\n4 5 6\n10 8 -12"

            expect(calculate_diagonal_difference(matrix)).to(equal(15))



