package leetcode;

/**
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
 * The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
 * <p>
 * Consider the number of elements in nums which are not equal to val be k, to get accepted,
 * you need to do the following things:
 * <p>
 * Change the array nums such that the first k elements of nums contain the elements which are not equal to val.
 * The remaining elements of nums are not important as well as the size of nums.
 * <p>
 * Return k.
 * <p>
 * Custom Judge:
 * <p>
 * The judge will test your solution with the following code:
 * <p>
 * int[] nums = [...]; // Input array
 * int val = ...; // Value to remove
 * int[] expectedNums = [...]; // The expected answer with correct length.
 * // It is sorted with no values equaling val.
 * <p>
 * int k = removeElement(nums, val); // Calls your implementation
 * <p>
 * assert k == expectedNums.length;
 * sort(nums, 0, k); // Sort the first k elements of nums
 * for (int i = 0; i < actualLength; i++) {
 * assert nums[i] == expectedNums[i];
 * }
 * If all assertions pass, then your solution will be accepted.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,2,2,3], val = 3
 * Output: 2, nums = [2,2,_,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 2.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [0,1,2,2,3,0,4,2], val = 2
 * Output: 5, nums = [0,1,4,0,3,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
 * Note that the five elements can be returned in any order.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 50
 * 0 <= val <= 100
 */
public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        int[] positions = new int[nums.length];
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            int element = nums[i];
            if (element == val) {
                positions[index] = i;
                index++;
            }
        }

        int numVal = index;
        index = 0;
        int tempIndex = nums.length - 1;
        while (index < numVal && tempIndex >= 0) {
            int position = positions[index];
            int tempValue = nums[tempIndex];
            if (tempValue != val) {
                nums[position] = tempValue;

                index++;
            }
            tempIndex--;
        }

        return nums.length - numVal;
    }

    public static void main(String[] args) {
        //int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        //int val = 2;

        int[] nums = {1};
        int val = 1;

        int k = removeElement(nums, val);

        System.out.println("k = " + k);
        printArray(nums);
    }

    public static void printArray(int[] array) {
        if (array == null) {
            return;
        }

        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i < array.length - 1) {
                System.out.print(array[i] + ", ");
            } else {
                System.out.print(array[i]);
            }
        }
        System.out.print("]");
    }
}
