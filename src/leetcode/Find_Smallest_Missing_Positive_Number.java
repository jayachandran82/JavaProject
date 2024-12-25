package leetcode;

/**
 * Find the Smallest Missing Positive Number
 *
 * Time Complexity:  O(n)
 * Space Complexity: O(1)
 */
public class Find_Smallest_Missing_Positive_Number {
    public static void main(String[] args) {
        int num[] = {3, 4, -1, 1};
        int val = firstMissingPostive(num);
        System.out.println(" Value: " + val);
    }

    public static int firstMissingPostive(int[] nums) {
        int n = nums.length;

        // Step 1: Place each number in its correct position if it's in the range [1, n]
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] < n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
        // Step 2: Find the first index where the number is not in its correct position
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

}
