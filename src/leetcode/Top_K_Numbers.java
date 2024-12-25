package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Top_K_Numbers {
    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 12, 2, 11};
        int k = 3;

        int[] topK = findTopK(nums, k);
        System.out.println("Result :" + Arrays.toString(topK));
    }

    static int[] findTopK(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] topK = new int[k];
        for (int i = 0; i < k; i++) {
            topK[i] = minHeap.poll();
        }
        return topK;
    }
}
