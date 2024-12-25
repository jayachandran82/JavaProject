package leetcode_easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
 * <p>
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * <p>
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Explanation: [9,4] is also accepted.
 * <p>
 * Time Complexity: O(n+m)
 * Space Complexity: O(n)
 */
public class Intersection_Two_Arrays_II {

    private static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums1) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> intesections = new ArrayList<>();
        for (int num : nums2) {
            if (frequencyMap.getOrDefault(num, 0) > 0) {
                intesections.add(num);
                frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) - 1);
            }
        }
        int[] result = new int[intesections.size()];
        int count = 0;
        for (int i = 0; i < intesections.size(); i++) {
            result[count++] = intesections.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = intersect(nums1, nums2);
        System.out.println(" Result : " + Arrays.toString(result));
    }
}
