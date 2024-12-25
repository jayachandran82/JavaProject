package array;

import java.util.Arrays;

/**
 * Given an integer array nums, rotate the array to the left/right by k steps, where k is non-negative.
 *
 * https://www.youtube.com/watch?v=sIzV1SDc-yQ&ab_channel=NikhilLohia
 *
 * Time Complexity of O(n)
 * Space complexity of O(1)
 */
public class Rotation_Array_Left_Right {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int d = 2; // number of rotations
        System.out.println("K value : " + d);
        System.out.println("Actual Array" + Arrays.toString(arr));

        leftRotate(arr, d);
        System.out.println("Left Rotation Array" + Arrays.toString(arr));
        //rightRotate(arr, d);
        //System.out.println("Right Rotation Array" + Arrays.toString(arr));


    }

    //1, 2, 3, 4, 5
    //5, 4, 3, 2, 1
    //3, 4 ,5, 2, 1
    //3, 4 ,5, 1, 2
    // Function to perform left rotation
    public static void leftRotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n;  // In case d is greater than array length
        reverse(arr, 0, n - 1);
        reverse(arr, 0, n - k - 1);
        reverse(arr, n - k, n - 1);
    }

    // Function to perform right rotation
    public static void rightRotate(int[] arr, int d) {
        int n = arr.length;
        d = d % n;  // In case d is greater than array length
        reverse(arr, 0, n - d - 1);
        reverse(arr, n - d, n - 1);
        reverse(arr, 0, n - 1);
    }

    // Function to reverse elements in an array within a specified range
    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}