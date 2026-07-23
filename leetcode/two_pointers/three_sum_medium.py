"""
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.


Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Example 2:
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Example 3:
Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.


Constraints:
3 <= nums.length <= 3000
-105 <= nums[i] <= 105
"""


def threeSum(nums: list[int]) -> list[list[int]]:
    nums.sort()
    size = len(nums)
    result = []
    for index in range(size - 2):
        if nums[index] > 0:
            break
        if index > 0 and nums[index] == nums[index - 1]:
            continue
        left = index + 1
        right = size - 1
        while left < right:
            sum = nums[index] + nums[left] + nums[right]
            if sum < 0:
                left += 1
            elif sum > 0:
                right -= 1
            else:
                result.append([nums[index], nums[left], nums[right]])
                left += 1
                right -= 1
                while left < right and nums[left] == nums[left - 1]:
                    left += 1
    return result


if __name__ == '__main__':
    nums = [-1, 0, 1, 2, -1, -4]
    result = threeSum(nums)
    print(f"nums = {nums}, result = {result}")

    nums = [0, 1, 1]
    result = threeSum(nums)
    print(f"nums = {nums}, result = {result}")

    nums = [0, 0, 0]
    result = threeSum(nums)
    print(f"nums = {nums}, result = {result}")

    nums = [0, 0, 0, 0]
    result = threeSum(nums)
    print(f"nums = {nums}, result = {result}")

    nums = [1, 2, 0, 1, 0, 0, 0, 0]
    result = threeSum(nums)
    print(f"nums = {nums}, result = {result}")
