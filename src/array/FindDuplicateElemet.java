package array;

import java.util.Arrays;

public class FindDuplicateElemet {

	public static void main(String[] args) {
		int tempCount = 0;
		String duplicates = new String();
		int[] numbers = { 7, 2, 6, 1, 4, 7, 4, 5, 4, 7, 7, 3, 1, 7 };
		Arrays.sort(numbers);
		System.out.println("number  : "+Arrays.toString(numbers));
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] == numbers[i - 1]) {
				if ((tempCount == 0)) { // If same number is repeated more than
										// two times, like 444, 7777
					tempCount = tempCount + 1;
					duplicates = duplicates.concat(Integer.toString(numbers[i]) + ",");
				}
			} else {
				tempCount = 0;
			}
		}
		System.out.println("duplicates :: " + duplicates);
	}

}
