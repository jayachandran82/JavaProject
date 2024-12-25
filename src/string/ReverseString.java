package string;

public class ReverseString {
    public static void main(String[] args) {
        String input = "example";
        String result = revers(input);
        System.out.println("Input " + input);
        System.out.println("Output " + result);

    }

    public static String revers(String st) {
        char[] charArr = st.toCharArray();
        int start = 0;
        int end = charArr.length - 1;
        while (start < end) {
            char temp = charArr[start];
            charArr[start] = charArr[end];
            charArr[end] = temp;
            start++;
            end--;
        }
        return new String(charArr);
    }
}
