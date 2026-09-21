"""
According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0).
Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state of the board is determined by applying the above rules simultaneously to every cell in the current state of the m x n grid board.
In this process, births and deaths occur simultaneously.

Given the current state of the board, update the board to reflect its next state.

Note that you do not need to return anything.


Example 1:
Input: board = [[0, 1, 0],
                [0, 0, 1],
                [1, 1, 1],
                [0, 0, 0]]
Output: [[0, 0, 0],
         [1, 0, 1],
         [0, 1, 1],
         [0, 1, 0]]

Example 2:
Input: board = [[1, 1],
                [1, 0]]
Output: [[1, 1],
         [1, 1]]


Constraints:
m == board.length
n == board[i].length
1 <= m, n <= 25
board[i][j] is 0 or 1.
"""


def gameOfLife(board: list[list[int]]) -> None:
    # Every cell's next state is based only on the current states of its neighbors, never on a neighbor's next state.
    size = len(board)
    array_size = len(board[0])

    # need to determine the current state of neighbors from left, right, top, bottom, top-left, top-right, bottom-right, bottom-left.
    for i in range(size):
        for j in range(array_size):
            live = 0

            # access 8 neights:
            for ni in (-1, 0, 1):
                for nj in (-1, 0, 1):
                    # this point is board[i][j] itself.
                    if ni == 0 and nj == 0:
                        continue
                    neight_i = i + ni
                    neight_j = j + nj

                    # consider the edge cases
                    if 0 <= neight_i < size and 0 <= neight_j < array_size:
                        if board[neight_i][neight_j] == 1:
                            live += 1

                            print(f"board[{i}][{j}] = {board[i][j]}, neight_i = {neight_i}, neight_j = {neight_j}, live = {live}")

            # print(f"board[{i}][{j}] = {board[i][j]}, live = {live}")
            # if board[i][j] == 1:
            #     if live < 2 or live > 3:
            #         board[i][j] = 0
            # else:
            #     if live == 3:
            #         board[i][j] = 1


if __name__ == "__main__":
    board = [[0, 1, 0],
             [0, 0, 1],
             [1, 1, 1],
             [0, 0, 0]]
    print(f"original board = {board}")
    gameOfLife(board)
    print(f"board = {board}")

    # board = [[1, 1],
    #          [1, 0]]
    # print(f"original board = {board}")
    # gameOfLife(board)
    # print(f"board = {board}")
