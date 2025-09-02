# https://leetcode.com/problems/range-sum-query-immutable/description/
from typing import List


class NumArray:

    def __init__(self, nums: List[int]):
        self._nums = nums
        self._precomputed_sums = self._initialize_precomputed_sums(nums)

    @staticmethod
    def _initialize_precomputed_sums(elements: List[int]):
        precomputed_sums = []
        temp_sum = 0
        for element in elements:
            temp_sum += element
            precomputed_sums.append(temp_sum)
        return precomputed_sums

    def sum_range(self, left: int, right:int) -> int:
        result: int = 0
        for i in range(left, right + 1):
            result += self._nums[i]
        return result

    def sum_range_improved(self, left: int, right:int) -> int:
        if left == 0:
            return self._precomputed_sums[right]
        return self._precomputed_sums[right] - self._precomputed_sums[left - 1]