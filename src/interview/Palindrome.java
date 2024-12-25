package interview;

public class Palindrome {

	public static void main(String[] args) {
		String[] arr = { "tab", "aop", "bat", "wre", "avs", "erw" };
		int len = arr.length;
		System.out.println( "Array String Length : "+len);
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				String reverFirstStr = reverseStr(arr[i].toCharArray());
				if (reverFirstStr.equals(arr[j])) {
					System.out.println(i + ", " + j);
					System.out.println(arr[i] + ", " +arr[j]);
				}
			}
		}
	}

	static String reverseStr(char[] ch) {
		String str = new String();
		for (int i = ch.length - 1; i >= 0; i--) {
			str = str + ch[i];
		}
		return str;
	}

}
