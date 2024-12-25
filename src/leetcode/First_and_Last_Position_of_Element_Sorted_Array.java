package leetcode;

import java.util.Arrays;

public class First_and_Last_Position_of_Element_Sorted_Array {

    public static int[] searchRange(int[] nums, int target) {
        int first = -1, last = -1;
        for (int i = 0; i < nums.length; i++) {
            if (target != nums[i]) {
                continue;
            }
            if (first == -1) {
                first = i;
            }
            last = i;

        }
        return new int[]{first, last};
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));

    }

}
