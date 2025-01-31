package leetcode_medium;

import java.util.Arrays;

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 * <p>
 * Example 1:
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 * <p>
 * https://www.youtube.com/watch?v=euulNY_rDfA&ab_channel=DeveloperDocs  [ Easy to Matrix point ]
 * https://www.youtube.com/watch?v=Ux058jpRB9Y&t=13s&ab_channel=NikhilLohia [ Concept & Understanding is easy, but matrix swap point is difficult for interview time ].
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */
public class Rotate_Image {
    static private void rotateMatrix(int[][] matrix) {
        transposeMatrix(matrix);
        reverseMAtrix(matrix);
    }

    static void transposeMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <= i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    static void reverseMAtrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int left = 0;
            int right = matrix.length - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        //int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateMatrix(matrix);

        System.out.println("Rotate Image: " + Arrays.deepToString(matrix));


//        int n = matrix.length;
//
//        for (int i = 0; i < (n + 1) / 2; i++) {
//
//            for (int j = 0; j < n / 2; j++) {
//
//                //temp = bottom left
//                int temp = matrix[n - 1 - j][i];
//
//                // bottom left = bottom right
//                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
//
//                //bottom right = top right
//                matrix[n - 1 - j][n - 1 - i] = matrix[j][n - 1 - i];
//
//                //top right = top left
//                matrix[j][n - 1 - i] = matrix[i][j];
//
//                // top left = bottom left
//                matrix[i][j] = temp;
//
//            }
//        }
    }
}
