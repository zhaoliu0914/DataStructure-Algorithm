"""
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.


Example 1:
Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.

Example 2:
Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.


Constraints:
1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.
"""


def strStr(haystack: str, needle: str) -> int:
    size = len(haystack)
    current = 0
    while current < size:
        if haystack[current] == needle[0]:
            is_matched = True
            for i in range(1, len(needle)):
                if (current+i) >= size or haystack[current+i] != needle[i]:
                    is_matched = False
                    break
            if is_matched:
                return current
        current += 1
    return -1


if __name__ == '__main__':
    # haystack = "sadbutsad"
    # needle = "sad"
    # index = strStr(haystack, needle)
    # print(f"haystack = {haystack}, needle = {needle}, index = {index}")
    #
    # haystack = "leetcode"
    # needle = "leeto"
    # index = strStr(haystack, needle)
    # print(f"haystack = {haystack}, needle = {needle}, index = {index}")
    #
    # haystack = "mississippi"
    # needle = "issip"
    # index = strStr(haystack, needle)
    # print(f"haystack = {haystack}, needle = {needle}, index = {index}")

    haystack = "aaa"
    needle = "aaaa"
    index = strStr(haystack, needle)
    print(f"haystack = {haystack}, needle = {needle}, index = {index}")
