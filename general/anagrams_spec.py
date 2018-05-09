# -*- coding: utf-8 -*-

from expects import *

# We consider two strings to be anagrams of each other if the first string's letters can be rearranged to form the second string.
# In other words, both strings must contain the same exact letters in the same exact frequency.
# Minimum number of character deletions required to make the two strings anagrams. Can you help her find this number?
# lowercase English letters, ascii[a-z].
# https://www.hackerrank.com/challenges/making-anagrams/problem
with describe('Anagrams'):
    with context('xx'):
        with it('yy'):
            expect(calculate_min_deletions_for_anagram("", "")).to(equal(0))


# Sample Input
# cde
# abc

# Sample Output
# 4

# Find the common letters