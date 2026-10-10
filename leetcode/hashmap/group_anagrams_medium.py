"""
Given an array of strings strs, group the anagrams together. You can return the answer in any order.


Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Explanation:
There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

Example 2:
Input: strs = [""]
Output: [[""]]

Example 3:
Input: strs = ["a"]
Output: [["a"]]


Constraints:
1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.
"""

from collections import defaultdict


def groupAnagrams(strs: list[str]) -> list[list[str]]:
    if len(strs) == 1:
        return [strs]

    word_map = dict()
    for str in strs:
        char_array = [0] * 26
        for char in str:
            index = ord(char) - ord('a') 
            char_array[index] += 1
        # print(f"str = {str}, char_array = {char_array}, word_map = {word_map}")
        char_array = tuple(char_array)
        if char_array in word_map:
            word_map[char_array].append(str)
        else:
            word_map[char_array] = [str]
    # print(f"word_map.values = {list(word_map.values())}")
    return list(word_map.values())


if __name__ == "__main__":
    strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    result = groupAnagrams(strs)
    print(f"strs = {strs}, result = {result}")

    strs = [""]
    result = groupAnagrams(strs)
    print(f"strs = {strs}, result = {result}")

    strs = ["a"]
    result = groupAnagrams(strs)
    print(f"strs = {strs}, result = {result}")

    strs = ["cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc"]
    result = groupAnagrams(strs)
    print(f"strs = {strs}, result = {result}")
