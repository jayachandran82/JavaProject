package leetcode_medium;

/**
 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
 * countAndSay(1) = "1"
 * countAndSay(n) is the run-length encoding of countAndSay(n - 1).
 * Run-length encoding (RLE) is a string compression method that works by replacing consecutive identical characters (repeated 2 or more times) with the concatenation of the character and the number marking the count of the characters (length of the run). For example, to compress the string "3322251" we replace "33" with "23", replace "222" with "32", replace "5" with "15" and replace "1" with "11". Thus the compressed string becomes "23321511".
 * Given a positive integer n, return the nth element of the count-and-say sequence.
 * <p>
 * Example 1:
 * Input: n = 4
 * Output: "1211"
 * <p>
 * Explanation:
 * countAndSay(1) = "1"
 * countAndSay(2) = RLE of "1" = "11"
 * countAndSay(3) = RLE of "11" = "21"
 * countAndSay(4) = RLE of "21" = "1211"
 * <p>
 * https://www.youtube.com/watch?v=PwjPSv7qPB8&ab_channel=AlgoTamizha
 * <p>
 * Time Complexity: O(n^2)
 * Space Complexity: O(n^2)
 */
public class Count_And_Say {
    static private String countAndSay(int n) {
        if (n == 1) return "1";
        String current = "1";
        for (int i = 2; i <= n; i++) {
            current = getNextSequence(current);
        }
        return current;
    }

    static String getNextSequence(String input) {
        StringBuilder res = new StringBuilder();
        int count = 1;
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                res.append(count).append(input.charAt(i - 1));
                count = 1;
            }
        }
        res.append(count).append(input.charAt(input.length() - 1));
        return res.toString();
    }

    public static void main(String[] args) {
        String result = countAndSay(4);
        System.out.println("Count and Say : " + result);
    }
}
