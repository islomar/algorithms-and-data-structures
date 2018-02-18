class Node(object):
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

    def __str__(self):
        return '<Node {{ value = {}, left = {}, right = {} }} >'.format(self.value, self.left, self.right)



class BST(object):
    def __init__(self, root):
        self.root = Node(root)

    def insert(self, new_val):
        self.insert_in_branch(self.root, new_val)

    def insert_in_branch(self, start, new_val):
        if new_val < start.value:
            if start.left is None:
                start.left = Node(new_val)
            self.insert_in_branch(start.left, new_val)
        elif new_val > start.value:
            if start.right is None:
                start.right = Node(new_val)
            self.insert_in_branch(start.right, new_val)

    def search(self, find_val):
        return False

    def print_tree(self):
        print self.preorder_print(self.root, [])

    def preorder_print(self, start, traversal):
        if start is not None:
            traversal.append(str(start.value))
        if start.left is not None:
            self.preorder_print(start.left, traversal)
        if start.right is not None:
            self.preorder_print(start.right, traversal)
        return '-'.join(traversal)

    def __str__(self):
        return '<BST {{ root = {} }} >'.format(self.root)


# Set up tree
tree = BST(4)

# Insert elements
tree.insert(2)
tree.insert(1)
tree.insert(3)
tree.insert(5)

# tree.print_tree()
# print(tree)



# # Check search
# # Should be True
# print tree.search(4)
# # Should be False
# print tree.search(6)