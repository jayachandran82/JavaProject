package leetcode_medium;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * Input: grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * Output: 1
 * <p>
 * https://www.youtube.com/watch?v=__98uL6wst8&t=23s&ab_channel=Techdose
 * <p>
 * Time Complexity: O(M * N)
 * Space Complexity: O(M * N)
 */
public class Number_of_Islands {
    //Depth First Search (DFS)

    private static int numIslands(char[][] grid) {
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count = count + 1;
                    dfs(grid, i, j, row, col);
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] grid, int i, int j, int row, int col) {
        if (i < 0 || i >= row || j < 0 || j >= col || grid[i][j] != '1') {
            return;
        }

        // Mark the current cell as visited by setting it to '*'
        grid[i][j] = '*';

        // Explore all four directions (up, down, left, right)
        dfs(grid, i + 1, j, row, col);
        dfs(grid, i - 1, j, row, col);
        dfs(grid, i, j + 1, row, col);
        dfs(grid, i, j - 1, row, col);
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        char[][] grid1 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        System.out.println("Number of Islands : " + numIslands(grid));
        System.out.println("Number of Islands : " + numIslands(grid1));
    }
}
