package leetcode_medium;

/**
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
 * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 * The test cases are generated so that the answer will be less than or equal to 2 * 109.
 * <p>
 * Example 1:
 * Input: m = 3, n = 7
 * Output: 28
 * <p>
 * https://www.youtube.com/watch?v=Ee-rJmkwaTM&ab_channel=NikhilLohia
 * <p>
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */
public class Unique_Paths {

    static private int uniquePath(int m, int n) {
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    grid[i][j] = 1;
                } else {
                    grid[i][j] = grid[i][j - 1] + grid[i - 1][j];
                }
            }
        }
        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int m = 3, n = 7;
        int result = uniquePath(m, n);
        System.out.println("Unique Paths : " + result);
    }
}
