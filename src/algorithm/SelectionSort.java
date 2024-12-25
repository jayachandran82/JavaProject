package algorithm;

/**
arr[] = 64 25 12 22 11

Find the minimum element in arr[0...4]  and place it at beginning
11 25 12 22 64

Find the minimum element in arr[1...4] and place it at beginning of arr[1...4]
11 12 25 22 64

Find the minimum element in arr[2...4] and place it at beginning of arr[2...4]
11 12 22 25 64

Find the minimum element in arr[3...4] and place it at beginning of arr[3...4]
11 12 22 25 64
 */
public class SelectionSort {
	void sort(int arr[]) {
		for (int i = 0; i < arr.length - 1; i++) {
			// Find the minimum element in unsorted array
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[i]) {    //64 25 12 22 11
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
	}

	void printArray(int arr[]) {
		for (int i : arr)
			System.out.print(i + " ");
		System.out.println();
	}

	public static void main(String args[]) {
		SelectionSort ob = new SelectionSort();
		int arr[] = { 64, 25, 12, 22, 11 };
		ob.printArray(arr);
		ob.sort(arr);
		System.out.println("Sorted array");
		ob.printArray(arr);
	}
}
