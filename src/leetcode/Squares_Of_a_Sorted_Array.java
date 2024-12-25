package leetcode;

import java.util.Arrays;

/**
 * Given an integer array nums sorted in non-decreasing order,
 * return an array of the squares of each number sorted in non-decreasing order.
 * <p>
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0, 1, 9, 16, 100]
 * Explanation: After squaring, the array becomes [16, 1, 0, 9, 100].
 * After sorting, it becomes [0, 1, 9, 16, 100].
 */
public class Squares_Of_a_Sorted_Array {
    public static void main(String[] args) {
        int num[] = {-4, -1, 0, 3, 10};
        int result[] = squreNum(num);
        System.out.println("Squares number : " + Arrays.toString(result));
    }

    public static int[] squreNum(int num[]) {
        int[] result = new int[num.length];

        for (int i = 0; i < num.length; i++) {
            num[i] = num[i] * num[i];

        }
        System.out.println("Multiple element : " + Arrays.toString(num));
        int start = 0;
        int end = num.length - 1;
        for (int i = num.length - 1; i >= 0; i--) {
            if (num[start] > num[end]) {
                result[i] = num[start];
                start++;
            } else {
                result[i] = num[end];
                end--;
            }
        }
        return result;

    }
}
