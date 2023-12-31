package sort;

import java.util.Arrays;

public class InsertionSort {

    public void insertionSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        int temp;
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {

                if (array[j - 1] > array[j]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }

            }
        }

    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 9, 2, 10, 3, 11, 4, 12, 5, 13, 6, 14, 7, 15, 8, 16};

        InsertionSort insertionSort = new InsertionSort();
        insertionSort.insertionSort(array);

        System.out.println(Arrays.toString(array));
    }

}
