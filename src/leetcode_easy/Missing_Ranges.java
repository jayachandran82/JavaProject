package leetcode_easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper], return its missing ranges.
 * <p>
 * Example:
 * Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
 * Output: ["2", "4->49", "51->74", "76->99"]
 * <p>
 * Time Complexity:  O(n)
 * Space Complexity: O(1) ->  (excluding the output list) as no additional data structures are used.
 */
public class Missing_Ranges {

    static private List<String> getMissingNumber(int[] nums, int lower, int upper) {
        int next = lower;
        List<String> result = new ArrayList<>();
        for (int num : nums) {
            if (num > next) {
                result.add(formatRange(next, num - 1));
            }
            next = num + 1;
            if (num > upper) {
                return result;
            }
        }
        if (next <= upper) {
            result.add(formatRange(next, upper));
        }
        return result;
    }

    static private String formatRange(int start, int end) {
        return (start == end) ? String.valueOf(start) : start + "->" + end;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 50, 75};
        int lower = 0;
        int upper = 99;
        List<String> missingNum = getMissingNumber(nums, lower, upper);
        System.out.println("Missing Number : " + missingNum);
    }

}
