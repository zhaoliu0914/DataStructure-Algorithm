"""
You are given a string s and an array of strings words. All the strings of words are of the same length.
A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.
For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings.
"acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.
Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.


Example 1:
Input: s = "barfoothefoobarman", words = ["foo","bar"]
Output: [0,9]
Explanation:
The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.

Example 2:
Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
Output: []
Explanation:
There is no concatenated substring.

Example 3:
Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
Output: [6,9,12]
Explanation:
The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"].
The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"].
The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"].


Constraints:
1 <= s.length <= 104
1 <= words.length <= 5000
1 <= words[i].length <= 30
s and words[i] consist of lowercase English letters.
"""


def findSubstring(s: str, words: list[str]) -> list[int]:
    size = len(words[0])
    init_map = {}
    for word in words:
        if word in init_map:
            init_map[word] = init_map[word] + 1
        else:
            init_map[word] = 1
    result = []
    left = 0
    while left < len(s):
        right = left
        matched = init_map.copy()
        current = s[right: right + size]
        while right < len(s) and right < (left + len(words) * size) and current in words:
            current = s[right: right + size]
            # print(f"right = {right}, current = {current}, matched = {matched}")
            if current not in matched:
                break
            elif current in matched and matched[current] == 0:
                break
            else:
                matched[current] = matched[current] - 1
            numbers = matched.values()
            is_match_all = True
            for n in numbers:
                if n != 0:
                    is_match_all = False
            if is_match_all:
                result.append(left)
            right += size
        left += 1
    return result


if __name__ == '__main__':
    s = "barfoothefoobarman"
    words = ["foo", "bar"]
    result = findSubstring(s, words)
    print(f"s = {s}, words = {words}, result = {result}")

    s = "wordgoodgoodgoodbestword"
    words = ["word", "good", "best", "word"]
    result = findSubstring(s, words)
    print(f"s = {s}, words = {words}, result = {result}")

    s = "barfoofoobarthefoobarman"
    words = ["bar", "foo", "the"]
    result = findSubstring(s, words)
    print(f"s = {s}, words = {words}, result = {result}")

    s = "wordgoodgoodgoodbestword"
    words = ["word", "good", "best", "good"]
    result = findSubstring(s, words)
    print(f"s = {s}, words = {words}, result = {result}")

    s = "lingmindraboofooowingdingbarrwingmonkeypoundcake"
    words = ["fooo", "barr", "wing", "ding", "wing"]
    result = findSubstring(s, words)
    print(f"s = {s}, words = {words}, result = {result}")
