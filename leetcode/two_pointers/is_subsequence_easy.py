"""
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters
without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).


Example 1:
Input: s = "abc", t = "ahbgdc"
Output: true

Example 2:
Input: s = "axc", t = "ahbgdc"
Output: false


Constraints:
0 <= s.length <= 100
0 <= t.length <= 104
s and t consist only of lowercase English letters.
"""


def isSubsequence(s: str, t: str) -> bool:
    s_size = len(s)
    t_size = len(t)
    s_index = 0
    t_index = 0
    while s_index < s_size and t_index < t_size:
        while s[s_index] != t[t_index]:
            if t_index < (t_size - 1):
                t_index += 1
            else:
                return False
        s_index += 1
        t_index += 1

    if s_index != s_size:
        return False
    else:
        return True

if __name__ == '__main__':
    s = "abc"
    t = "ahbgdc"
    result = isSubsequence(s, t)
    print(f"s = {s}, t = {t}, result = {result}")

    s = "axc"
    t = "ahbgdc"
    result = isSubsequence(s, t)
    print(f"s = {s}, t = {t}, result = {result}")

    s = "b"
    t = "c"
    result = isSubsequence(s, t)
    print(f"s = {s}, t = {t}, result = {result}")

    s = "abc"
    t = ""
    result = isSubsequence(s, t)
    print(f"s = {s}, t = {t}, result = {result}")

    s = "aaaaaa"
    t = "bbaaaa"
    result = isSubsequence(s, t)
    print(f"s = {s}, t = {t}, result = {result}")

    s = "bb"
    t = "ahbgdc"
    result = isSubsequence(s, t)
    print(f"s = {s}, t = {t}, result = {result}")

    s = "abc"
    t = "acb"
    result = isSubsequence(s, t)
    print(f"s = {s}, t = {t}, result = {result}")