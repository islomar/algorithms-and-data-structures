import pytest
from expects import expect, equal

from prefix_sum.subarray_sum_equals_k import subarray_sum_equals_k

testdata = [
    ([1, 1, 1], 2, 2),
    ([1, 2, 3], 3, 2),
    ([1, -1, 0], 0, 3),
]

@pytest.mark.parametrize("nums, k, expected", testdata)
def test_subarray_sum_equals_k(nums, k, expected) -> None:
    result = subarray_sum_equals_k(nums, k)

    expect(result).to(equal(expected))
