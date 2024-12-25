package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums that may contain duplicates, return all possible  subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * <p>
 * Example 1:
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 * <p>
 * Time Complexity:  O(2n)
 * Space Complexity: O(n)
 */
public class Subsets_With_Duplicates {
    public static void main(String[] args) {
        Subsets_With_Duplicates obj = new Subsets_With_Duplicates();
        int[] nums = {1, 2, 2};
        List<List<Integer>> result = obj.subsetsWithDup(nums);
        System.out.println(result);
    }

    List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> resultSet = new ArrayList<>();
        Arrays.sort(num);
        // Start backtracking from the beginning
        backtracking(resultSet, new ArrayList<>(), num, 0);
        return resultSet;
    }

    void backtracking(List<List<Integer>> result, List<Integer> temp, int[] nums, int start) {
        // If the set is already present, just continue
        if (result.contains(temp)) {
            return;
        }
        result.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            // Backtrack the new subset
            backtracking(result, temp, nums, i + 1);
            // Case of not-including the number
            temp.remove(temp.size() - 1);
        }
    }
}
