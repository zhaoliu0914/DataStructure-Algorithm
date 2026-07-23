"""
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.


Example 1:
Input: nums = [1, 2, 3, 4]
Output: [24, 12, 8, 6]

Example 2:
Input: nums = [-1, 1, 0, -3, 3]
Output: [0, 0, 9, 0, 0]

Constraints:
2 <= nums.length <= 105
-30 <= nums[i] <= 30
The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.

Follow up:
Can you solve the problem in O(1) extra space complexity?
(The output array does not count as extra space for space complexity analysis.)
"""


def productExceptSelf(nums: list[int]) -> list[int]:
    size = len(nums)
    prefix_array = [1] * size
    suffix_array = [1] * size
    answer = [1] * size

    for i in range(1, size):
        prefix_array[i] = prefix_array[i - 1] * nums[i - 1]
    for i in range(size - 2, -1, -1):
        suffix_array[i] = suffix_array[i + 1] * nums[i + 1]

    for i in range(size):
        answer[i] = prefix_array[i] * suffix_array[i]

    return answer

if __name__ == '__main__':
    nums = [1, 2, 3, 4]
    answer = productExceptSelf(nums)
    print(f"nums = {nums}, answer = {answer}")

    nums = [-1, 1, 0, -3, 3]
    answer = productExceptSelf(nums)
    print(f"nums = {nums}, answer = {answer}")

