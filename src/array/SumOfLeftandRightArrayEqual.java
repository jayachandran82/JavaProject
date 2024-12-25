package array;

public class SumOfLeftandRightArrayEqual {

	public static void main(String[] args) {
		int arr[] = { 1, 4, 2, 5 };
		int n = arr.length;
		System.out.println("Array Length : "+n);
		System.out.println("\n"+findElement(arr, n));

	}

	/**
	 * Finds an element in an array such that left and right side sums are equal
	 */
	static int findElement(int arr[], int n) {
		// Forming prefix sum array from 0
		int[] prefixSum = new int[n];
		prefixSum[0] = arr[0];
		for (int i = 1; i < n; i++) {
			prefixSum[i] = prefixSum[i - 1] + arr[i];
		}
		for(int i :prefixSum) {
			System.out.println(" Prefix Value : "+i);
		}

		// Forming suffix sum array from n-1
		int[] suffixSum = new int[n];
		suffixSum[n - 1] = arr[n - 1];
		for (int j = n - 2; j >= 0; j--) {
			suffixSum[j] = suffixSum[j + 1] + arr[j];
		}
		for(int  i : suffixSum) {
			System.out.println("Suffix Value : "+i);
		}
		// Find the point where prefix and suffix sums are same.
		for (int i = 1; i < n - 1; i++) {
			System.out.print( i);
			if (prefixSum[i] == suffixSum[i])
				return arr[i];
		}
		return -1;
	}

}
