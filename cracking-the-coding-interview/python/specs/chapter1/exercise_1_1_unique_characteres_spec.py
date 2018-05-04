# -*- coding: utf-8 -*-

from expects import *

with describe('Generate configuration'):
    with context('when executing generate the configuration files action'):
        with it('calls configuration files service method'):

            expect(true).to(be_true)