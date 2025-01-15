package leetcode_medium;

import java.util.HashMap;

/**
 * You are given an integer array nums and an integer target.
 * You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
 * Return the number of different expressions that you can build, which evaluates to target.
 * <p>
 * Example 1:
 * Input: nums = [1,1,1,1,1], target = 3
 * Output: 5
 * Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * <p>
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 * <p>
 * https://www.youtube.com/watch?v=g5YfuTczR88&ab_channel=NikhilLohia
 */
public class Target_Sum {
    private static int targetSum(int[] nums, int target) {
        // Base case: we start with the sum 0 and one way to achieve it.
        HashMap<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);

        for (int num : nums) {
            // Temporary map to store new dp states for the current iteration
            HashMap<Integer, Integer> nextDp = new HashMap<>();

            // For every possible sum in dp, add and subtract the current number
            for (int sum : dp.keySet()) {
                int count = dp.get(sum);
                // Add current number to sum
                nextDp.put(sum + num, nextDp.getOrDefault(sum + num, 0) + count);

                // Subtract current number from sum
                nextDp.put(sum - num, nextDp.getOrDefault(sum - num, 0) + count);
            }
            dp = nextDp;
        }
        return dp.getOrDefault(target, 0);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        int targetSumVal = targetSum(nums, target);
        System.out.println("Target Sum : " + targetSumVal);
    }
}
