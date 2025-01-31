package leetcode_medium;

import java.util.Arrays;

/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * You must solve this problem without using the library's sort function.
 * <p>
 * Example 1:
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * <p>
 * https://www.youtube.com/watch?v=6sMssUHgaBs&ab_channel=NikhilLohia
 * <p>
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class Sort_Colors {
    static private void setColors(int[] nums) {
        int start = 0;
        int mid = 0;
        int end = nums.length - 1;

        while (mid <= end) {
            switch (nums[mid]) {
                case 0:
                    swap(nums, start, mid);
                    mid++;
                    start++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(nums, mid, end);
                    end--;
                    break;
            }
        }
    }

    static void swap(int[] nums, int mid, int end) {
        int temp = nums[mid];
        nums[mid] = nums[end];
        nums[end] = temp;
    }

    public static void main(String[] args) {
        int nums[] = {2, 0, 2, 1, 1, 0};
        System.out.println("Before Sort : " + Arrays.toString(nums));
        setColors(nums);
        System.out.println("After Sort : " + Arrays.toString(nums));
    }
}
