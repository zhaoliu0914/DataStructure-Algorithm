"""
Given a string s consisting of words and spaces, return the length of the last word in the string.
A word is a maximal substring consisting of non-space characters only.


Example 1:
Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.

Example 2:
Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.

Example 3:
Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.


Constraints:
1 <= s.length <= 104
s consists of only English letters and spaces ' '.
There will be at least one word in s.
"""


def lengthOfLastWord(s: str) -> int:
    size = len(s)
    last_word = []
    is_last_word = False
    for i in range(size - 1, -1, -1):
        current_char = s[i]
        #print(f"i = {i}, is_last_word = {is_last_word}, current_char = {current_char}")
        if current_char == " ":
            if is_last_word:
                break
        else:
            is_last_word = True
            last_word.append(current_char)
    return len(last_word)


if __name__ == '__main__':
    s = "Hello World"
    last_word_length = lengthOfLastWord(s)
    print(f"s = {s}, last_word_length = {last_word_length}")

    s = "   fly me   to   the moon  "
    last_word_length = lengthOfLastWord(s)
    print(f"s = {s}, last_word_length = {last_word_length}")

    s = "luffy is still joyboy"
    last_word_length = lengthOfLastWord(s)
    print(f"s = {s}, last_word_length = {last_word_length}")

    s = "job"
    last_word_length = lengthOfLastWord(s)
    print(f"s = {s}, last_word_length = {last_word_length}")
