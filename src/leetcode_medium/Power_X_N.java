package leetcode_medium;

/**
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 * Example 1:
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 * <p>
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class Power_X_N {
    //Pow(x, n)

    static private double powerOfX(double x, int n) {

        long power = n;
        if (power < 0) {
            x = 1 / x;
            power = -power;
        }
        return helperMethod(x, power);
    }

    static private double helperMethod(double x, long power) {
        double result = 1.0;

        while (power > 0) {
            if (power % 2 == 1) {
                result *= x;
            }
            x *= x;
            power = power / 2;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Pow(x, n) : " + powerOfX(2.00000, 10)); // Output: 1024.0
        System.out.println("Pow(x, n) : " + powerOfX(2.10000, 3)); // Output: 9.261
        System.out.println("Pow(x, n) : " + powerOfX(2.00000, -2));  // Output: 0.25
    }
}
