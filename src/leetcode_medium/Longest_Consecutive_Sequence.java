package leetcode_medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.
 * <p>
 * Example 1:
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].Therefore, its length is 4.
 * <p>
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class Longest_Consecutive_Sequence {
    private static int longestConsecutive(int[] nums) {
        int longestLength = 0;

        Map<Integer, Boolean> consecutiveMap = new HashMap<>();
        for (int num : nums) {
            consecutiveMap.put(num, Boolean.FALSE);
        }

        for (int num : nums) {
            int currentLength = 1;

            // Check in forward direction
            int nextNum = num + 1;
            while (consecutiveMap.containsKey(nextNum) && !consecutiveMap.get(num)) {
                currentLength++;
                consecutiveMap.put(nextNum, Boolean.TRUE);
                nextNum++;

            }

            // Check in reverse direction
            int prevNum = num - 1;
            while (consecutiveMap.containsKey(prevNum) && !consecutiveMap.get(num)) {
                currentLength++;
                consecutiveMap.put(prevNum, Boolean.TRUE);
                prevNum--;
            }

            longestLength = Math.max(longestLength, currentLength);
        }
        return longestLength;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int result = longestConsecutive(nums);
        System.out.println("Longest Consecutive Sequence : " + result);
    }
}
