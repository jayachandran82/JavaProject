package leetcode_medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 * <p>
 * https://www.youtube.com/watch?v=aqVW8IuXUF0&ab_channel=NikhilLohia
 * <p>
 * Time Complexity: O(n * m)
 * Space Complexity: O(1)
 */
public class Spiral_Matrix {
    static private List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        while (colBegin <= colEnd && rowBegin <= rowEnd) {
            // Move to right
            for (int j = colBegin; j <= colEnd; j++)
                res.add(matrix[rowBegin][j]);
            rowBegin++;

            // Move to down
            for (int j = rowBegin; j <= rowEnd; j++)
                res.add(matrix[j][colEnd]);
            colEnd--;

            //Move to Left
            if (colBegin <= colEnd)
                for (int j = colEnd; j >= colBegin; j--)
                    res.add(matrix[rowEnd][j]);
            rowEnd--;

            if (rowBegin <= rowEnd)
                for (int j = rowEnd; j >= rowBegin; j--)
                    res.add(matrix[j][colBegin]);
            colBegin++;


        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> res = spiralOrder(matrix);
        System.out.println("Spiral Matrix : " + res);
    }
}
