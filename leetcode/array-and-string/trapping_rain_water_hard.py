"""
Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it can trap after raining.


Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
In this case, 6 units of rain water (blue section) are being trapped.

Example 2:
Input: height = [4,2,0,3,2,5]
Output: 9

Constraints:
n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
"""


def trap(height: list[int]) -> int:
    size = len(height)
    if size == 0:
        return 0

    left_max = [0] * size
    right_max = [0] * size

    left_max[0] = height[0]
    for i in range(1, size):
        left_max[i] = max(left_max[i - 1], height[i])

    print(f"left_max = {left_max}")

    right_max[size - 1] = height[size - 1]
    for i in range(size - 2, -1, -1):
        right_max[i] = max(right_max[i + 1], height[i])

    print(f"right_max = {right_max}")

    sum = 0
    for i in range(size):
        smallest_wall = min(left_max[i], right_max[i])
        sum += smallest_wall - height[i]
    return sum


if __name__ == '__main__':
    height = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
    result = trap(height)
    print(f"height = {height}, result = {result}")

    height = [4, 2, 0, 3, 2, 5]
    result = trap(height)
    print(f"height = {height}, result = {result}")
