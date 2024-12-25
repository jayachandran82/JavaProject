package leetcode_easy;

import java.util.Arrays;
import java.util.Stack;

/**
 * You are given an integer array prices where prices[i] is the price of the ith item in a shop.
 * There is a special discount for items in the shop. If you buy the ith item, then you will receive a discount equivalent to prices[j] where j is the minimum index such that j > i and prices[j] <= prices[i]. Otherwise, you will not receive any discount at all.
 * Return an integer array answer where answer[i] is the final price you will pay for the ith item of the shop, considering the special discount.
 * <p>
 * Example 1:
 * Input: prices = [8,4,6,2,3]
 * Output: [4,2,4,2,3]
 * Explanation:
 * For item 0 with price[0]=8 you will receive a discount equivalent to prices[1]=4, therefore, the final price you will pay is 8 - 4 = 4.
 * For item 1 with price[1]=4 you will receive a discount equivalent to prices[3]=2, therefore, the final price you will pay is 4 - 2 = 2.
 * For item 2 with price[2]=6 you will receive a discount equivalent to prices[3]=2, therefore, the final price you will pay is 6 - 2 = 4.
 * For items 3 and 4 you will not receive any discount at all.
 * <p>
 * Time complexity: O(n)
 * Space complexity: O(n)  The stack can hold at most n elements in the worst case, leading to a linear space complexity.
 *
 * https://www.youtube.com/watch?v=oIPZLxC-fWk&ab_channel=Techdose
 */
public class Final_Prices_With_Special_Discount_Shop {

    private static int[] finalPrices(int[] prices) {
        Stack<Integer> st = new Stack<>();
        int n = prices.length;
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() > prices[i]) {
                st.pop();
            }
            int discount = 0;
            if (!st.isEmpty()) {
                discount = st.peek();
            }
            ans[i] = prices[i] - discount;
            st.push(prices[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] input = {8,4,6,2,3};
        int[] result = finalPrices(input);
        System.out.println("Final Prices : " + Arrays.toString(result));
    }
}
