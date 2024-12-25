package leetcode_easy;

/**
 * Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.
 * <p>
 * For example:
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 */
public class Excel_Sheet_Column_Number {
    public static void main(String[] args) {
        String s = "AB";
        int scenario_1 = titleToNumber(s);
        System.out.println(" Scenario one : " + scenario_1);
    }

    private static int titleToNumber(String s) {
        int result = 0;
        for (char c : s.toCharArray()) {
            int d = c - 'A' + 1;
            result = result * 26 + d;
        }
        return result;
    }
}
