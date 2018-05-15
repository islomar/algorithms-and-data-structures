# -*- coding: utf-8 -*-

from expects import *

number_to_fib = dict()

def fibonacci(number):
    if number == 0:
        return 0
    elif number == 1:
        return 1
    else:
        if number in number_to_fib:
            print("Got the number {}".format(number))
            return number_to_fib[number]
        else:
            result = fibonacci(number-1) + fibonacci(number-2)
            number_to_fib[number] = result
            return result


with describe('Fibonacci sequence'):
    with context('When passing 0'):
        with it('returns 0'):
            expect(fibonacci(0)).to(equal(0))

    with context('When passing 1'):
        with it('returns 1'):
            expect(fibonacci(1)).to(equal(1))

    with context('When passing 2'):
        with it('returns 1'):
            expect(fibonacci(2)).to(equal(1))

    with context('When passing 3'):
        with it('returns 2'):
            expect(fibonacci(3)).to(equal(2))

    with context('When passing 3'):
        with it('returns 2'):
            expect(fibonacci(3)).to(equal(2))