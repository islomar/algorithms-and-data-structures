# -*- coding: utf-8 -*-

from expects import *

# https://www.hackerrank.com/challenges/two-strings/problem

class Combination(object):
    def __init__(self, s1, s2):
        self.s1 = s1
        self.s2 = s2

    def __eq__(self, other):
        if isinstance(self, other.__class__):
            return self.__dict__ == other.__dict__
        return False

    def __hash__(self):
        return hash((self.s1, self.s2))

cache = dict()

# it could be improved with memoization
def are_substrings(s1, s2):
    print(s1, s2)
    combination = Combination(s1, s2)
    if cache.get(combination, False):
        return cache[combination]
    if s1 == s2:
        return True
    elif len(s1) > 1 and len(s2) > 1:
        return are_substrings(s1[1:], s2) or are_substrings(s1[:-1], s2) or are_substrings(s1, s2[1:]) or are_substrings(s1, s2[:-1])
    elif len(s1) > len(s2):
        return s2 in s1
    else:
        return s1 in s2


def twoStrings(s1, s2):
    if are_substrings(s1, s2):
        print("YES")
    else:
        print("NO")


with describe('Two string'):
    with context('when there is a subarray'):
        with it('prints YES'):
            twoStrings("abcd", "bc")
            #expect(twoStrings("abcd", "bc")).to(equal("TRUE"))

with describe('is_substring()'):
    with context('When passing two empty strings'):
        with it('returns True'):
            expect(are_substrings("", "")).to(be_true)

    with context('When passing the same character'):
        with it('returns True'):
            expect(are_substrings("a", "a")).to(be_true)

    with context('When passing two different characters'):
            with it('returns False'):
                expect(are_substrings("a", "b")).to(be_false)

    with context('When passing ab and b'):
            with it('returns True'):
                expect(are_substrings("ab", "b")).to(be_true)

    with context('When passing two abcd and bc'):
            with it('returns True'):
                expect(are_substrings("abcd", "bc")).to(be_true)

    with context('When passing cd and ab'):
            with it('returns False'):
                expect(are_substrings("cd", "ab")).to(be_false)

    with context('When passing c and cd'):
            with it('returns True'):
                expect(are_substrings("c", "cd")).to(be_true)