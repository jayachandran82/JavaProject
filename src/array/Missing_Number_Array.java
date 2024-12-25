package array;

/**
 * Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 * <p>
 * Input: nums = [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
 * <p>
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * https://www.youtube.com/watch?v=iCrQG_kbuP0&ab_channel=NikhilLohia
 */
public class Missing_Number_Array {
    public static void main(String[] args) {
        int nums[] = {9, 6, 4, 2, 3, 5, 7, 0, 1};


        System.out.println(" Missing number - Sum Method : " + missingNumber(nums));
        System.out.println(" Missing number - XOR Method : " + missingNumberXOR(nums));
    }

    //Sum method. It's causing stack overflow for large number.
    // Time Complexity : O(n)
    // Space complexity : O(1)
    static int missingNumber(int[] arr) {
        int n = arr.length; // N is the size of the array plus 1 (including the missing number)
        int sumofArray = n * (n + 1) / 2;

        int countOfArray = 0;
        for (int num : arr) {
            countOfArray = countOfArray + num;
        }

        int missNumb = sumofArray - countOfArray;
        return missNumb;
    }

    //XOR method
    // Time Complexity : O(n)
    // Space complexity : O(1)
    static int missingNumberXOR(int[] nums) {

        int allXOR = 0;

        // XOR all numbers in range [0, n]
        for (int i = 0; i <= nums.length; i++) {
            allXOR = allXOR ^ i;
        }

        // XOR all numbers in the given array
        for (int num : nums) {
            allXOR = allXOR ^ num;
        }

        // The missing number
        return allXOR;
    }

}
