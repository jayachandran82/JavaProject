package array;

import java.util.*;

/**
 * Given an array of strings strs, group the  anagrams together. You can return the answer in any order.
 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Explanation:
 * There is no string in strs that can be rearranged to form "bat".
 * The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
 * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
 */
public class AnagramGroups {

    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> frequencyString = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            if (!frequencyString.containsKey(sortedStr)) {
                frequencyString.put(sortedStr, new ArrayList<>());
            }
            frequencyString.get(sortedStr).add(str);

        }
        return new ArrayList<>(frequencyString.values());
    }

    public static void main(String[] args) {
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(arr);
        System.out.println("Group Anagrams: " + result);

        /*for (List<String> group : arrSorted.values()) {
            if (group.size() > 1) {
                System.out.println(group + " contains the same characters ");
            }

        }*/
    }
}
