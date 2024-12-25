package general;

public class RecursionSum {

	public static void main(String[] args) {
		//1+2+3
		int val = sum(6); // sum(3);
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
	
	static int sum(int number) {
		if (number == 0) {
			return 0;
		}
		
		return number+sum(number-1);
		// 3+ sum(2) = 3+ 3 = 6
		// 2+ sum(1) = 2+ 1 = 3
		// 1+ sum(0) = 1+0 = 1
		// sume(0) = 0
	}

}
