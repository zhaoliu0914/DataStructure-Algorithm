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
    if len(s) != len(t):
        return False

    s_map = dict()
    t_map = dict()

    for element in s:
        s_map[element] = s_map.get(element, 0) + 1
    for element in t:
        t_map[element] = t_map.get(element, 0) + 1

    if len(s_map) != len(t_map):
        return False

    for element in s_map:
        value = s_map[element]
        if t_map.get(element, 0) != value:
            return False

    return True


if __name__ == "__main__":
    s ="anagram"
    t ="nagaram"
    result = isAnagram(s, t)
    print(f"s = {s}, t = {t}, result = {result}")

    s ="rat"
    t ="car"
    result = isAnagram(s, t)
    print(f"s = {s}, t = {t}, result = {result}")