package leetcode_easy;

/**
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
 * Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
 * Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class Remove_Duplicates_SortedArray {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int result = removeDuplicates(nums);
        System.out.println("Unique Element : " + result);
    }

    private static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n;
        int k = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
