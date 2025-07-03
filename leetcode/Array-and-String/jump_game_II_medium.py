"""
You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
Each element nums[i] represents the maximum length of a forward jump from index i.
In other words, if you are at nums[i], you can jump to any nums[i + j] where:

0 <= j <= nums[i]
and
i + j < n
Return the minimum number of jumps to reach nums[n - 1].
The test cases are generated such that you can reach nums[n - 1].

Example 1:
Input: nums = [2, 3, 1, 1, 4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [2, 3, 0, 1, 4]
Output: 2

Constraints:
1 <= nums.length <= 10^4
0 <= nums[i] <= 1000
It's guaranteed that you can reach nums[n - 1].
"""
import sys


def jump(nums: list[int]) -> int:
    size = len(nums)
    target = size - 1

    if size == 1:
        return 0
    if nums[0] >= size - 1:
        return 1

    step_list = []
    index = 0
    while index <= target - 1:
        temp_max = sys.maxsize * -1
        step = 0
        for i in range(index + 1, index + nums[index] + 1):
            if i < size and nums[i] >= temp_max:
                step += 1
                temp_max = nums[i]
        step_list.append(step)
        index = index + step

    return len(step_list)


if __name__ == '__main__':
    nums = [2, 3, 1, 1, 4]
    result = jump(nums)
    print(f"nums = {nums}, result = {result}")

    nums = [2, 3, 0, 1, 4]
    result = jump(nums)
    print(f"nums = {nums}, result = {result}")

    nums = [4, 3, 0, 2, 0, 1, 4]
    result = jump(nums)
    print(f"nums = {nums}, result = {result}")

    nums = [2, 3, 3, 2, 4, 1, 4, 5]  # 3 # 4
    result = jump(nums)
    print(f"nums = {nums}, result = {result}")

    nums = [3, 2, 1]
    result = jump(nums)
    print(f"nums = {nums}, result = {result}")

    nums = [3, 4, 3, 2, 5, 4, 3]
    result = jump(nums)
    print(f"nums = {nums}, result = {result}")
