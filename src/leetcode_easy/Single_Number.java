package leetcode_easy;

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 * <p>
 * Example 1:
 * Input: nums = [2,2,1]
 * Output: 1
 * <p>
 * Example 2:
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 */
public class Single_Number {
    //XOR
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        int singlenumber = sigleNumber(nums);
        System.out.println("Single  Number : " + singlenumber);
    }

    private static int sigleNumber(int[] nums) {
        int sing = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sing = sing ^ nums[i];
        }
        return sing;
    }
}
