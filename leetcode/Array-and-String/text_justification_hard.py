"""
Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
Extra spaces between words should be distributed as evenly as possible.
If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left-justified, and no extra space is inserted between words.

Note:
A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.


Example 1:
Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]

Example 2:
Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
Note that the second line is also left-justified because it contains only one word.

Example 3:
Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]


Constraints:
1 <= words.length <= 300
1 <= words[i].length <= 20
words[i] consists of only English letters and symbols.
1 <= maxWidth <= 100
words[i].length <= maxWidth
"""


def fullJustify(words: list[str], maxWidth: int) -> list[str]:
    size = len(words)
    index = 0
    line = 0
    justified = []
    line_content = []
    count = 0
    while index < size:
        current = words[index]
        count += len(current)
        if len(line_content) > 0:
            count += 1

        if count <= maxWidth:
            line_content.append(current)
            index += 1
        else:
            if len(line_content) == 1:
                justified.append(line_content[0])
                for i in range(maxWidth - len(line_content[0])):
                    justified[line] += " "
            else:
                line_count = 0
                for c in line_content:
                    line_count += len(c)
                space = (maxWidth - line_count) // (len(line_content) - 1)
                extra_space = (maxWidth - line_count) % (len(line_content) - 1)
                #print(f"maxWidth = {maxWidth}, line_count = {line_count}, space = {space}, extra_space = {extra_space}")

                for i, c in enumerate(line_content):
                    if i == 0:
                        justified.append(c)

                    elif i > 0:
                        if extra_space > 0:
                            for j in range(space + 1):
                                justified[line] += " "
                            extra_space -= 1
                        else:
                            for j in range(space):
                                justified[line] += " "
                        justified[line] += c

            line += 1
            count = 0
            line_content = []
    if len(line_content) == 1:
        justified.append(line_content[0])
        for i in range(maxWidth - len(line_content[0])):
            justified[line] += " "
    else:
        line_count = 0
        for c in line_content:
            line_count += len(c)
        remain_space = maxWidth - line_count
        #print(f"maxWidth = {maxWidth}, line_count = {line_count}, remain_space = {remain_space}")

        for i, c in enumerate(line_content):
            if i == 0:
                justified.append(c)
            elif i == (len(line_content) - 1):
                justified[line] += " "
                justified[line] += c
                for j in range(remain_space - 1):
                    justified[line] += " "
            elif i > 0:
                justified[line] += " "
                justified[line] += c
                remain_space -= 1
    return justified



if __name__ == '__main__':
    words = ["This", "is", "an", "example", "of", "text", "justification."]
    maxWidth = 16
    justified = fullJustify(words, maxWidth)
    print(f"words = {words}, maxWidth = {maxWidth}, justified = {justified}")

    words = ["What", "must", "be", "acknowledgment", "shall", "be"]
    maxWidth = 16
    justified = fullJustify(words, maxWidth)
    print(f"words = {words}, maxWidth = {maxWidth}, justified = {justified}")

    words = ["Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"]
    maxWidth = 20
    justified = fullJustify(words, maxWidth)
    print(f"words = {words}, maxWidth = {maxWidth}, justified = {justified}")

    words = ["ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"]
    maxWidth = 16
    justified = fullJustify(words, maxWidth)
    print(f"words = {words}, maxWidth = {maxWidth}, justified = {justified}")

    words = ["My","momma","always","said,","\"Life","was","like","a","box","of","chocolates.","You","never","know","what","you're","gonna","get."]
    maxWidth = 20
    justified = fullJustify(words, maxWidth)
    print(f"words = {words}, maxWidth = {maxWidth}, justified = {justified}")
