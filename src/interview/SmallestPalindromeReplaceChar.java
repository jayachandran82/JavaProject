package interview;

import java.util.HashMap;
import java.util.Map;

public class SmallestPalindromeReplaceChar {

    public static String getSmallestPalindrome(String s) {
        int len = s.length();
        Map<Character, Integer> table = new HashMap<>();
        int count = 0;

        // Count occurrences of each character and '?'
        for (char ch : s.toCharArray()) {
            if (ch == '?') {
                count++;
            } else {
                table.put(ch, table.getOrDefault(ch, 0) + 1);
            }
        }

        // Count the number of characters that have odd occurrences.
        int odd = 0;
        for (int val : table.values()) {
            odd += val % 2;
        }

        // If the string length is odd, allow one odd character.
        if (odd > 0) {
            odd -= len % 2;
        }
        System.out.println("Adjust for odd length strings " + odd);

        //If the number of ? characters is less than the number of odd characters, return -1.
        if (count < odd) {
            return "-1";
        }

        int extra = count - odd;

        // Balance the counts to make as many characters even as possible
        for (Map.Entry<Character, Integer> entry : table.entrySet()) {
            char c = entry.getKey();
            int val = entry.getValue();
            if (odd > 0 && val % 2 == 1) {
                odd--;
                table.put(c, val + 1);
            }
        }

        table.put('a', table.getOrDefault('a', 0) + extra);

        StringBuilder ans = new StringBuilder();
        char oddChar = 'a';

        for (Map.Entry<Character, Integer> entry : table.entrySet()) {
            char c = entry.getKey();
            int val = entry.getValue();
            for (int i = 0; i < val / 2; i++) {
                ans.append(c);
            }
            if (val % 2 == 1) {
                oddChar = c;
            }
        }

        String firstHalf = ans.toString();
        String secondHalf = new StringBuilder(firstHalf).reverse().toString();

        return (len % 2 == 0) ? firstHalf + secondHalf : firstHalf + oddChar + secondHalf;
    }

    public static void main(String[] args) {
        String s = "a?b?c?";
        System.out.println(getSmallestPalindrome(s)); // Output example
    }
}
