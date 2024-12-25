package interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ResturantTimeBooking {
	public static void main(String[] args) {
		int[][] arr = { { 10, 11 }, { 11, 15}, { 12, 13, 14 }, { 12, 13 } };

		HashMap<Integer, Set<Integer>> result = new HashMap<>();

		Set<Integer> user = null;

		for (int i = 0; i < arr.length; i++) {
			System.out.println(" i Value : " + i);
			user = new HashSet<>();
			user.add(i);

			for (int j = 0; j < arr[i].length; j++) {
				System.out.println("       j Value : " + arr[i][j]);
				result.put(arr[i][j], user);
			}
		}
		
		result.forEach((k, v) -> System.out.println((k + ":" + v)));

	}

}
