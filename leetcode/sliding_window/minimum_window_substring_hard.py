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
    count = 0
    result = []
    matched = {}
    for right, char in enumerate(s):

        if char not in need:
            continue

        matched[char] = matched.get(char, 0) + 1
        count += 1

        while matched[char] > need[char]:
            left += 1
            temp = s[left]
            if temp not in need:
                continue
            elif temp in need and temp != char:
                count -= 1
                continue
            else:
                count -= 1
                matched[temp] -= 1

        if count == n:
            result.append(s[left: right + 1])

    #return min(result)


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
