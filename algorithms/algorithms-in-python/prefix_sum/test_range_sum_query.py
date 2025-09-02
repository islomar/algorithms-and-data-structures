from prefix_sum.range_sum_query import build_prefix_sum, range_sum


def test_range_sum_entire_array():
    nums = [1, 2, 3, 4]
    prefix = build_prefix_sum(nums)
    assert range_sum(prefix, 0, 3) == 10
