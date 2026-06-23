"""
Determine the minimum number of swaps needed to correctly order the items by decreasing popularity.

Example:
n = 4
popularity = [3, 4, 1, 2]
1. First swap: Switch items with ratings 3 and 4 to get [4, 3, 1, 2]
2. Second swap: Switch items with ratings 1 and 2 to get [4, 3, 2, 1]
The array is properly ordered in 2 operations.

Function Description:
Complete the function minimumSwaps in the editor with the following parameter(s):
int popularity[n]: the popularity of each item
Returns:
int: the minimum number of swaps to order the items properly

"""

def minimum_swaps(popularity: list) -> int:
    n = len(popularity)

    array = []
    for i in range(n):
        element = (-popularity[i], i)
        array.append(element)
    print(array)

    array.sort()
    print(array)


if __name__ == '__main__':
    popularity = [3, 4, 1, 2]
    swaps = minimum_swaps(popularity)
    print(f"popularity = {popularity}, swaps = {swaps}")

    popularity = [3, 1, 2]
    swaps = minimum_swaps(popularity)
    print(f"popularity = {popularity}, swaps = {swaps}")