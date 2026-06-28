"""
Implement the RandomizedSet class:

RandomizedSet() Initializes the RandomizedSet object.
bool insert(int val) Inserts an item val into the set if not present.
                     Returns true if the item was not present, false otherwise.
bool remove(int val) Removes an item val from the set if present.
                     Returns true if the item was present, false otherwise.
int getRandom() Returns a random element from the current set of elements
                (it's guaranteed that at least one element exists when this method is called).
                Each element must have the same probability of being returned.
You must implement the functions of the class such that each function works in average O(1) time complexity.

Example 1:

Input
["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
[[], [1], [2], [2], [], [1], [2], []]
Output
[null, true, false, true, 2, true, false, 2]

Explanation
RandomizedSet randomizedSet = new RandomizedSet();
randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
randomizedSet.insert(2); // 2 was already in the set, so return false.
randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.

Constraints:

-231 <= val <= 231 - 1
At most 2 * 105 calls will be made to insert, remove, and getRandom.
There will be at least one element in the data structure when getRandom is called.
"""
from sqlalchemy.sql.functions import random


class RandomizedSet:

    def __init__(self):
        self.fact = 8
        self.content = list()
        for i in range(self.fact):
            self.content.append(list())

    def insert(self, val: int) -> bool:
        index = val % self.fact
        temp_list = self.content[index]

        if val in temp_list:
            return False
        else:
            temp_list.append(val)
            return True

    def remove(self, val: int) -> bool:
        index = val % self.fact
        temp_list = self.content[index]

        if val in temp_list:
            temp_list.remove(val)
            return True
        else:
            return False

    def getRandom(self) -> int:
        import random

        temp_list = list()
        for i in range(self.fact):
            if len(self.content[i]) > 0:
                for j in self.content[i]:
                    temp_list.append(j)

        index = random.randint(0, len(temp_list) - 1)
        return temp_list[index]

if __name__ == '__main__':
    obj = RandomizedSet()
    param_1 = obj.insert(1)
    print(param_1)
    param_2 = obj.remove(2)
    print(param_2)
    param_3 = obj.insert(2)
    print(param_3)
    param_4 = obj.getRandom()
    print(param_4)
    param_5 = obj.remove(1)
    print(param_5)
    param_6 = obj.insert(2)
    print(param_6)
    param_7 = obj.getRandom()
    print(param_7)