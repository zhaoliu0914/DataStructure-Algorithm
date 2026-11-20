"""
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti.
You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
Two intervals are considered overlapping if they share at least one point.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.
Note that you don't need to modify intervals in-place.
You can make a new array and return it.


Example 1:
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Example 2:
Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].


Constraints:
0 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 105
intervals is sorted by starti in ascending order.
newInterval.length == 2
0 <= start <= end <= 105
"""


def insert(intervals: list[list[int]], newInterval: list[int]) -> list[list[int]]:
    new_start = newInterval[0]
    new_end = newInterval[1]
    size = len(intervals)
    results = []
    i = 0

    while i < size and intervals[i][1] < new_start:
        results.append(intervals[i])
        #print(f"i = {i}, results = {results}")
        i += 1

    while i < size and intervals[i][0] <= new_end:
        new_start = min(new_start, intervals[i][0])
        new_end = max(new_end, intervals[i][1])
        #print(f"i = {i}, new_start = {new_start}, new_end = {new_end}")
        i += 1
    results.append([new_start, new_end])

    while i < size:
        results.append(intervals[i])
        #print(f"i = {i}, results = {results}")
        i += 1

    return results

if __name__ == '__main__':
    intervals = [[1, 3], [6, 9]]
    newInterval = [2, 5]
    result = insert(intervals, newInterval)
    print(f"intervals = {intervals}, newInterval = {newInterval}, result = {result}")

    intervals = [[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]]
    newInterval = [4, 8]
    result = insert(intervals, newInterval)
    print(f"intervals = {intervals}, newInterval = {newInterval}, result = {result}")

    intervals = []
    newInterval = [5, 7]
    result = insert(intervals, newInterval)
    print(f"intervals = {intervals}, newInterval = {newInterval}, result = {result}")