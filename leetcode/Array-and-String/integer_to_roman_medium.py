"""
Seven different symbols represent Roman numerals with the following values:

Symbol	Value
I	1
V	5
X	10
L	50
C	100
D	500
M	1000
Roman numerals are formed by appending the conversions of decimal place values from highest to lowest. Converting a decimal place value into a Roman numeral has the following rules:

If the value does not start with 4 or 9, select the symbol of the maximal value that can be subtracted from the input, append that symbol to the result, subtract its value, and convert the remainder to a Roman numeral.
If the value starts with 4 or 9 use the subtractive form representing one symbol subtracted from the following symbol, for example, 4 is 1 (I) less than 5 (V): IV and 9 is 1 (I) less than 10 (X): IX. Only the following subtractive forms are used: 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM).
Only powers of 10 (I, X, C, M) can be appended consecutively at most 3 times to represent multiples of 10. You cannot append 5 (V), 50 (L), or 500 (D) multiple times. If you need to append a symbol 4 times use the subtractive form.
Given an integer, convert it to a Roman numeral.


Example 1:
Input: num = 3749
Output: "MMMDCCXLIX"
Explanation:
3000 = MMM as 1000 (M) + 1000 (M) + 1000 (M)
 700 = DCC as 500 (D) + 100 (C) + 100 (C)
  40 = XL as 10 (X) less of 50 (L)
   9 = IX as 1 (I) less of 10 (X)
Note: 49 is not 1 (I) less of 50 (L) because the conversion is based on decimal places

Example 2:
Input: num = 58
Output: "LVIII"
Explanation:
50 = L
 8 = VIII

Example 3:
Input: num = 1994
Output: "MCMXCIV"
Explanation:
1000 = M
 900 = CM
  90 = XC
   4 = IV


Constraints:
1 <= num <= 3999
"""


def intToRoman(num: int) -> str:
    num = str(num)
    size = len(num)
    multiple = 0
    roman = ""
    for i in range(size-1, -1, -1):
        multiple += 1
        current = num[i]
        current = int(current)
        #print(f"i = {i}, multiple = {multiple}, current = {current}")
        if current == 0:
            pass
        elif current == 1:
            if multiple == 1:
                roman = f"I{roman}"
            elif multiple == 2:
                roman = f"X{roman}"
            elif multiple == 3:
                roman = f"C{roman}"
            elif multiple == 4:
                roman = f"M{roman}"
        elif current == 2:
            if multiple == 1:
                roman = f"II{roman}"
            elif multiple == 2:
                roman = f"XX{roman}"
            elif multiple == 3:
                roman = f"CC{roman}"
            elif multiple == 4:
                roman = f"MM{roman}"
        elif current == 3:
            if multiple == 1:
                roman = f"III{roman}"
            elif multiple == 2:
                roman = f"XXX{roman}"
            elif multiple == 3:
                roman = f"CCC{roman}"
            elif multiple == 4:
                roman = f"MMM{roman}"
        elif current == 4:
            if multiple == 1:
                roman = f"IV{roman}"
            elif multiple == 2:
                roman = f"XL{roman}"
            elif multiple == 3:
                roman = f"CD{roman}"
        elif current == 5:
            if multiple == 1:
                roman = f"V{roman}"
            elif multiple == 2:
                roman = f"L{roman}"
            elif multiple == 3:
                roman = f"D{roman}"
        elif current == 6:
            if multiple == 1:
                roman = f"VI{roman}"
            elif multiple == 2:
                roman = f"LX{roman}"
            elif multiple == 3:
                roman = f"DC{roman}"
        elif current == 7:
            if multiple == 1:
                roman = f"VII{roman}"
            elif multiple == 2:
                roman = f"LXX{roman}"
            elif multiple == 3:
                roman = f"DCC{roman}"
        elif current == 8:
            if multiple == 1:
                roman = f"VIII{roman}"
            elif multiple == 2:
                roman = f"LXXX{roman}"
            elif multiple == 3:
                roman = f"DCCC{roman}"
        else:
            if multiple == 1:
                roman = f"IX{roman}"
            elif multiple == 2:
                roman = f"XC{roman}"
            elif multiple == 3:
                roman = f"CM{roman}"
        #print(f"roman = {roman}")

    return roman



if __name__ == '__main__':
    num = 3749
    roman_num = intToRoman(num)
    print(f"num = {num}, roman_num = {roman_num}")

    num = 58
    roman_num = intToRoman(num)
    print(f"num = {num}, roman_num = {roman_num}")

    num = 1994
    roman_num = intToRoman(num)
    print(f"num = {num}, roman_num = {roman_num}")
