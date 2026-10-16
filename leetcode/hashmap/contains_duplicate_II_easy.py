"""
Given an integer array nums and an integer k,
return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.


Example 1:
Input: nums = [1,2,3,1], k = 3
Output: true

Example 2:
Input: nums = [1,0,1,1], k = 1
Output: true

Example 3:
Input: nums = [1,2,3,1,2,3], k = 2
Output: false


Constraints:
1 <= nums.length <= 105
-109 <= nums[i] <= 109
0 <= k <= 105
"""


def containsNearbyDuplicate(nums: list[int], k: int) -> bool:
    for num in nums:
        pass


if __name__ == "__main__":
    nums = [1, 2, 3, 1]
    k = 3
    result = containsNearbyDuplicate(nums, k)
    print(f"nums = {nums}, k = {k}, result = {result}")

    nums = [1, 0, 1, 1]
    k = 1
    result = containsNearbyDuplicate(nums, k)
    print(f"nums = {nums}, k = {k}, result = {result}")

    nums = [1, 2, 3, 1, 2, 3]
    k = 2
    result = containsNearbyDuplicate(nums, k)
    print(f"nums = {nums}, k = {k}, result = {result}")
