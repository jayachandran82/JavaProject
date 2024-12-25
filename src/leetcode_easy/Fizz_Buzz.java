package leetcode_easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, return a string array answer (1-indexed) where:
 * answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
 * answer[i] == "Fizz" if i is divisible by 3.
 * answer[i] == "Buzz" if i is divisible by 5.
 * answer[i] == i (as a string) if none of the above conditions are true.
 * <p>
 * Example 1:
 * Input: n = 3
 * Output: ["1","2","Fizz"]
 */
public class Fizz_Buzz {
    private static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 5 == 0 && i % 3 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(Integer.toString(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 15;
        List<String> scenarioOne = fizzBuzz(n);
        System.out.println("Input Value :" + 15);
        System.out.println("Fizz Buzz Scenario - One : " + scenarioOne);

        List<String> scenarioTwo = fizzBuzz(5);
        System.out.println("Input Value :" + 5);
        System.out.println("Fizz Buzz Scenario - Two : " + scenarioTwo);
    }
}
