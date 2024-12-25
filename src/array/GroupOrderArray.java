package array;

public class GroupOrderArray {
    public static void main(String[] args) {
        int arr[] = {0, 1, 1, 2, 1, 2, 2, 3};

        for (int i = 0; i < arr.length; i++) {
            int temp = 0;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int a : arr) {
            System.out.print(  a);
        }
    }
}
