package leetcode;

/**
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors.
 * '#' means a backspace character.
 * <p>
 * Note that after backspacing an empty text, the text will continue empty.
 * <p>
 * Input: s = "ab#c", t = "ad#c"
 * Output: true
 * Explanation: Both s and t become "ac".
 */
public class Backspace_String_Compare {
    public static void main(String[] args) {
        String s = "ab#c";
        String t = "ad#c";
        boolean status = backspaceStringCompare(s, t);
        System.out.println("Status : " + status);
    }

    private static boolean backspaceStringCompare(String s, String t) {
        return getString(s).equals(getString(t));
    }

    private static String getString(String str) {
        StringBuilder result = new StringBuilder();
        int hashCount = 0;

        // Keep a count of backspace characters
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '#') {
                hashCount++;
                continue;
            }

            // If backspace count > 0 reduce it and skip the character
            if (hashCount > 0) {
                hashCount--;
            } else {
                // If no backspace, just insert at beginning
                result.insert(0, str.charAt(i));
            }
        }
        return result.toString();
    }
}
