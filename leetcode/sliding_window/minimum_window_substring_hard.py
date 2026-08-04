"""
Given two strings s and t of lengths m and n respectively,
return the minimum window substring of s such that every character in t (including duplicates) is included in the window.
If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.


Example 1:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

Example 2:
Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.

Example 3:
Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.


Constraints:
m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.
"""


def minWindow(s: str, t: str) -> str:
    m = len(s)
    n = len(t)

    if m < n:
        return ""

    need = {}
    for char in t:
        need[char] = need.get(char, 0) + 1

    left = 0
    start = 0
    missing = len(t)
    min_len = float("inf")
    for right, char in enumerate(s):
        if char in need:
            if need[char] > 0:
                missing -= 1
            need[char] -= 1

        while missing == 0:
            if right - left + 1 < min_len:
                min_len = right - left + 1
                start = left

            left_char = s[left]
            if left_char in need:
                need[left_char] += 1
                if need[left_char] > 0:
                    missing += 1

            left += 1
            #print(f"right = {right}, current_char = {char}, left_char = {left_char}, left = {left}")

    if min_len == float("inf"):
        return ""
    return s[start: start + min_len]


if __name__ == '__main__':
    s = "ADOBECODEBANC"
    t = "ABC"
    result = minWindow(s, t)
    print(f"s = {s}, t = {t}, result = {result}")

    s = "a"
    t = "a"
    result = minWindow(s, t)
    print(f"s = {s}, t = {t}, result = {result}")

    s = "a"
    t = "aa"
    result = minWindow(s, t)
    print(f"s = {s}, t = {t}, result = {result}")
