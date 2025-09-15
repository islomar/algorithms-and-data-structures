import pytest
from expects import expect, equal

# https://leetcode.com/problems/contiguous-array/description/
# Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

## Solutions
# https://leetcode.com/problems/contiguous-array/solutions/

def find_max_length_brute_force(nums: list[int]) -> int:
    continuous_numbers_array = []
    index = 0
    while index < len(nums):
        current_value = nums[index]
        number_of_equal_numbers = 0
        while index < len(nums) and current_value == nums[index]:
            number_of_equal_numbers += 1
            index += 1
        continuous_numbers_array.append(number_of_equal_numbers)

    results = []
    for index in range(len(continuous_numbers_array) - 1):
        results.append(min(continuous_numbers_array[index], continuous_numbers_array[index + 1]))
    return 2 * max(results)

# O(n) solution
# Keep track the number of ones and zeros
# https://www.youtube.com/watch?v=agB1LyObUNE
# https://www.youtube.com/watch?v=Xkl4EknqW8Y (better explanation)
# Map each index to pair (count[0], count[1])
# The key is the diff, the value is the index of the first occurrence of the diff
# Use diff between counts for O(1) lookup of what we need
def find_max_length_v2(nums: list[int]) -> int:
    zero, one = 0, 0
    result = 0
    diff_index = {} # count[1] - count[0] -> index
    for i, num in enumerate(nums):
        if num == 0:
            zero += 1
        else:
            one += 1

        diff = one - zero
        if diff not in diff_index:
            diff_index[diff] = i

        if diff == 0:
            result = one + zero
        else:
            index_for_first_diff = diff_index[diff]
            result = max(result, i - index_for_first_diff)
            diff_index[diff] = i
    return result

testdata = [
    ([0, 1], 2),
    ([0, 1, 0], 2),
    ([0, 1, 1, 1, 1, 1, 0, 0, 0], 6),
]

@pytest.mark.parametrize("nums, expected", testdata)
def test_find_max_length_brute_force(nums, expected) -> None:
    expect(find_max_length_brute_force(nums)).to(equal(expected))

@pytest.mark.parametrize("nums, expected", testdata)
def test_find_max_length_v2(nums, expected) -> None:
    expect(find_max_length_v2(nums)).to(equal(expected))