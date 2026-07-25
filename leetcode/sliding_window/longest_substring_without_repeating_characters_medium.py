"""
Given a string s, find the length of the longest substring without duplicate characters.


Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


Constraints:
0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
"""


def lengthOfLongestSubstring(s: str) -> int:
    left = 0
    length = 0
    substring = {}
    for index, value in enumerate(s):
        if value in substring and substring[value] >= left:
            left = substring[value] + 1
        length = max(length, index - left + 1)
        substring[value] = index
    return length


if __name__ == '__main__':
    s = "abcabcbb"
    length = lengthOfLongestSubstring(s)
    print(f"s = {s}, length = {length}")

    s = "bbbbb"
    length = lengthOfLongestSubstring(s)
    print(f"s = {s}, length = {length}")

    s = "aab"
    length = lengthOfLongestSubstring(s)
    print(f"s = {s}, length = {length}")

    s = "pwwkew"
    length = lengthOfLongestSubstring(s)
    print(f"s = {s}, length = {length}")

    s = "dvdf"
    length = lengthOfLongestSubstring(s)
    print(f"s = {s}, length = {length}")

    s = "abba"
    length = lengthOfLongestSubstring(s)
    print(f"s = {s}, length = {length}")
