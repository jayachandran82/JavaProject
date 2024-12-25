package leetcode_easy;

/**
 * Given a positive integer n, write a function that returns the number of set bits in its binary representation (also known as the Hamming weight).
 * <p>
 * Example 1:
 * Input: n = 11
 * Output: 3
 * Explanation:
 * The input binary string 1011 has a total of three set bits.
 */
public class Number_of_1_Bits {
    static private int hammingWeight(int n) {
        int count = 0, mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) count++;
            mask = mask <<= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 11; // Example input
        System.out.println("Number of set bits: " + hammingWeight(n)); // Output: 3

    }
}
