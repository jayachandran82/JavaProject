package leetcode;

/**
 * You are playing a game involving a circular array of non-zero integers nums. Each nums[i] denotes the number of indices forward/backward you must move if you are located at index i:
 * <p>
 * If nums[i] is positive, move nums[i] steps forward, and
 * If nums[i] is negative, move nums[i] steps backward.
 * Since the array is circular, you may assume that moving forward from the last element puts you on the first element, and moving backwards from the first element puts you on the last element.
 * <p>
 * A cycle in the array consists of a sequence of indices seq of length k where:
 * <p>
 * Following the movement rules above results in the repeating index sequence seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ...
 * Every nums[seq[j]] is either all positive or all negative.
 * k > 1
 * Return true if there is a cycle in nums, or false otherwise.
 * <p>
 * Time complexity : O(n)
 * Space Complexity: O(1)
 * https://www.youtube.com/watch?v=2hVinjU-5SA&ab_channel=CodingSimplified
 */
public class Cycle_Circular_Array {
    public static void main(String[] args) {
        int[] nums1 = {2, -1, 1, 2, 2};
        Cycle_Circular_Array obj = new Cycle_Circular_Array();
        System.out.println("Has Cycle: " + obj.hasCycle(nums1));  // Output: true

        int[] nums2 = {-1, 2};
        System.out.println("Has Cycle: " + obj.hasCycle(nums2));  // Output: false

        int[] nums3 = {1, 1, 1, 1, 1, -1};
        System.out.println("Has Cycle: " + obj.hasCycle(nums3));  // Output: false
    }

    boolean hasCycle(int[] num) {
        int n = num.length;
        for (int i = 0; i < n; i++) {
            // Check the direction of movement
            boolean isForwarded = num[i] > 0;
            int slow = i, fast = i;
            // Use Floyd’s cycle detection algorithm
            while (true) {
                // Move slow pointer one step
                slow = getNextIntex(num, isForwarded, slow);
                // Move fast pointer two steps
                fast = getNextIntex(num, isForwarded, fast);
                if (fast != -1) {
                    fast = getNextIntex(num, isForwarded, fast);
                }
                if (slow == -1 | fast == -1 | fast == slow) {
                    break;
                }
            }
            if (slow != -1 && fast == slow) {
                return true;
            }
        }
        return false;
    }

    int getNextIntex(int[] num, boolean isForwared, int curretIndex) {
        boolean direction = num[curretIndex] > 0;
        // Check if the direction is consistent
        if (isForwared != direction) {
            return -1;
        }
        int nextIndex = (curretIndex + num[curretIndex]) % num.length;
        if (nextIndex < 0) {
            // wrap around negative index
            nextIndex = nextIndex + num.length;
        }
        // Check for self-loop
        if (curretIndex == nextIndex) {
            return -1;
        }
        return nextIndex;
    }

}
