package array;

public class ThreeDimensionalArray {

	public static void main(String[] args) {
		int[][][] arr = new int[3][3][3];
		int count = 1;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					System.out.print((arr[i][j][k] = count++) + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}

}
