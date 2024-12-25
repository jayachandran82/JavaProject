package leetcode_easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 * Example 1:
 * Input: numRows = 5
 * <p>
 * //               1
 * //           1       1
 * //       1       2       1
 * //   1       3       3       1
 * // 1     4       6       4       1
 * <p>
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * <p>
 * Time Complexity: O(n2)
 * Space Complexity: O(n2)
 * <p>
 * https://www.youtube.com/watch?v=nFqeCXOJn0I&ab_channel=NikhilLohia
 */
public class Pascal_Triangle {


    static List<List<Integer>> numRows(int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);

        if (n == 1) {
            return result;
        }

        for (int i = 1; i < n; i++) {
            List<Integer> prevRow = result.get(i - 1);

            // Start the next row
            ArrayList<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            for (int j = 0; j < i - 1; j++) {
                newRow.add(prevRow.get(j) + prevRow.get(j + 1));
            }
            newRow.add(1);

            //Add this row to final result.
            result.add(newRow);
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> finalResult = numRows(6);
        System.out.println(" Final Result : " + finalResult);

        // Iterate using nested loops
        for (List<Integer> innerList : finalResult) {
            for (Integer number : innerList) {
                System.out.print(number + " ");
            }
            System.out.println("");
        }
    }
}
