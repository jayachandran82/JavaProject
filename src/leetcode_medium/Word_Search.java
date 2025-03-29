package leetcode_medium;

/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * Example 1:
 * Input: board = [
 * ["A","B","C","E"],
 * ["S","F","C","S"],
 * ["A","D","E","E"]],
 * word = "ABCCED"
 * Output: true
 * <p>
 * https://www.youtube.com/watch?v=mXWKVqGcL1M&ab_channel=NareshGupta
 */
public class Word_Search {
    static private boolean wordSearch(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j] && wordExists(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean wordExists(char[][] board, int i, int j, String word, int pos) {
        if (pos == word.length()) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        if (word.charAt(pos) != board[i][j]) return false;
        char temp = board[i][j];
        board[i][j] = '*';
        if (wordExists(board, i + 1, j, word, pos + 1) ||
                wordExists(board, i - 1, j, word, pos + 1) ||
                wordExists(board, i, j + 1, word, pos + 1) ||
                wordExists(board, i, j - 1, word, pos + 1)) {
            return true;
        }
        board[i][j] = temp;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        boolean result = wordSearch(board, word);
        System.out.println("Word Search :  " + result);
    }
}
