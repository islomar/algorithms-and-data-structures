from typing import List


def build_prefix_sum(nums: List[int]) -> List[int]:
    """Builds a prefix sum array where prefix[i] is sum(nums[0:i]).
    The returned array has length len(nums) + 1 and prefix[0] == 0.
    """
    prefix = [0]
    for x in nums:
        prefix.append(prefix[-1] + x)
    return prefix


def range_sum(prefix: List[int], left: int, right: int) -> int:
    """Returns the sum of nums[left:right+1] given its prefix sums.
    Preconditions: 0 <= left <= right < len(nums) where len(nums) == len(prefix) - 1.
    """
    if left < 0 or right >= len(prefix) - 1 or left > right:
        raise ValueError("Invalid range for range_sum")
    return prefix[right + 1] - prefix[left]
