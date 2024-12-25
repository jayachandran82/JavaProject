package algorithm;

/**
First Pass:
( 5 1 4 2 8 ) –> ( 1 5 4 2 8 ), Here, algorithm compares the first two elements, and swaps since 5 > 1.
( 1 5 4 2 8 ) –>  ( 1 4 5 2 8 ), Swap since 5 > 4
( 1 4 5 2 8 ) –>  ( 1 4 2 5 8 ), Swap since 5 > 2
( 1 4 2 5 8 ) –> ( 1 4 2 5 8 ), Now, since these elements are already in order (8 > 5), algorithm does not swap them.

Second Pass:
( 1 4 2 5 8 ) –> ( 1 4 2 5 8 )
( 1 4 2 5 8 ) –> ( 1 2 4 5 8 ), Swap since 4 > 2
( 1 2 4 5 8 ) –> ( 1 2 4 5 8 )
( 1 2 4 5 8 ) –>  ( 1 2 4 5 8 )
Now, the array is already sorted, but our algorithm does not know if it is completed. The algorithm needs one whole pass without any swap to know it is sorted.
 */
public class BubbleSort {
	public static void main(String[] args) {
		BubbleSort bs = new BubbleSort();
		int arr[] = { 64, 34, 25, 12, 22, 11, 90 };
		bs.printArray(arr);
		bs.sort(arr);
		bs.printArray(arr);
	}

	void sort(int arr[]) {
		int len = arr.length - 1;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len - 1 -i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;

				}
			}
		}
	}

	void printArray(int arr[]) {
		for (int i : arr)
			System.out.print(i + " ");
		System.out.println();
	}
}
