package leetcode_medium;

/**
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 * Return true if you can reach the last index, or false otherwise.
 * <p>
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * <p>
 * https://www.youtube.com/watch?v=Gtugy3mRV-A&ab_channel=NikhilLohia
 * <p>
 * Time Complexity: O(n)
 * Space complexity: O(1)
 */
public class Jump_Game {

    static private boolean canJump(int[] nums) {
        int lastPosition = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] == lastPosition) {
                lastPosition = i;
            }
        }
        return lastPosition == 0;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        boolean result = canJump(nums);
        System.out.println("Jump Game : " + result);
    }
}
