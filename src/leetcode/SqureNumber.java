package leetcode;

public class SqureNumber {
	public static void main(String[] args) {
		SqureNumber sq = new SqureNumber();
		System.out.println(" Return Value :  " + sq.sqr(9));
	}
	public int sqr(int x) {
		if (x == 0)
			return 0;
		int start = 1, end = x;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (mid <= x / mid && (mid + 1) > x / (mid + 1)) {
				return mid;
			} else if (mid > x / mid) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}

}
