package leetcode_easy;

/**
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
 * You must not use any built-in exponent function or operator.
 * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 */
public class Sqrtx {
    // Binary Search

    public static void main(String[] args) {
        int result = sqrtx(28);
        System.out.println(" Square root Value: " + result);
    }

    private static int sqrtx(int x) {
        if (x == 0 || x == 1) return x;
        int start = 1;
        int end = x;
        int result = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid * mid == x) {
                return mid;
            }
            if (mid * mid < x) {
                start = mid + 1;
                result = mid;

            } else {
                end = mid - 1;
            }
        }
        return result;
    }
}
