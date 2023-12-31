package sort;

import java.util.Arrays;

public class QuickSort {

    static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    public int medianOfThreePartition(int[] array, int leftIndex, int rightIndex) {
        int center = (leftIndex + rightIndex) / 2;

        // make sure array[left] <= array[center] <= array[right]
        if (array[leftIndex] > array[center]) {
            swap(array, leftIndex, center);
        }

        if (array[leftIndex] > array[rightIndex]) {
            swap(array, leftIndex, rightIndex);
        }

        if (array[center] > array[rightIndex]) {
            swap(array, center, rightIndex);
        }

        // move pivot into the right index
        swap(array, center, rightIndex);

        return array[rightIndex];
    }

    public void quickSort(int[] array, int leftIndex, int rightIndex) {
        int cutoff = 3;

        if (leftIndex + cutoff <= rightIndex) {

            // find pivot based on Median of Three Partitioning.
            int pivot = this.medianOfThreePartition(array, leftIndex, rightIndex);

            int i = leftIndex;
            int j = rightIndex - 1;

            // partition the array based on pivot.
            // left side is less than pivot
            // right side is greater than pivot
            while (true) {
                while (array[i] < pivot) {
                    i++;
                }
                while (array[j] > pivot) {
                    j--;
                }

                if (i < j) {
                    swap(array, i, j);
                } else {
                    break;
                }
            }

            // switch pivot back into center position.
            swap(array, i, rightIndex);

            // recursion left side.
            quickSort(array, leftIndex, i - 1);
            // recursion right side.
            quickSort(array, i + 1, rightIndex);

        } else {
            // Insertion Sort
            int temp;
            for (int i = leftIndex; i <= rightIndex; i++) {
                for (int j = i; j > leftIndex; j--) {

                    if (array[j - 1] > array[j]) {
                        temp = array[j - 1];
                        array[j - 1] = array[j];
                        array[j] = temp;
                    }

                }
            }

        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 9, 2, 10, 3, 11, 4, 12, 5, 13, 6, 14, 7, 15, 8, 16};

        QuickSort quickSort = new QuickSort();

        quickSort.quickSort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));

    }

}
