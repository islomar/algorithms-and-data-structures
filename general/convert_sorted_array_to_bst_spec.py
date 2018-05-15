# -*- coding: utf-8 -*-

from expects import *


class Node(object):
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

    def __str__(self):
        return str(self.value)

class BST(object):
    def convert_subarray_to_bst(self, sorted_array, start, end):
        print("{} , {} , {}".format(sorted_array, start, end))
        if start > end:
            return None
        middle_index = int((start + end) / 2)
        print("middle_index: {}".format(middle_index))
        node = Node(sorted_array[middle_index])
        node.left = self.convert_subarray_to_bst(sorted_array, start, middle_index - 1)
        node.right = self.convert_subarray_to_bst(sorted_array, middle_index + 1, end)
        return node

    def pre_order(self, node):
        print("preorder: {}".format(node))
        if not node:
            return
        print(str(node.value) + " ")
        self.pre_order(node.left)
        self.pre_order(node.right)

    def __str__(self):
        return "root: {}".format(self.root)



# https://www.youtube.com/watch?v=3yy1uQfi8pk
with describe('Convert sorted array to BST'):
    # with context('When array is empty'):
    #     with it('returns an empty BST'):
    #         bst = sort_array_to_bst([])

    #         expect(bst).to(equal(None))

    # with context('When array has one element'):
    #     with it('returns a BST with that value'):
    #         bst = sort_array_to_bst([1])

    #         expect(bst.root.value).to(equal(1))

    # with context('When array has three elements'):
    #     with it('returns a BST'):
    #         bst = sort_array_to_bst([1, 2, 3])

    #         expect(bst.root.value).to(equal(2))
    #         expect(bst.left.value).to(equal(1))
    #         expect(bst.right.value).to(equal(3))

    with context('When array has 5 elements'):
        with it('returns a BST'):
            sorted_array = [1, 2, 3, 4, 5]
            bst = BST()
            bst.convert_subarray_to_bst(sorted_array, 0, len(sorted_array) - 1)

            bst.pre_order(bst.root)
            # expect(bst.root.value).to(equal(3))
            # expect(bst.left.value).to(equal(2))
            # expect(bst.right.value).to(equal(4))