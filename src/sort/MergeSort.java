package sort;

import java.util.Arrays;

public class MergeSort {

    public void mergeSort(int[] originalArray, int[] tempArray, int leftIndex, int rightIndex) {
        int centerIndex;

        if (leftIndex < rightIndex) {
            centerIndex = (leftIndex + rightIndex) / 2;

            mergeSort(originalArray, tempArray, leftIndex, centerIndex);
            mergeSort(originalArray, tempArray, centerIndex + 1, rightIndex);

            merge(originalArray, tempArray, leftIndex, centerIndex + 1, rightIndex);
        }

    }

    public void merge(int[] originalArray, int[] tempArray, int leftPosition, int rightPosition, int rightEnd) {
        int leftEnd = rightPosition - 1;
        int tempPosition = leftPosition;
        int numberOfElements = rightEnd - leftPosition + 1;

        // Main Loop.
        while (leftPosition <= leftEnd && rightPosition <= rightEnd) {
            if (originalArray[leftPosition] <= originalArray[rightPosition]) {
                tempArray[tempPosition] = originalArray[leftPosition];
                tempPosition++;
                leftPosition++;
            } else {
                tempArray[tempPosition] = originalArray[rightPosition];
                tempPosition++;
                rightPosition++;
            }
        }

        // copy all the elements into temp array if left side array still has elements.
        while (leftPosition <= leftEnd) {
            tempArray[tempPosition] = originalArray[leftPosition];
            tempPosition++;
            leftPosition++;
        }

        // copy all the elements into temp array if right side array still has elements.
        while (rightPosition <= rightEnd) {
            tempArray[tempPosition] = originalArray[rightPosition];
            tempPosition++;
            rightPosition++;
        }

        int i = 0;
        while (i < numberOfElements) {
            originalArray[rightEnd] = tempArray[rightEnd];

            rightEnd--;
            i++;
        }
    }


    public static void main(String[] args) {
        int[] array = new int[]{24, 13, 26, 1, 2, 27, 38, 15};
        int[] tempArray = new int[array.length];

        MergeSort mergeSort = new MergeSort();

        mergeSort.mergeSort(array, tempArray, 0, array.length - 1);

        System.out.println(Arrays.toString(array));

    }

}
