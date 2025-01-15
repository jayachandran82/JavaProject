package leetcode;

public class Reverse_Int_Value {

    static public int reverse(int x) {
        int reverse = 0;

        while (x != 0) {
            int num = x % 10;
            if (reverse > Integer.MAX_VALUE / 10 || reverse < Integer.MIN_VALUE / 10) {
                return 0;
            }
            reverse = reverse * 10 + num;
            x = x / 10;
        }
        return reverse;
    }

    public static void main(String[] args) {
        System.out.println(" Reverse Int Value Scenario 1 : " + reverse(5678));
        System.out.println(" Reverse Int Value Scenario 2 : " + reverse(-123));
        System.out.println(" Reverse Int Value Scenario 3 : " + reverse(120));

    }

}
