"""
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.


Example 1:
Input: ransomNote = "a", magazine = "b"
Output: false

Example 2:
Input: ransomNote = "aa", magazine = "ab"
Output: false

Example 3:
Input: ransomNote = "aa", magazine = "aab"
Output: true


Constraints:
1 <= ransomNote.length, magazine.length <= 105
ransomNote and magazine consist of lowercase English letters.
"""


def canConstruct(ransomNote: str, magazine: str) -> bool:
    if len(magazine) < len(ransomNote):
        return False

    ransomNote_map = dict()
    for element in ransomNote:
        if ransomNote_map.get(element) == None:
            ransomNote_map[element] = 1
        else:
            ransomNote_map[element] += 1

    magazine_map = dict()
    for element in magazine:
        if magazine_map.get(element) == None:
            magazine_map[element] = 1
        else:
            magazine_map[element] += 1

    for element in ransomNote_map.keys():
        count = ransomNote_map[element]
        if magazine_map.get(element) == None or magazine_map[element] < count:
            return False

    return True


if __name__ == "__main__":
    ransomNote = "a"
    magazine = "b"
    result = canConstruct(ransomNote, magazine)
    print(f"ransomNote = {ransomNote}, magazine = {magazine}, result = {result}")

    ransomNote = "aa"
    magazine = "ab"
    result = canConstruct(ransomNote, magazine)
    print(f"ransomNote = {ransomNote}, magazine = {magazine}, result = {result}")

    ransomNote = "aa"
    magazine = "aab"
    result = canConstruct(ransomNote, magazine)
    print(f"ransomNote = {ransomNote}, magazine = {magazine}, result = {result}")
