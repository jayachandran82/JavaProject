package leetcode;

public class Fibonacci {
	public static void main(String[] args) {
		//1+2+3
		int val = fibonacci(6); // sum(3);
		System.out.println("\n Val : " + val);

	}
	// 1,1,2,3,5,8
	public static int fibonacci(int number){
		if(number == 1 || number == 2){
			return 1;
		}

		return fibonacci(number-1) + fibonacci(number -2); //tail recursion
		// 1+2 = 3
	}
}
