"""
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".


Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.


Constraints:
1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters if it is non-empty.
"""


def longestCommonPrefix(strs: list[str]) -> str:
    size = len(strs)
    smallest_len = 100000
    for i in range(size):
        length = len(strs[i])
        if length < smallest_len:
            smallest_len = length
    index = 0
    is_continue = True
    prefix = ""
    while index < smallest_len:
        current_char = strs[0][index]
        for i in range(1, size):
            if current_char != strs[i][index]:
                is_continue = False
                break

        index += 1
        if is_continue == False:
            break
        prefix = f"{prefix}{current_char}"
    return prefix


if __name__ == '__main__':
    strs = ["flower", "flow", "flight"]
    prefix = longestCommonPrefix(strs)
    print(f"strs = {strs}, prefix = {prefix}")

    strs = ["dog", "racecar", "car"]
    prefix = longestCommonPrefix(strs)
    print(f"strs = {strs}, prefix = {prefix}")

    strs = [""]
    prefix = longestCommonPrefix(strs)
    print(f"strs = {strs}, prefix = {prefix}")
