"""
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters,
it reads the same forward and backward. Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.


Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.


Constraints:
1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
"""


def isPalindrome(s: str) -> bool:
    size = len(s)
    forward = 0
    backword = size - 1
    while forward < backword and forward != backword:
        #print(f"forward = {forward}, backword = {backword}")
        while not s[forward].isalnum():
            forward += 1
            if forward == size:
                return True
        while not s[backword].isalnum():
            backword -= 1
            if backword < 0:
                return True

        print(f"forward = {forward}, backword = {backword}")
        if s[forward].lower() != s[backword].lower():
            return False
        forward += 1
        backword -= 1
    return True


if __name__ == '__main__':
    # s = "A man, a plan, a canal: Panama"
    # result = isPalindrome(s)
    # print(f"s = {s}, result = {result}")
    #
    # s = "race a car"
    # result = isPalindrome(s)
    # print(f"s = {s}, result = {result}")
    #
    # s = " "
    # result = isPalindrome(s)
    # print(f"s = {s}, result = {result}")
    #
    # s = ".,"
    # result = isPalindrome(s)
    # print(f"s = {s}, result = {result}")

    s = "0P"
    result = isPalindrome(s)
    print(f"s = {s}, result = {result}")