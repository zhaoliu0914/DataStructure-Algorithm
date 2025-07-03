"""
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

Constraints:
1 <= nums.length <= 10^5
-2^31 <= nums[i] <= 2^31 - 1
0 <= k <= 10^5

Follow up:
Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space?
"""


def rotate(nums: list[int], k: int) -> None:
    """
    Do not return anything, modify nums in-place instead.
    """
    size = len(nums)
    edge = size - (k % size)

    # Reverse part 1
    for i in range(edge // 2):
        temp = nums[i]
        nums[i] = nums[edge - 1 - i]
        nums[edge - 1 - i] = temp
    # print(f"nums = {nums}")

    # Reverse part 2
    for i in range((size - edge) // 2):
        temp = nums[edge + i]
        nums[edge + i] = nums[size - 1 - i]
        nums[size - 1 - i] = temp
    # print(f"nums = {nums}")

    # Reverse entire array
    for i in range(size // 2):
        temp = nums[i]
        nums[i] = nums[size - 1 - i]
        nums[size - 1 - i] = temp
    # print(f"nums = {nums}")


if __name__ == '__main__':
    nums = [1, 2, 3, 4, 5, 6, 7]
    k = 3
    rotate(nums, k)

    nums = [-1,-100,3,99]
    k = 2
    rotate(nums, k)
