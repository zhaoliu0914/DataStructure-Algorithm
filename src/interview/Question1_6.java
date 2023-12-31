package interview;

import java.util.Arrays;

public class Question1_6 {

    /**
     * 一副由 N*N 矩阵表示的图像，其中每个像素的大小为4个字节，
     * 将图像旋转 90度。不占用额外的内存空间
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] matrix = new int[5][5];
        int index = 1;

        // fill up the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = index;
                index++;
            }
        }


        // main logic
        for (int i = 0; i < matrix.length / 2; i++) {

            //int start = i;
            int end = matrix.length - 1 - i;
            int temp;
            for (int j = i; j < end; j++) {
                int offset = j - i;

                temp = matrix[i][j];

                // right ---> top
                matrix[i][j] = matrix[j][end];

                // bottom -> right
                matrix[j][end] = matrix[end][end - offset];

                // left -> bottom
                matrix[end][end - offset] = matrix[end - offset][i];

                // top -> left
                matrix[end - offset][i] = temp;
            }
        }

        // print the matrix
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

    }
}
