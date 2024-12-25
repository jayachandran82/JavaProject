package array;

import java.util.*;

public class AnagramGroups {
    public static void main(String[] args) {
        String[] arr = {"abcd", "java", "dcba", "ajav", "xyz", "epam", "pame", "aepm"};
        Map<String, List<String>> arrSorted = new HashMap<>();
        for (String str : arr) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            if (!arrSorted.containsKey(sortedStr)) {
                arrSorted.put(sortedStr, new ArrayList<>());
            }
            arrSorted.get(sortedStr).add(str);

        }
        for (List<String> group : arrSorted.values()) {
            if (group.size() > 1) {
                System.out.println(group + " contains the same characters ");
            }

        }
    }
}
