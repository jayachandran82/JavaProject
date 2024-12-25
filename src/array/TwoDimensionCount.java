package array;

import java.util.HashMap;

public class TwoDimensionCount {

	public static void main(String[] args) {
		int arrlist[][] = { { 0, 0, 0, 0, 0 }, { 0, 1, 1, 0, 0 }, { 0, 0, 0, 1, 1 }, { 1, 1, 1, 1, 0 },
				{ 0, 0, 0, 0, 0 } };
		HashMap<String, Integer> map = new HashMap<>();
		System.out.println("New Line... \n");

		int count = 0;
		int temp = 0;
		for (int i = 0; i < arrlist.length; i++) {
			for (int j = 0; j < arrlist[i].length; j++) {
				System.out.print(arrlist[i][j] + " ");
				if (arrlist[i][j] == 1) {
					if (temp == 0) {
						temp++;
						count++;
						map.put("number of 1's", count);
					}
				}
			}
			temp = 0;
			System.out.println();
		}
		map.entrySet().forEach(e -> System.out.println("Key name" + e.getKey() + " Value: " + e.getValue()));
	}
}
