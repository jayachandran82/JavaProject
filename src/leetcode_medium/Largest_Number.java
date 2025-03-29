package leetcode_medium;

import java.util.Arrays;

/**
 * Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
 * Since the result may be very large, so you need to return a string instead of an integer.
 * <p>
 * Example 1:
 * Input: nums = [10,2]
 * Output: "210"
 * <p>
 * Example 2:
 * Input: nums = [3,30,34,5,9]
 * Output: "9534330"
 * <p>
 * https://www.youtube.com/watch?v=qEIGhVtZ-sg&ab_channel=Techdose
 * <p>
 * Time Complexity: O(n log(n) )
 * Space Complexity: O(n)
 */
public class Largest_Number {

    private static String largeNumber(int[] nums) {
        String[] numbers = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            numbers[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numbers, (a, b) -> (b + a).compareTo(a + b));

        if (numbers[0].equals("0")) return "0";

        StringBuilder result = new StringBuilder();
        for (String number : numbers) {
            result.append(number);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int nums[] = {3, 30, 34, 5, 9};
        System.out.println("Largest Number :  " + largeNumber(nums));
    }
}
