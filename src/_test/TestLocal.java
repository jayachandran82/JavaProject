package _test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestLocal {
    public static void main(String[] args) {
        TestLocal obj = new TestLocal();
        String s = "a1b2";
        List<String> result = obj.findPermutation(s);
        System.out.println(" Result : " + Arrays.toString(result.toArray()));

    }

    private List<String> findPermutation(String str) {
        List<String> res = new ArrayList<>();
        findAllPermutation(res, str, 0);
        return res;
    }

    void findAllPermutation(List<String> res, String str, int start) {
        res.add(str);
        for (int i = start; i < str.length(); i++) {
            char[] wordArray = str.toCharArray();
            if (Character.isLetter(str.charAt(i))) {
                if (Character.isUpperCase(str.charAt(i))) {
                    wordArray[i] = Character.toLowerCase(str.charAt(i));
                    findAllPermutation(res, String.valueOf(wordArray), i + 1);
                } else {
                    wordArray[i] = Character.toUpperCase(str.charAt(i));
                    findAllPermutation(res, String.valueOf(wordArray), i + 1);
                }
            }
        }
    }
}
