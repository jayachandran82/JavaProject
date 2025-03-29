package leetcode_medium;

/**
 * Given an integer array nums, find a subarray that has the largest product, and return the product.
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * <p>
 * <p>
 * Example 1:
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * <p>
 * https://www.youtube.com/watch?v=Y6B-7ZctiW8&ab_channel=NikhilLohia
 * <p>
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class Maximum_Product_Subarray {
    private static int maxProduct(int[] nums) {
        int n = nums.length;
        int leftPosition = 1;
        int rightPosition = 1;
        int max_product = nums[0];
        for (int i = 0; i < n; i++) {
            leftPosition = leftPosition == 0 ? 1 : leftPosition;
            rightPosition = rightPosition == 0 ? 1 : rightPosition;

            leftPosition *= nums[i];
            rightPosition *= nums[n - i - 1];
            max_product = Math.max(max_product, Math.max(leftPosition, rightPosition));
        }
        return max_product;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, -2, 4};
        System.out.println("Maximum Product Subarray - Scenario One :  " + maxProduct(nums1));
        int[] nums2 = {-2, 0, -1};
        System.out.println("Maximum Product Subarray - Scenario Two :  " + maxProduct(nums2));
    }
}
