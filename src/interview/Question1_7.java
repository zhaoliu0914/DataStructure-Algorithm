package interview;

import java.util.Arrays;

public class Question1_7 {

    /**
     * 若 M*N 矩阵中某个元素为0，则讲其所在的行与列清零
     * @param args
     */
    public static void main(String[] args) {

        int[][] matrix = new int[4][5];
        int index = 1;

        // fill up the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = index;
                index++;
            }
        }
        matrix[1][1] = 0;
        matrix[2][3] = 0;
        matrix[1][4] = 0;

        // main logic
        boolean[] rows = new boolean[matrix.length];
        boolean[] columns = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0){
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(rows[i] || columns[j]){
                    matrix[i][j] = 0;
                }
            }
        }

        // print the matrix
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

    }
}
