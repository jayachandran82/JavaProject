package algorithm;

public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();

        int[] arr = {2, 4, 6, 8, 10, 12, 14, 16};
        System.out.println("Key 14's position: " + binarySearch.binarySearch(arr, 14));
        int[] arr1 = {6, 34, 78, 123, 432, 900};
        System.out.println("Key 432's position: " + binarySearch.binarySearch(arr1, 432));
    }

    public int binarySearch(int[] inputArr, int key) {

        int start = 0;
        int end = inputArr.length - 1;
        while (start <= end) {
            // First, find the middle of start and end. An easy way to find the middle would be: middle = (start + end) / 2.
            // But this has a good chance of producing an integer overflow
            // so it’s recommended that you represent the middle as: middle = start + (end — start) / 2
            int mid = start + (end - start) / 2;
            if (inputArr[mid] == key) {
                return mid;
            }
            if (inputArr[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
