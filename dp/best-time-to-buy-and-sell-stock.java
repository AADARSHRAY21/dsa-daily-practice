/*
 * Problem: best-time-to-buy-and-sell-stock (LeetCode #121)
 * Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * Difficulty: Easy
 * Pattern: "Track the minimum so far and maximize the difference."
 * Topics: arrays, dp
 *
 * Approach (in my own words):
 * -
 *
 * Time Complexity: O(n),One-pass min + max profit
 * Space Complexity: 0(1).
 *
 * Needed hint? Yes to improve answer
 * Notes : Buy at the cheapest price seen so far, sell at today's price, and keep the best profit.
 * Revisit on: (7 days from 2026-09-03)
 */

class Solution {
    public int maxProfit(int[] prices) {
    // int n = prices.length;
    // int minprices = prices[0];
    // int max =0;
    // for(int i =1; i < n ; i++){
    // int profit = prices[i] - minprices;
    //  if (profit > maxProfit) { 
    //    maxProfit = profit; 
    //}
    //     if(prices[i] < minprices) {
    //         minprices = prices[i];
    //     }
    //     
    
    // if(profit  > max) {
    //    max = profit;
    // }
    // }
    // return max;

    //OR

    int n = prices.length;
    int minprices = Integer.MAX_VALUE;
    int max =0;
    for(int price : prices) {
        minprices = Math.min(minprices, price);
        max = Math.max(max, price-minprices);
    }
    return max;
    }
}

