package leetcode;

public class Reverse_Int_Value {

	public static void main(String[] args) {
		System.out.println(" Result : " + reverse(5678));

	}

	static public int reverse(int x) {
		int reverse = 0;

		while (x > 0) {
			int num = x % 10;
			reverse = reverse * 10 + num;
			x = x / 10;
		}
		return reverse;
	}

}
