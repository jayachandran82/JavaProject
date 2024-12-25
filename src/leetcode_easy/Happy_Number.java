package leetcode_easy;

import java.util.HashSet;

/**
 * Write an algorithm to determine if a number n is happy.
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * <p>
 * https://www.youtube.com/watch?v=LkD0D0Xy-ro&ab_channel=NikhilLohia
 * Time Complexity: O(1)   >> we do not do any binary operations. O(1) actually means constant time. So we know that no matter what is the test case, it will always finish in a certain amount of time.
 * Space Complexity: O(1)  >> You will never have the sum of digits that is more than 1000. That means no matter the input size, the hashset has a maximum size. Hence constant space
 */
public class Happy_Number {
    private static boolean isHappy(int n) {
        HashSet<Integer> unsedInteger = new HashSet<>();
        while (true) {
            int sum = 0;

            // The maximum number of digits are 9, as defined by the problem statement. So you know that it will not be greater than O(9), and that means a constant time. Hence O(1)
            while (n != 0) {
                sum += Math.pow(n % 10, 2.0);
                n = n / 10;
            }
            if (sum == 1) return true;
            n = sum;

            if (unsedInteger.contains(sum)) return false;
            unsedInteger.add(sum);
        }
    }

    public static void main(String[] args) {

        int m = 19;
        boolean scenario_1 = isHappy(m);
        System.out.println("isHappy  Scenario One: " + scenario_1);

        int n = 61;
        boolean scenario_2 = isHappy(n);
        System.out.println("isHappy Scenario Two: " + scenario_2);

    }
}
