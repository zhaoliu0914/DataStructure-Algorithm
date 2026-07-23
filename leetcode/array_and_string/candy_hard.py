"""
There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.


Example 1:
Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.

Example 2:
Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
The third child gets 1 candy because it satisfies the above two conditions.


Constraints:
n == ratings.length
1 <= n <= 2 * 104
0 <= ratings[i] <= 2 * 104
"""


def candy(ratings: list[int]) -> int:
    size = len(ratings)
    values = [1] * size

    for i in range(1, size):
        if ratings[i] > ratings[i - 1]:
            values[i] = values[i - 1] + 1

    for i in range(size - 2, -1, -1):
        if ratings[i] > ratings[i + 1]:
            values[i] = max(values[i], values[i + 1] + 1)

    return sum(values)


if __name__ == '__main__':
    ratings = [1, 0, 2]
    result = candy(ratings)
    print(f"ratings = {ratings}, result = {result}")

    ratings = [1, 2, 2]
    result = candy(ratings)
    print(f"ratings = {ratings}, result = {result}")

    ratings = [1, 3, 2, 2, 1]
    result = candy(ratings)
    print(f"ratings = {ratings}, result = {result}")

    ratings = [1, 3, 2, 2, 3]
    result = candy(ratings)
    print(f"ratings = {ratings}, result = {result}")

    ratings = [1, 5, 4, 3, 2, 1]
    result = candy(ratings)
    print(f"ratings = {ratings}, result = {result}")