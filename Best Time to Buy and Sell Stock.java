/*121. You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0. */


class Solution {
    public int maxProfit(int[] prices) {
        int maxProfitSoFar = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int currentPrice = prices[i];
            int profitIfSoldToday =  currentPrice - min;
            if (currentPrice < min) {
                min = currentPrice;
            } else if ( profitIfSoldToday > maxProfitSoFar) {
                maxProfitSoFar = profitIfSoldToday;
            } 
        }
        return maxProfitSoFar;
        
    }
}
