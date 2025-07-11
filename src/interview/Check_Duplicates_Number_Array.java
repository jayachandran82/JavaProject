package interview;

/**
 * LeetCode 442
 * Better Solution (Conditional) : O(n) time and O(1) extra space.
 * <p>
 * This solution works only if array has positive integers and all the elements in the array are in range from 0 to n-1 where n is the size of the array.
 * Navigate the array.
 * Update the array as for ith index :- arrA[arrA[i]] = arrA[arrA[i]]*-1 (if it already not negative).
 * If is already negative, we have duplicates, return false.
 * Note:
 * <p>
 * The code given below does not handle the case when 0 is present in the array.
 * To handle 0 in array, while navigating the array, when 0 is encountered, replace it with INT_MIN and if INT_MIN is encountered while traversing, this means 0 is repeated in the array.
 * <p>
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * <p>
 * https://www.youtube.com/watch?v=lFhiz9ntwqk&ab_channel=NikhilLohia
 */
public class Check_Duplicates_Number_Array {

    // Method to find duplicate using index marking (negation technique)
    public static int findDuplicate(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]) - 1; // Get the index by subtracting 1 from the absolute value

            // If the value at this index is already negative, we found the duplicate
            if (arr[index] < 0) {
                return Math.abs(arr[i]);
            }

            // Mark this index by making the value at this index negative
            arr[index] = -arr[index];
        }

        return -1; // No duplicate found
    }

    public static void main(String[] args) {
        int arr[] = {1, 6, 5, 2, 3, 3, 2};
        int duplicate = findDuplicate(arr);

        if (duplicate != -1) {
            System.out.println("Duplicate number: " + duplicate);
        } else {
            System.out.println("No duplicates found.");
        }
    }
}
