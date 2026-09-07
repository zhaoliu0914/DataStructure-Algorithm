"""
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
DO NOT allocate another 2D matrix and do the rotation.


Example 1:
Input: matrix = [[1,2,3],
                 [4,5,6],
                 [7,8,9]]
Output: [[7,4,1],
         [8,5,2],
         [9,6,3]]

Example 2:
Input: matrix = [[5,1,9,11],
                 [2,4,8,10],
                 [13,3,6,7],
                 [15,14,12,16]]
Output: [[15,13,2,5],
         [14,3,4,1],
         [12,6,8,9],
         [16,7,10,11]]


Constraints:
n == matrix.length == matrix[i].length
1 <= n <= 20
-1000 <= matrix[i][j] <= 1000

"""

def rotate(matrix: list[list[int]]) -> None:
    new_matrix = []
    size = len(matrix)
    array_length = len(matrix[0])
    for i in range(size):
        new_array = [0] * array_length
        new_matrix.append(new_array)
    print(f"new_matrix = {new_matrix}")
    # there should be mapping
    # take 3*3 matrix as an example:
    # [0,0] -> [0,2]
    # [0,1] -> [1,2]
    # [0,2] -> [2,2]
    # [1,0] -> [0,1]
    # [1,1] -> [1,1]
    # [1,2] -> [2,1]
    # [2,0] -> [0,0]
    # [2,1] -> [1,0]
    # [2,2] -> [2,0]

    # There is a pattern, which we can switch 2 elements in one operation.
    for index in range(size - 1, -1, -1):
        print(f"size = {size}, index = {index}")
        for i in range(array_length):
            new_matrix[i][index - 1] = matrix[size - index - 1][i]
    print(f"new_matrix = {new_matrix}")


if __name__ == "__main__":
    matrix = [[1, 2, 3],
              [4, 5, 6],
              [7, 8, 9]]
    rotate(matrix)
    print(f"matrix = {matrix}")

    matrix = [[5, 1, 9, 11],
              [2, 4, 8, 10],
              [13, 3, 6, 7],
              [15, 14, 12, 16]]
    rotate(matrix)
    print(f"matrix = {matrix}")
