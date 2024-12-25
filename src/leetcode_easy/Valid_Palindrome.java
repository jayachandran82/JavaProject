package leetcode_easy;

/**
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * <p>
 * Example 1:
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 */
public class Valid_Palindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean palindrome = isPlalindrome(s);
        System.out.println("Valid Palindrome : " + palindrome);

    }

    static private boolean isPlalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (!Character.isLetterOrDigit(str.charAt(start))) {
                start++;
                continue;
            }
            if (!Character.isLetterOrDigit(str.charAt(end))) {
                end--;
                continue;
            }
            if (Character.toLowerCase(str.charAt(start)) != Character.toLowerCase(str.charAt(end))) {
                return false;
            } else {
                start++;
                end--;
            }

        }

        return true;
    }
}
