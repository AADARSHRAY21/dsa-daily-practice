/*
 * Problem: Richest customer wealth. (LeetCode #1672)
 * Link: https://leetcode.com/problems/richest-customer-wealth
 * Difficulty: Easy
 * Pattern: 2D Array traversal + Row sum.
 * Topics: arrays
 *
 * Approach (in my own words):
 * -
 *
 * Time Complexity: 0(M x N). m is no. of rows and n is no. of bank accounts.
 * Space Complexity: 0(1). only sum and maxwealth varibales are used.
 *
 * Needed hint? yes in traversal part.
 * Notes : “For every row: sum it → update maximum.”,Do not write only accounts[0] and accounts[1]; there can be many customer rows. Use:for (int[] customer : accounts)
 * Revisit on: (7 days from 2026-08-24)
 */
class Solution {
    public int maximumWealth(int[][] accounts) {
    int maxwealth = 0;
    for(int[] customer : accounts) {
        int sum =0;
    for(int money : customer) {
        sum += money;
    }
    maxwealth = Math.max(maxwealth, sum);
    }
    return maxwealth;
    }
}

