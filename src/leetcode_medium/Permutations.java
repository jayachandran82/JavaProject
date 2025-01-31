package leetcode_medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of distinct integers, return all the possible permutations.  You can return the answer in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * https://www.youtube.com/watch?v=H232aocj7bQ&ab_channel=NikhilLohia
 * <p>
 * Time Complexity: O((n!) * n)
 * Space Complexity: O(n)
 */
public class Permutations {
    //Backtracking

    static private List<List<Integer>> permutations(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        backtracking(resultList, new ArrayList<>(), nums);
        return resultList;
    }

    static void backtracking(List<List<Integer>> resultList, List<Integer> tempList, int[] nums) {
        //IF we match the length, it's a Permutations.
        if (tempList.size() == nums.length) {
            resultList.add(new ArrayList<>(tempList));
            return;
        }
        for (int number : nums) {
            // Skip if we get same element
            if (tempList.contains(number)) {
                continue;
            }
            // Add the new element
            tempList.add(number);

            // Go back to try other element
            backtracking(resultList, tempList, nums);

            // Remove the element
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> resultList = permutations(nums);
        System.out.println("Permutations : " + resultList.toString());
    }
}
