package leetcode_medium;

import java.util.HashMap;

/**
 * Leetcode 525
 * Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
 * <p>
 * Example 1:
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
 * <p>
 * Example 2:
 * Input: nums = [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * <p>
 * https://www.youtube.com/watch?v=NUQ5Ob_xUvg&ab_channel=NikhilLohia
 * <p>
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class Contiguous_Array {
    // Convert zero to -1

    static private int maxSumLength(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) nums[i] = -1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int maxSumLenght = 0;


        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                int last = map.get(sum);
                maxSumLenght = Math.max(maxSumLenght, i - last);
            } else {
                map.put(sum, i);
            }
        }
        return maxSumLenght;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1};
        System.out.println("Contiguous Array: " + maxSumLength(nums));
    }
}
