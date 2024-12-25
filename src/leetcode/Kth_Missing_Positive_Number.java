package leetcode;

/**
 * Kth Missing Positive Number
 * Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
 * <p>
 * Return the kth positive integer that is missing from this array.
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [2,3,4,7,11], k = 5
 * Output: 9
 * Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
 * <p>
 * https://www.youtube.com/watch?v=NObPmjZIh8Y&ab_channel=NikhilLohia
 * <p>
 * Time Complexity : O(log n)
 * Space Complexity: O(1)
 */
public class Kth_Missing_Positive_Number {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;
        int result = findKthPositive(arr, k);
        System.out.println("The " + k + "th missing positive integer is: " + result);
    }

    static int findKthPositive(int[] arr, int k) {
        int start = 0;
        int end = arr.length;

        // Binary search to find where k-th missing number is located
        while (start < end) {
            int mid = start + (end - start) / 2;
            int missingBefore = arr[mid] - mid - 1;
            if (missingBefore < k) {
                // Move left to mid
                start = mid + 1;
            } else {
                // Move right to mid
                end = mid;
            }
        }
        // At the end, `left` gives us the index where the k-th missing number would be.
        // The k-th missing number is outside the array and is calculated by:
        return start + k;
    }
}
