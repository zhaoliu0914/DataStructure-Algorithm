"""
Given an array of integers citations where citations[i] is the number of citations a researcher received
for their ith paper, return the researcher's h-index.

According to the definition of h-index on Wikipedia:
    The h-index is defined as the maximum value of h such that the given researcher has published
    at least h papers that have each been cited at least h times.

Example 1:
Input: citations = [3, 0, 6, 1, 5]
Output: 3
Explanation: [3, 0, 6, 1, 5] means the researcher has 5 papers in total and each of them
had received 3, 0, 6, 1, 5 citations respectively.
Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each,
their h-index is 3.

Example 2:
Input: citations = [1, 3, 1]
Output: 1

Constraints:
n == citations.length
1 <= n <= 5000
0 <= citations[i] <= 1000
"""

def hIndex(citations: list[int]) -> int:
    size = len(citations)

    sorted_citations = sorted(citations, reverse=True)
    #print(f"sorted_citations = {sorted_citations}")

    for i in range(1, size+1):
        citation_count = sorted_citations[i-1]
        if i <= citation_count:
            continue
        else:
            #print(f"i = {i}")
            return i - 1

    return size

if __name__ == '__main__':
    citations = [3, 0, 6, 1, 5]
    h = hIndex(citations)
    print(f"citations = {citations}, H-Index = {h}")

    citations = [1, 3, 1]
    h = hIndex(citations)
    print(f"citations = {citations}, H-Index = {h}")

    citations = [9, 7, 6, 4, 1]
    h = hIndex(citations)
    print(f"citations = {citations}, H-Index = {h}")

    citations = [9, 7, 6, 3, 1]
    h = hIndex(citations)
    print(f"citations = {citations}, H-Index = {h}")

    citations = [11, 15]
    h = hIndex(citations)
    print(f"citations = {citations}, H-Index = {h}")