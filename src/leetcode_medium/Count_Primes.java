package leetcode_medium;

/**
 * Given an integer n, return the number of prime numbers that are strictly less than n.
 * Example 1:
 * Input: n = 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * <p>
 * https://www.youtube.com/watch?v=UMVa5fRKC8I&ab_channel=KevinNaughtonJr.
 * https://www.youtube.com/watch?v=fI6kv_GtKlM&ab_channel=NideeshTerapalli
 * <p>
 * Time Complexity: O(N log (log n))
 * Space Complexity: O(N)
 */
public class Count_Primes {
    //Count Prime Numbers
    private static int countPrimes(int n) {
        int count = 0;
        boolean[] primes = new boolean[n];

        for (int i = 2; i * i < n; i++) {
            if (!primes[i]) {
                for (int j = i; i * j < n; j++) {
                    primes[i * j] = true;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            if (!primes[i]) {
                count += 1;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(" Count Prime Number : " + countPrimes(10));
    }
}
