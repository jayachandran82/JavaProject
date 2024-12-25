package leetcode_easy;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 * Note that in some languages, such as Java, there is no unsigned integer type. In this case, both input and output will be given as a signed integer type. They should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above, the input represents the signed integer -3 and the output represents the signed integer -1073741825.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 00000010100101000001111010011100
 * Output:    964176192 (00111001011110000010100101000000)
 * Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
 * <p>
 * Time complexity: O(32)=O(1), since the number of bits (32) is constant.
 * Space complexity: O(1)
 */
public class Reverse_Bits {
    private static int reverseBits(int n) {
        int reverse = 0;
        for (int i = 0; i < 32; i++) {
            // Extract the last bit of n
            int lastBit = (n & 1);

            // Shift reversed to the left and add the last bit
            reverse = (reverse << 1) | lastBit;

            // Shift n to the right to process the next bit
            n >>= 1;

        }
        return reverse;
    }

    public static void main(String[] args) {
        int n = 43261596; // Example input: 0b00000010100101000001111010011100
        System.out.println("Input Value : " + n);
        int reversed = reverseBits(n);
        System.out.println("Reversed bits: " + reversed);
        System.out.println("Binary representation: " + Integer.toBinaryString(reversed));
    }
}
