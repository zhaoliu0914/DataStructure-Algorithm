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
    pass


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
