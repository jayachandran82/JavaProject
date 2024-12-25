package leetcode;

import java.util.Arrays;

public class TwoPointerAlgorithm {
    public static void main(String[] args) {
        int num[] = {10, 20, 35, 50};
        int target = 70;
        int[] result = twoSum(num, target);
        System.out.println("Opposite-directional twoSum:  " + Arrays.toString(result));

        int A[] = {1, 9, -1, -2, 7, 3, -1, 2};
        int k = 4;
        int sum = getMaxSumSubArrayOfSizeKM2(A, k);
        System.out.println("Two Pointer Technique getMaxSumSubArrayOfSizeKM2: " + sum);

    }

    // Two Pointer Technique (Opposite-directional)
    static int[] twoSum(int[] num, int target) {
        int start = 0;
        int end = num.length - 1;
        int result[] = new int[2];
        while (start < end) {
            int sum = num[start] + num[end];
            if (sum == target) {
                result[0] = num[start];
                result[1] = num[end];
                break;
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }

        }
        return result;
    }

    // Two Pointer Technique (Equi-directional)
    public static int getMaxSumSubArrayOfSizeKM2(int[] A, int k) {
        int start = 0;
        int winSum = 0, maxSum = 0;
        int end = 0;

        while (end < k) {
            winSum += A[end++];
        }
        while (end < A.length) {
            winSum += A[end++] - A[start++];
            maxSum = Math.max(maxSum, winSum);
        }
        return maxSum;
    }

}
