package leetcode;

/**
 * You are given an integer array nums consisting of n elements, and an integer k.
 * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,12,-5,-6,50,3], k = 4
 * Output: 12.75000
 * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 * <p>
 * https://www.youtube.com/watch?v=56TxHMG0qhQ&ab_channel=NikhilLohia
 * <p>
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class Sliding_Window_Maximum_Average_Subarray {
    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        double result = findAvgSubarray(nums, k);
        System.out.println(" Result : " + result);
    }

    static double findAvgSubarray(int[] nums, int k) {
        int sum = 0;
        //Get Sum for starting window.
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;

        //Starting Sliding Window
        int start = 0;
        int end = k;
        while (end < nums.length) {
            sum -= nums[start]; // Remove previous index
            start++;

            sum += nums[end]; // Add next Element
            end++;

            maxSum = Math.max(maxSum, sum); // Update max sum
        }
        return (double)maxSum / k;
    }
}
