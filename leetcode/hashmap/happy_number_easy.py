"""
Write an algorithm to determine if a number n is happy.
A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.


Example 1:
Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

Example 2:
Input: n = 2
Output: false


Constraints:
1 <= n <= 231 - 1
"""


def isHappy(n: int) -> bool:
    if n == 1:
        return True
    
    visited_set = set()
    while n != 1:
        #print(f"n = {n}, visited_set = {visited_set}")
        if n in visited_set:
            return False

        visited_set.add(n)

        total = 0
        while n > 0:
            num = n % 10
            total = total + num * num
            n = n // 10

        if total == 1:
            return True
        n = total


if __name__ == "__main__":
    # n = 19
    # result = isHappy(n)
    # print(f"n = {n}, result = {result}")

    n = 2
    result = isHappy(n)
    print(f"n = {n}, result = {result}")
