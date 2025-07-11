package leetcode;

public class Factorial {
    public static void main(String[] args) {
        System.out.println("Value : " + factorial(5));
    }

    private static int factorial(int x) {
        System.out.println("X Value: " + x);
        if (x == 0)
            return 1;
        return x * factorial(x - 1);

    }
}
