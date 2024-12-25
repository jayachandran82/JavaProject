package leetcode_easy;

/**
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 * <p>
 * Example 1:
 * Input: nums = [3,2,3]
 * Output: 3
 * <p>
 * Example 2:
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 * <p>
 * https://www.youtube.com/watch?v=wD7fs5P_MVo&ab_channel=NikhilLohia
 * <p>
 * Time Complexity : O(n)
 * Space Complexity: O(1)
 */
public class Majority_Element {
    public static void main(String[] args) {
        int[] nums1 = {3, 2, 3};
        int majorityScenario_1 = majorityElement(nums1);
        System.out.println("Majority Scenario-1:  " + majorityScenario_1);

        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        int majorityScenario_2 = majorityElement(nums2);
        System.out.println("Majority Scenario-2 :  " + majorityScenario_2);
    }

    static private int majorityElement(int[] nums) {
        int votes = 0;
        int majority = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (majority == 0) {
                majority = nums[i];
                votes++;
            } else if (majority == nums[i]) {
                votes++;
            } else {
                votes--;
            }
        }
        return majority;
    }
}
