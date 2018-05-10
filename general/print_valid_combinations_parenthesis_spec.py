# -*- coding: utf-8 -*-

from expects import *

def print_all_valid_combinations_of_parenthesis_for_pairs(number_of_pairs):
    result = []
    if number_of_pairs == 0:
        result.append("")
    elif number_of_pairs == 1:
        result.append("()")
    else:
        previous_combinations = print_all_valid_combinations_of_parenthesis_for_pairs(number_of_pairs - 1)
        for combination in previous_combinations:
            result.append("(" + combination + ")")
            result.append("()" + combination)
            result.append(combination + "()")
    return list(set(result))


with describe('Print all valid combinations for n-pair parenthesis'):
    with context('0 pair of parenthesis'):
        with it('has 0 different combination'):
            expect(print_all_valid_combinations_of_parenthesis_for_pairs(0)).to(contain_only(""))

    with context('1 pair of parenthesis'):
        with it('has 1 different combination'):
            expect(print_all_valid_combinations_of_parenthesis_for_pairs(1)).to(contain_only("()"))

    with context('2 pairs of parenthesis'):
        with it('has 2 different combination'):
            expect(print_all_valid_combinations_of_parenthesis_for_pairs(2)).to(contain_only("()()", "(())"))

    with context('3 pairs of parenthesis'):
        with it('has 5 different combination'):
            expect(print_all_valid_combinations_of_parenthesis_for_pairs(3)).to(contain_only("(()())", "((()))", "()(())", "(())()", "()()()"))