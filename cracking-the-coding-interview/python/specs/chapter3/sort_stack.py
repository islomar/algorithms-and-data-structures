# -*- coding: utf-8 -*-

from expects import *

class MyStack(object):
    def __init__(self, elements=None):
        if not elements:
            self.elements = []
        else:
            self.elements = elements

    def push(self, element):
        self.elements.append(element)

    def pop(self):
        return self.elements.pop()

    def peek(self):
        if not self.elements:
            return None
        return self.elements[-1]

    def sort(self, ascending_order=True):
        if not ascending_order:
            raise NotImplementedError()
        sorted_elements = []
        index = 0
        for element in self.elements:
            if index < len(self.elements):
                rest = self.elements[index + 1:]
                for another_element in rest:
                    if element > another_element:
                        
                index += 1
        return sorted_elements

    def is_empty(self):
        return not self.elements


with describe('Chapter 3'):
    with context('Sort a stack in ascending order'):
        with it('is initially empty'):
            my_stack = MyStack()

            expect(my_stack.is_empty()).to(be_true)

        with it('is not empty after pushing one element'):
            my_stack = MyStack()

            my_stack.push(1)

            expect(my_stack.is_empty()).to(be_false)


        with it('pops the last element when there is one element'):
            my_stack = MyStack()
            my_stack.push(1)

            popped_element = my_stack.pop()

            expect(popped_element).to(equal(1))
            expect(my_stack.is_empty()).to(be_true)

        with it('pops the last element'):
            my_stack = MyStack()
            my_stack.push(1)
            my_stack.push(2)

            popped_element = my_stack.pop()

            expect(popped_element).to(equal(2))
            expect(my_stack.is_empty()).to(be_false)

        with it('peeks the last element'):
            my_stack = MyStack()
            my_stack.push(1)

            last_element = my_stack.peek()

            expect(last_element).to(equal(1))
            expect(my_stack.is_empty()).to(be_false)

        with it('sorts an unordered stack with two elements'):
            my_stack = MyStack()
            my_stack.push(8)
            my_stack.push(2)

            sorted_stack = my_stack.sort()

            expect(sorted_stack.pop()).to(equal(8))
            expect(sorted_stack.pop()).to(equal(2))
