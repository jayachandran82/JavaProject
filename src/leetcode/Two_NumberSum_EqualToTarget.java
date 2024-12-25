package leetcode;

import java.util.Arrays;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * <p>
 * Time Complexity : O(n log n)
 * Space Complexity: O(1)
 */
public class Two_NumberSum_EqualToTarget {
    //Approach: Two-Pointer Technique
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = findTwoSum(nums, target);

        if (result.length > 0) {
            System.out.println("Pair found: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No pair found");
        }
    }

    public static int[] findTwoSum(int[] nums, int target) {
        // Sort the array first
        int[][] indexNumber = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            indexNumber[i][0] = nums[i];
            indexNumber[i][1] = i; // Original index
        }

        Arrays.sort(indexNumber, (a, b) -> Integer.compare(a[0], b[0]));
        // Use two pointers
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int currentSum = indexNumber[left][0] + indexNumber[right][0];

            if (currentSum == target) {
                return new int[]{indexNumber[left][1], indexNumber[right][1]};
            } else if (currentSum < target) {
                left++; // Move the left pointer to the right
            } else {
                right--; // Move the right pointer to the left
            }
        }

        // Return empty array if no pair found
        return new int[0];
    }
}

