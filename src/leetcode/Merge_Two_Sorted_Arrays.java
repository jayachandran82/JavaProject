package leetcode;

import java.util.Arrays;

/**
 Reference : https://www.youtube.com/watch?v=xF3TU-QlhJQ
 Merging two arrays then sort the array will be called  O(n log n).
 This followed O(n) and it's comparing two arrays and merging to new array. Two arrays will be sorted before merging.
 */
//
public class Merge_Two_Sorted_Arrays {

	public static void main(String[] args) {
		int[] arr1 = { 2, 5, 6, 8, 9 };
		int[] arr2 = { 1, 3, 4, 7 };
		int i = 0, j = 0, k = 0;
		int[] arr3 = new int[arr1.length + arr2.length];
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				arr3[k] = arr1[i];
				i++;
				k++;
			} else {
				arr3[k] = arr2[j];
				j++;
				k++;
			}
		}
		while (i < arr1.length) {
			arr3[k++] = arr1[i++];
		}
		while (j < arr2.length) {
			arr3[k++] = arr1[j++];
		}
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr3));
	}

}
