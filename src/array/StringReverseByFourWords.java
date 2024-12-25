package array;

public class StringReverseByFourWords {
	public static void main(String[] args) {
		String words = "abcdefghijklmnopqr";
		int delimit = 4;
		for (int i = 0; i < words.length(); i = i + delimit) {
			if (words.length() >= i + delimit) {
				String sub = reverseString(words.substring(i, i + delimit));
				System.out.print(sub + ":");
			}else {
				String sub = reverseString(words.substring(i, words.length()));
				System.out.println(sub );
			}
		}
	}

	private static String reverseString(String str) {
		String reverse = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			reverse = reverse + str.charAt(i);
		}
		return reverse;
	}

}
