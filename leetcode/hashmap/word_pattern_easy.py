"""
Given a pattern and a string s, find if s follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

Specifically:
Each letter in pattern maps to exactly one unique word in s.
Each unique word in s maps to exactly one letter in pattern.
No two letters map to the same word, and no two words map to the same letter.


Example 1:
Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Explanation:
The bijection can be established as:
'a' maps to "dog".
'b' maps to "cat".

Example 2:
Input: pattern = "abba", s = "dog cat cat fish"
Output: false

Example 3:
Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false


Constraints:
1 <= pattern.length <= 300
pattern contains only lower-case English letters.
1 <= s.length <= 3000
s contains only lowercase English letters and spaces ' '.
s does not contain any leading or trailing spaces.
All the words in s are separated by a single space.
"""


def wordPattern(pattern: str, s: str) -> bool:
    s_array = s.split()

    if len(pattern) != len(s_array):
        return False

    left_to_right_map = dict()
    right_to_left_map = dict()

    

    index = 0
    while index < len(pattern):
        left = pattern[index]
        right = s_array[index]

        if left_to_right_map.get(left, right) != right or right_to_left_map.get(right, left) != left:
            return False

        left_to_right_map[left] = right
        right_to_left_map[right] = left

        index += 1

    return True


if __name__ == "__main__":
    pattern = "abba"
    s = "dog cat cat dog"
    result = wordPattern(pattern, s)
    print(f"pattern = {pattern}, s = {s}, result = {result}")

    pattern = "abba"
    s = "dog cat cat fish"
    result = wordPattern(pattern, s)
    print(f"pattern = {pattern}, s = {s}, result = {result}")

    pattern = "aaaa"
    s = "dog cat cat dog"
    result = wordPattern(pattern, s)
    print(f"pattern = {pattern}, s = {s}, result = {result}")
