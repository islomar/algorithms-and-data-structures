# -*- coding: utf-8 -*-

from expects import *

# Worst case (time and space) = O(n)
def has_all_unique_characters(my_string=None):
    if not my_string:
        return True
    existing_characters = {}
    for character in my_string:
        if existing_characters.get(character):
            return False
        else:
            existing_characters[character] = True
    return True


with describe('Chapter 1'):
    with context('Has all unique characters'):
        with it('returns true for no String'):
            expect(has_all_unique_characters()).to(be_true)

        with it('returns true for empty String'):
            expect(has_all_unique_characters("")).to(be_true)

        with it('returns true for abc'):
            expect(has_all_unique_characters("abc")).to(be_true)

        with it('returns false for aa'):
            expect(has_all_unique_characters("aa")).to(be_false)

        with it('returns false for abcda'):
            expect(has_all_unique_characters("abcda")).to(be_false)