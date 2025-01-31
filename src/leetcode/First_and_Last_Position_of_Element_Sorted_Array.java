package leetcode;

import java.util.Arrays;

/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * Example 1:
 * * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * <p>
 * https://www.youtube.com/watch?v=bvaYNDKp830&ab_channel=NikhilLohia
 * <p>
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class First_and_Last_Position_of_Element_Sorted_Array {
    //Binary Search

    static private int[] searchRange(int[] nums, int target) {
        int left = leftBoundArray(nums, target);
        int right = rightBoundArray(nums, target);
        return new int[]{left, right};
    }

    static private int leftBoundArray(int[] nums, int target) {
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                index = mid;
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return index;
    }

    static private int rightBoundArray(int[] nums, int target) {
        int index = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                index = mid;
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return index;
    }

    // Time complexity: O(n) it's not efficiency
/*    public static int[] searchRange(int[] nums, int target) {
        int first = -1, last = -1;
        for (int i = 0; i < nums.length; i++) {
            if (target != nums[i]) {
                continue;
            }
            if (first == -1) {
                first = i;
            }
            last = i;

        }
        return new int[]{first, last};
    }*/

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));

    }

}
