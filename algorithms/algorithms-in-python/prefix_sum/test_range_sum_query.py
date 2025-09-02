from expects import equal, expect

from prefix_sum.range_sum_query import NumArray

## Solutions
# https://leetcode.com/problems/range-sum-query-immutable/solutions/7050842/prefix-sum-range-sum-query-python-java-t-c8rr/


def test_sum_range() -> None:
    numArray = NumArray([-2, 0, 3, -5, 2, -1])

    result = numArray.sum_range(0, 2)

    expect(result).to(equal(1))

def test_sum_range_2() -> None:
    numArray = NumArray([-2, 0, 3, -5, 2, -1])

    result = numArray.sum_range(2, 5)

    expect(result).to(equal(-1))

def test_sum_range_improved() -> None:
    numArray = NumArray([-2, 0, 3, -5, 2, -1])

    result = numArray.sum_range_improved(0, 2)

    expect(result).to(equal(1))