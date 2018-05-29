import unittest

# this version does not keep the order
def deduplicate_v1(duplicated_list):
    return list(set(duplicated_list))

# my first approach for keeping the order. Complexity O(n ^ 2)
def deduplicate_v2(duplicated_list):
    result = list()
    for element in duplicated_list:
        if element not in result: # this implies another loop
            result.append(element)
    return list(result)

# Complexity O(n)
def deduplicate_v3(duplicated_list):
    deduplicated_dict = dict()
    result = list()
    for element in duplicated_list:
        if not deduplicated_dict.get(element, False):
            deduplicated_dict[element] = True
            result.append(element)
    return result


class TestDeduplicate(unittest.TestCase):
    def test_list_without_duplicated_elements(self):
        self.assertEqual(deduplicate_v1([1, 2]), [1, 2])

    def test_list_with_sorted_duplicated_elements(self):
        self.assertEqual(deduplicate_v1([1, 1, 2, 2, 3]), [1, 2, 3])

    def test_list_with_unsorted_duplicated_elements(self):
        self.assertEqual(deduplicate_v3([2, 2, 1, 1, 1, 3]), [2, 1, 3])


unittest.main(exit=False)
