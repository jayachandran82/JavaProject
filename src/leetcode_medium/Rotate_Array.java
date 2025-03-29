package leetcode_medium;

import java.util.Arrays;

/**
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 * <p>
 * Example 1:
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 */
public class Rotate_Array {
    private static void rotate_array(int[] nums, int k) {
        k %= nums.length;
        int n = nums.length;
        reverseNum(nums, 0, n - 1);
        reverseNum(nums, 0, k - 1);
        reverseNum(nums, k, n - 1);
    }

    private static void reverseNum(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        System.out.println("Before Rotate Value " + Arrays.toString(nums));
        rotate_array(nums, k);
        System.out.println("After Rotate Value " + Arrays.toString(nums));
    }
}
