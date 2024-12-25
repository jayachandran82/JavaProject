package _test;

import java.util.Arrays;

public class Sample {

    public static void main(String[] args) {
        String pattern = "ababd";
        int[] lps = computeLPSArray(pattern);
        System.out.println("Result : " + Arrays.toString(lps));

    }

    // Function to compute the LPS (The Longest Prefix Suffix) array
    private static int[] computeLPSArray(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int length = 0; // length of the previous longest prefix suffix
        int i = 1;

        lps[0] = 0; // LPS of the first character is always 0

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

}
