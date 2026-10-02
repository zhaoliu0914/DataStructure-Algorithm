"""
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters.
No two characters may map to the same character, but a character may map to itself.


Example 1:
Input: s = "egg", t = "add"
Output: true
Explanation:
The strings s and t can be made identical by:
Mapping 'e' to 'a'.
Mapping 'g' to 'd'.

Example 2:
Input: s = "f11", t = "b23"
Output: false
Explanation:
The strings s and t can not be made identical as '1' needs to be mapped to both '2' and '3'.

Example 3:
Input: s = "paper", t = "title"
Output: true


Constraints:
1 <= s.length <= 5 * 104
t.length == s.length
s and t consist of any valid ascii character.
"""


def isIsomorphic(s: str, t: str) -> bool:
    if len(s) != len(t):
        return False

    index = 0
    size = len(s)
    s_to_t_map = dict()
    t_to_s_map = dict()
    while index < size:
        s_element = s[index]
        t_element = t[index]

        if s_to_t_map.get(s_element, t_element) != t_element or t_to_s_map.get(t_element, s_element) != s_element:
            return False
        s_to_t_map[s_element] = t_element
        t_to_s_map[t_element] = s_element

        index += 1

    return True


if __name__ == "__main__":
    s = "egg"
    t = "add"
    result = isIsomorphic(s, t)
    print(f"s = {s}, t = {t}, result = {result}")

    s = "foo"
    t = "bar"
    result = isIsomorphic(s, t)
    print(f"s = {s}, t = {t}, result = {result}")

    s = "paper"
    t = "title"
    result = isIsomorphic(s, t)
    print(f"s = {s}, t = {t}, result = {result}")

    s = "bbbaaaba"
    t = "aaabbbba"
    result = isIsomorphic(s, t)
    print(f"s = {s}, t = {t}, result = {result}")

    s = "badc"
    t = "baba"
    result = isIsomorphic(s, t)
    print(f"s = {s}, t = {t}, result = {result}")