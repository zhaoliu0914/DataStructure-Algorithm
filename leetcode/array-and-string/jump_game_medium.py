"""
You are given an integer array nums.
You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
Return true if you can reach the last index, or false otherwise.

Example 1:
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what.
Its maximum jump length is 0, which makes it impossible to reach the last index.

Constraints:
1 <= nums.length <= 10^4
0 <= nums[i] <= 10^5
"""


def can_jump(nums: list[int]) -> bool:
    size = len(nums)
    if size <= 1:
        return True

    failure_value = 0
    index = size - 2
    while index >= 0:
        if nums[index] == 0:
            failure_value += 1
        else:
            if nums[index] <= failure_value:
                failure_value += 1
            else:
                failure_value = 0
        index -= 1

    if failure_value == 0:
        return True
    else:
        return False


if __name__ == '__main__':
    nums = [2, 3, 1, 1, 4]
    result = can_jump(nums)
    print(f"nums = {nums}, result = {result}")

    nums = [3, 2, 1, 0, 4]
    result = can_jump(nums)
    print(f"nums = {nums}, result = {result}")

    nums = [2, 0]
    result = can_jump(nums)
    print(f"nums = {nums}, result = {result}")

    nums = [2, 0, 0]
    result = can_jump(nums)
    print(f"nums = {nums}, result = {result}")

    nums = [1, 1, 0, 1]
    result = can_jump(nums)
    print(f"nums = {nums}, result = {result}")

    nums = [1, 0, 1, 0]
    result = can_jump(nums)
    print(f"nums = {nums}, result = {result}")

    nums = [0, 1]
    result = can_jump(nums)
    print(f"nums = {nums}, result = {result}")
