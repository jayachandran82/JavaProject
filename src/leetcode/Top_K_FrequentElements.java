package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Top K Frequent Elements
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 * <p>
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 */
public class Top_K_FrequentElements {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;

        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        List<Integer> bucket[] = new List[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> topK = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0 && topK.size() < k; i--) {
            if (bucket[i] != null) {
                topK.addAll(bucket[i]);
            }
        }

        topK.forEach(i -> System.out.print(i + " "));
    }

}
