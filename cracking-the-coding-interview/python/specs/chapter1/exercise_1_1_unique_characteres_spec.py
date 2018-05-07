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


# Worst case (time) = ~O(n^2)
def has_all_unique_characters_v2(my_string=None):
    if not my_string:
        return True
    index = 1
    for character in my_string:
        rest = my_string[index:]
        for another_character in rest:
            if character == another_character:
                return False
        index += 1
    return True


with describe('Chapter 1'):
    with context('Has all unique characters (using additional data structures)'):
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

    with context('Has all unique characters (not using additional data structures)'):
        with it('returns true for no String'):
            expect(has_all_unique_characters_v2()).to(be_true)

        with it('returns true for empty String'):
            expect(has_all_unique_characters_v2("")).to(be_true)

        with it('returns true for abc'):
            expect(has_all_unique_characters_v2("abc")).to(be_true)

        with it('returns false for aa'):
            expect(has_all_unique_characters_v2("aa")).to(be_false)

        with it('returns false for abcda'):
            expect(has_all_unique_characters_v2("abcda")).to(be_false)