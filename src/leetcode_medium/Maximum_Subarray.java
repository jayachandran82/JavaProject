package leetcode_medium;

/**
 * Given an integer array nums, find the  subarray with the largest sum, and return its sum.
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * <p>
 * Example 1:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 * <p>
 * Time Complexity : O(n)
 * Space Complexity: O(1)
 */
public class Maximum_Subarray {
    static private int maximumSubarray(int[] nums) {
        int current_sum = nums[0];
        int sum_of_num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            current_sum = Math.max(nums[i], current_sum + nums[i]);
            sum_of_num = Math.max(sum_of_num, current_sum);
        }
        return sum_of_num;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = maximumSubarray(nums);
        System.out.println("Maximum Subarray Sum : " + result);
    }
}
