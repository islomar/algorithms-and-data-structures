# -*- coding: utf-8 -*-

from collections import OrderedDict
from expects import *

def compress_string(raw_string):
    compressed_string = OrderedDict()
    for letter in raw_string:
        compressed_string[letter] = compressed_string.get(letter, 0) + 1
    resultWithOnes = ''.join('{}{}'.format(key, value) for key, value in compressed_string.items())
    resultWithoutOnes = ''.join([letter for letter in resultWithOnes if letter != "1"])
    return resultWithoutOnes



with describe('Chapter 1'):
    with context('Basic string compression'):
        with it('converts "" to ""'):
            expect(compress_string("")).to(be_empty)

        with it('converts aa to a2'):
            expect(compress_string("aa")).to(equal("a2"))

        with it('converts abcd to abcd'):
            expect(compress_string("abcd")).to(equal("abcd"))

        with it('converts aab to a2b'):
            expect(compress_string("aab")).to(equal("a2b"))

        with it('converts aabcccccaaa to a2b1c5a3'):
            expect(compress_string("")).to(be_empty)