"""
Given an input string s, reverse the order of the words.
A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
Return a string of the words in reverse order concatenated by a single space.
Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.


Example 1:
Input: s = "the sky is blue"
Output: "blue is sky the"

Example 2:
Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.

Example 3:
Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.


Constraints:
1 <= s.length <= 104
s contains English letters (upper-case and lower-case), digits, and spaces ' '.
There is at least one word in s.
"""


def reverseWords(s: str) -> str:
    size = len(s)
    reversed_word = ""
    last_char = ""
    current_word = []
    for i in range(size - 1, -1, -1):
        current_char = s[i]
        if current_char == " ":
            if last_char != " ":
                current_word.reverse()
                if reversed_word == "":
                    reversed_word = "".join(current_word)
                else:
                    reversed_word = f"{reversed_word} {''.join(current_word)}"
            current_word = []
        else:
            current_word.append(current_char)
        last_char = current_char
    if len(current_word) > 0:
        current_word.reverse()
        if reversed_word == "":
            reversed_word = "".join(current_word)
        else:
            reversed_word = f"{reversed_word} {''.join(current_word)}"
    return reversed_word


if __name__ == '__main__':
    # s = "the sky is blue"
    # reverse_s = reverseWords(s)
    # print(f"s = {s}, reverse_s = {reverse_s}")
    #
    # s = "  hello world  "
    # reverse_s = reverseWords(s)
    # print(f"s = {s}, reverse_s = {reverse_s}")
    #
    # s = "a good   example"
    # reverse_s = reverseWords(s)
    # print(f"s = {s}, reverse_s = {reverse_s}")
    #
    s = "EPY2giL"
    reverse_s = reverseWords(s)
    print(f"s = {s}, reverse_s = {reverse_s}")