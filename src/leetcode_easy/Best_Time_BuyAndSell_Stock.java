package leetcode_easy;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * <p>
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * <p>
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * <p>
 * https://www.youtube.com/watch?v=E2-heUEnZKU&t=690s&ab_channel=NikhilLohia
 */
public class Best_Time_BuyAndSell_Stock {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int scenario_1 = maxprofit(prices);
        System.out.println("Scenario One: " + scenario_1);
    }

    static private int maxprofit(int[] prices) {
        int buy_price = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy_price) {
                buy_price = prices[i];
            } else {
                int current_price = prices[i] - buy_price;
                profit = Math.max(current_price, profit);
            }
        }
        return profit;
    }
}
