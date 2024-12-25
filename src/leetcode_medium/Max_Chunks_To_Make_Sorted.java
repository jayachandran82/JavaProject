package leetcode_medium;

/**
 * You are given an integer array arr of length n that represents a permutation of the integers in the range [0, n - 1].
 * We split arr into some number of chunks (i.e., partitions), and individually sort each chunk. After concatenating them, the result should equal the sorted array.
 * Return the largest number of chunks we can make to sort the array.
 * <p>
 * Example 1:
 * Input: arr = [4,3,2,1,0]
 * Output: 1
 * Explanation:
 * Splitting into two or more chunks will not return the required result.
 * For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.
 * <p>
 * https://www.youtube.com/watch?v=r5-HS3HyjIE&ab_channel=Techdose
 * <p>
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class Max_Chunks_To_Make_Sorted {
    private static int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int max_seen = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            max_seen = Math.max(max_seen, arr[i]);
            if (max_seen == arr[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1, 0};
        int maxChunk_Scenario_One = maxChunksToSorted(arr);
        System.out.println("Max Chunks To Make Sorted Scenario One :  " + maxChunk_Scenario_One);

        int[] arr1 = {1, 0, 2, 3, 4};
        int maxChunk_Scenario_Two = maxChunksToSorted(arr1);
        System.out.println("Max Chunks To Make Sorted Scenario Two :  " + maxChunk_Scenario_Two);
    }
}
