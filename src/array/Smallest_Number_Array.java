package array;

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1): Only a single extra variable (min) is used to store the smallest element
 */
public class Smallest_Number_Array {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 1, 5, 9, 2};
        int result = smallestNumber(arr);
        System.out.println("Smallest Number : " + result);
    }

    public static int smallestNumber(int[] arr) {
        // Initialize the minimum number as the first element in the array
        int small = arr[0];

        // Traverse the array starting from the second element
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < small) {
                small = arr[i]; // Update min if a smaller number is found
            }
        }
        return small;
    }
}
