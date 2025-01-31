package leetcode_medium;

import java.util.Arrays;

/**
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
 * You must do it in place.
 * <p>
 * Example 1:
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * Output: [[1,0,1],[0,0,0],[1,0,1]]
 * <p>
 * https://www.youtube.com/watch?v=dSxt3ZCbIqA&ab_channel=NikhilLohia
 * <p>
 * Time Complexity : O(m * n)
 * Space Complexity: O(1)
 */
public class Set_Matrix_Zeroes {
    static private void setMatrixZero(int[][] matrix) {
        boolean firstRow = false, firstCol = false;

        //Set Marker in First row and First column
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) firstRow = true;
                    if (j == 0) firstCol = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }

            }
        }

        //Replace inner matrix to zero
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        //Last remaining check
        if (firstRow) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if (firstCol) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        System.out.println("Input : " + Arrays.deepToString(matrix));
        setMatrixZero(matrix);
        System.out.println("Expected Output - Set Matrix Zeroes : " + Arrays.deepToString(matrix));
    }
}
