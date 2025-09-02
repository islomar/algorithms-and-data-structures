# https://leetcode.com/problems/subarray-sum-equals-k/description/

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