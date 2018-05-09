# -*- coding: utf-8 -*-

from expects import *


def calculate_possible_ways_to_run_up_stairs(number_of_stairs):
    if number_of_stairs < 0:
        return 0
    if number_of_stairs == 0:
        return 1
    return calculate_possible_ways_to_run_up_stairs(number_of_stairs - 1) \
            + calculate_possible_ways_to_run_up_stairs(number_of_stairs - 2) \
            + calculate_possible_ways_to_run_up_stairs(number_of_stairs - 3)




with describe('Calculate number of possible ways to run up the stairs'):
    with context('When the staircase has 0 stairs'):
        with it('has 1 different ways'):
            expect(calculate_possible_ways_to_run_up_stairs(0)).to(equal(1))

    with context('When the staircase has 1 stairs'):
        with it('has 1 different ways'):
            expect(calculate_possible_ways_to_run_up_stairs(1)).to(equal(1))

    with context('When the staircase has 2 stairs'):
        with it('has 2 different ways'):
            expect(calculate_possible_ways_to_run_up_stairs(2)).to(equal(2))

    with context('When the staircase has 3 stairs'):
        with it('has 4 different ways'):
            expect(calculate_possible_ways_to_run_up_stairs(3)).to(equal(4))