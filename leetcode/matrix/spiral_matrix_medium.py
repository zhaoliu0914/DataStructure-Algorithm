"""
Given an m x n matrix, return all elements of the matrix in spiral order.


Example 1:
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]


Constraints:
m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
"""


def spiralOrder(matrix: list[list[int]]) -> list[int]:
    result = []

    top = 0
    bottom = len(matrix) - 1
    left = 0
    right = len(matrix[0]) - 1
    print(f"top = {top}, bottom = {bottom}, left = {left}, right = {right}")
    # loop first array, then last element of every array, then loop last array from the last element to the first element,
    # then first element of every array except the first array,
    # It may also need an indicate to show the boundary.
    # It also requires an indicate to find out the level.

    while top <= bottom and left <= right:

        # from left --> right
        for column in range(left, right + 1):
            result.append(matrix[top][column])
        top += 1

        # from top --> bottom
        for row in range(top, bottom + 1):
            result.append(matrix[row][right])
        right -= 1

        # from right --> left
        if top <= bottom:
            for column in range(right, left - 1, -1):
                print(f"bottom = {bottom}, column = {column}")
                result.append(matrix[bottom][column])
            bottom -= 1

        if left <= right:
            for row in range(bottom, top - 1, -1):
                result.append(matrix[row][left])
            left += 1

    return result


if __name__ == '__main__':
    matrix = [[1, 2, 3],
              [4, 5, 6],
              [7, 8, 9]]
    result = spiralOrder(matrix)
    print(f"result = {result}")

    matrix = [[1, 2, 3, 4],
              [5, 6, 7, 8],
              [9, 10, 11, 12]]
    result = spiralOrder(matrix)
    print(f"result = {result}")
