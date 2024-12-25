package algorithm;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {8, 7, 1, 9, 4, 2, 6};
        inserSortArray(arr);
    }

    public static void inserSortArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int a = i - 1;
            int b = arr[i];
            while (a >= 0 && b <= arr[a]) {
                arr[a + 1] = arr[a];
                a = a - 1;
            }
            arr[a + 1] = b;
        }

        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k] + " ");
        }
    }
}
