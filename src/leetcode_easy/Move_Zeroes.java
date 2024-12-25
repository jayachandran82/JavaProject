package leetcode_easy;

import java.util.Arrays;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 * Example 1:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * <p>
 * Example 2:
 * Input: nums = [0]
 * Output: [0]
 * <p>
 * Time Complexity : O(n)
 * Space Complexity: O(n)
 */
public class Move_Zeroes {
    private static void moveZeros(int[] nums) {
        int intialPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[intialPos] = nums[i];
                intialPos++;
            }
        }
        while (intialPos < nums.length) {
            nums[intialPos] = 0;
            intialPos++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        System.out.println("Actual array  : " + Arrays.toString(nums));
        moveZeros(nums);
        System.out.println(" Move Zeros to End  : " + Arrays.toString(nums));
    }
}
