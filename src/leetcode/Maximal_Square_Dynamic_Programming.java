package leetcode;

/**
 * Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * <p>
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * <p>
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 4
 * <p>
 * Reference: https://www.youtube.com/watch?v=RElcqtFYTm0&ab_channel=Techdose
 *
 * Time complexity : O(MN)
 * Space complexity: O(N)
 */
public class Maximal_Square_Dynamic_Programming {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0' },
                {'1', '0', '1', '1', '1' },
                {'1', '1', '1', '1', '1' },
                {'1', '0', '0', '1', '0' }};
        int result = maximalSquare(matrix);
        System.out.println("Result :" + result);
    }

    static int maximalSquare(char[][] matrix) {
        int largest = 0;
        int row = matrix.length;

        int column = matrix[0].length;
        int dp[][] = new int[row + 1][column + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                    largest = Math.max(largest, dp[i][j]);
                }
            }
        }

        System.out.println("row :" + row + "\n column: " + column);

        return largest * largest;
    }
}
