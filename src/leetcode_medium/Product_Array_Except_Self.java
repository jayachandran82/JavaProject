package leetcode_medium;

import java.util.Arrays;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 * <p>
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * <p>
 * https://www.youtube.com/watch?v=G9zKmhybKBM&ab_channel=NikhilLohia
 * <p>
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class Product_Array_Except_Self {
    // result[i] = multiply all on left * multiply all on right

    //              [ 3  ,    4  ,   6 ,   1   ,   2     ]
    // Left              | 3     | 3*4 | 3*4*6 | 3*4*6*1
    // Right    4*6*1*2  | 6*1*2 | 1*2 | 2     |

    //            [  48  ,  36   , 24  ,  144  ,  72  ]

    static private int[] productExceptSelf(int[] nums) {
        int left[] = new int[nums.length];
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];

        }

        int right[] = new int[nums.length];
        right[nums.length - 1] = 1;
        for (int i = nums.length - 2; i > -1; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {3, 4, 6, 1, 2};
        int result[] = productExceptSelf(nums);
        System.out.println("Product of Array Except Self : " + Arrays.toString(result));
    }
}
