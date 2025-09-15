# https://leetcode.com/problems/subarray-sum-equals-k/description/
from collections import defaultdict


# Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
# We assume that the array is ordered
def subarray_sum_equals_k(nums: list[int], k: int) -> int:
    number_of_solutions = 0
    for i in range(len(nums)):
        num = nums[i]
        if num == k:
            number_of_solutions += 1
        acc = num
        index = i
        while (index < len(nums) - 1):
            acc += nums[index + 1]
            if acc == k:
                number_of_solutions += 1
            index += 1
    return number_of_solutions

# This technique takes into account negative numbers
def subarray_sum_equals_k_improved(nums: list[int], k: int) -> int:
    count = 0
    total_sum = 0
    prefix_sum_counter: dict[int, int] = defaultdict(int)
    prefix_sum_counter[0] = 1  # empty total_sum, this a base case
    for num in nums:
        total_sum += num
        count += prefix_sum_counter[total_sum - k]
        prefix_sum_counter[total_sum] += 1
    return count

# Sliding window approach. Works directly only for non-negative arrays.
# If negatives are present, we fall back to the prefix-sum improved method for correctness.
def subarray_sum_equals_k_sliding_window(nums: list[int], k: int) -> int:
    # Fallback for arrays with negative numbers
    if any(n < 0 for n in nums):
        return subarray_sum_equals_k_improved(nums, k)

    left_index = 0
    curr_sum = 0
    count = 0
    for right_index in range(len(nums)):
        curr_sum += nums[right_index]
        # Shrink window while sum is too large; because numbers are non-negative,
        # moving left_index forward only decreases curr_sum.
        while left_index <= right_index and curr_sum >= k:
            if curr_sum == k:
                count += 1
            curr_sum -= nums[left_index]
            left_index += 1
    return count
