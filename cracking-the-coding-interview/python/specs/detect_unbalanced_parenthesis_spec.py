# -*- coding: utf-8 -*-

from expects import *

def is_balanced_with_stack(expression):
    opening = tuple('({[')
    closing = tuple(')}]')
    mapping = dict(zip(opening, closing))
    stack = []

    for letter in expression:
        if letter in opening:
            stack.append(mapping[letter])
        elif letter in closing:
            if not stack or letter != stack.pop():
                return False
    return not stack


def is_balanced(my_string):
    counter = 0
    if not my_string:
        return True
    for character in my_string:
        if character == "(":
            counter += 1
        elif character == ")":
            counter -= 1
        if counter < 0:
            return False
    if counter != 0:
        return False
    return True



with describe('Detect balanced parenthesis'):
    with context('Stack solution'):
        with context('When the string is empty'):
            with it('is considered balanced'):
                expect(is_balanced_with_stack("")).to(equal(True))

        with context('When the string is ('):
            with it('is considered unbalanced'):
                expect(is_balanced_with_stack("(")).to(equal(False))

        with context('When there are more opened than closed'):
            with it('is considered unbalanced'):
                expect(is_balanced_with_stack("'[]()()(((([])))")).to(equal(False))

        with context('When there are the same amount opened than close'):
            with it('is considered balanced'):
                expect(is_balanced_with_stack('[](){{{[]}}}')).to(equal(True))

    with context('Iterative solution'):
        with context('When the string is empty'):
            with it('is considered balanced'):
                expect(is_balanced("")).to(equal(True))

        with context('When the string is ()'):
            with it('is considered balanced'):
                expect(is_balanced("()")).to(equal(True))

        with context('When there are the same amount opened than close'):
            with it('is considered balanced'):
                expect(is_balanced("a((sadfasdf)2())")).to(equal(True))

        with context('When the string is ('):
            with it('is considered unbalanced'):
                expect(is_balanced("(")).to(equal(False))

        with context('When there are more opened than closed'):
            with it('is considered unbalanced'):
                expect(is_balanced("2((x)")).to(equal(False))

        with context('When there are closed parenthesis before opened'):
            with it('is considered unbalanced'):
                expect(is_balanced("2)c(a")).to(equal(False))