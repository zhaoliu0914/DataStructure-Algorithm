package sort;

import java.util.Arrays;

public class ShellSort {

    public void shellSort(int[] array) {

        int temp;
        int j;
        for (int increment = array.length / 2; increment > 0; increment = increment / 2) {

            for (int i = increment; i < array.length; i++) {


                for (j = i; j >= increment; j = j - increment) {

                    if (array[j - increment] > array[j]) {
                        temp = array[j - increment];
                        array[j - increment] = array[j];
                        array[j] = temp;
                    }

                }

            }

        }
    }

    public void shellSortForDefaultIncrement(int[] array) {

        int temp;
        int j;
        for (int increment = array.length / 2; increment > 0; increment = increment / 2) {

            for (int i = increment; i < array.length; i++) {

                temp = array[i];

                for (j = i; j >= increment; j = j - increment) {

                    if (array[j - increment] > temp) {
                        array[j] = array[j - increment];
                    } else {
                        break;
                    }

                }

                array[j] = temp;

                System.out.println("increment = " + increment + ", i = " + i + ", j = " + j);
                System.out.println(Arrays.toString(array));

                System.out.println();
            }

        }
    }

    public void shellSortForSedgewichIncrement(int[] array) {
        /*
        Sedgewick Increment Sequence
         9*((2^i)-2^(i/2))+1      ,  i for even
         8*(2^i)-6*2^((i+1)/2)+1  ,  i for odd
         */
        int[] sedgewickIncrement = new int[]{1, 5, 19, 41, 109};

        int temp;
        int j;
        for (int increment : sedgewickIncrement) {

            for (int i = increment; i < array.length; i++) {

                temp = array[i];

                for (j = i; j >= increment; j = j - increment) {

                    if (array[j - increment] > temp) {
                        array[j] = array[j - increment];
                    } else {
                        break;
                    }

                }

                array[j] = temp;
            }

        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 9, 2, 10, 3, 11, 4, 12, 5, 13, 6, 14, 7, 15, 8, 16};

        ShellSort shellSort = new ShellSort();

        shellSort.shellSortForDefaultIncrement(array);
        System.out.println(Arrays.toString(array));
    }

}
