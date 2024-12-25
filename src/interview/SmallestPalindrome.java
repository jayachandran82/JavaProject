package interview;

public class SmallestPalindrome {
    public static void main(String[] args) {
        System.out.println(" Final Value " + smallPalindrome("egcfe"));
    }

    static String smallPalindrome(String s) {
        char[] ch = s.toCharArray();
        for (int i = 0, j = s.length() - 1; i < s.length(); i++, j--) {
            if (ch[i] != ch[j]) {
                ch[i] = ch[j] = (char) Math.min(ch[i], ch[j]);
            }
        }
        String str = String.valueOf(ch);
        return str;

    }
}
