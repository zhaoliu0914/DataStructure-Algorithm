"""
Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target.
If there is no such subarray, return 0 instead.


Example 1:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Example 2:
Input: target = 4, nums = [1,4,4]
Output: 1

Example 3:
Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0


Constraints:
1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 104
"""


def minSubArrayLen(target: int, nums: list[int]) -> int:
    left = 0
    total = 0
    length = float("inf")

    for index, value in enumerate(nums):
        total += value
        while total >= target:
            length = min(length, index - left + 1)
            total -= nums[left]
            left += 1
    #print(f"left = {left}, index = {index}")
    if length == float("inf"):
        return 0
    else:
        return length


if __name__ == '__main__':
    target = 7
    nums = [2, 3, 1, 2, 4, 3]
    length = minSubArrayLen(target, nums)
    print(f"target = {target}, nums = {nums}, length = {length}")

    target = 4
    nums = [1, 4, 4]
    length = minSubArrayLen(target, nums)
    print(f"target = {target}, nums = {nums}, length = {length}")

    target = 11
    nums = [1, 1, 1, 1, 1, 1, 1, 1]
    length = minSubArrayLen(target, nums)
    print(f"target = {target}, nums = {nums}, length = {length}")

    target = 11
    nums = [1, 2, 3, 4, 5]
    length = minSubArrayLen(target, nums)
    print(f"target = {target}, nums = {nums}, length = {length}")
