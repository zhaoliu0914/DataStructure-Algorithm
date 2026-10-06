"""
Given two strings s and t, return true if t is an anagram of s, and false otherwise.


Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false


Constraints:
1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.


Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
"""


def isAnagram(s: str, t: str) -> bool:
    pass


if __name__ == "__main__":
    s ="anagram"
    t ="nagaram"
    result = isAnagram(s, t)
    print(f"s = {s}, t = {t}, result = {result}")

    s ="rat"
    t ="car"
    result = isAnagram(s, t)
    print(f"s = {s}, t = {t}, result = {result}")