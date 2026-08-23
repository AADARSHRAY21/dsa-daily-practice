/*
 * Problem: Concatenation of Array. (LeetCode #1929)
 * Link: https://leetcode.com/problems/concatenation-of-array/
 * Difficulty: Easy
 * Pattern: Array duplication.
 * Topics: arrays
 *
 * Approach (in my own words):
 * -
 *
 * Time Complexity: O(n) — one loop through the input.
 * Space Complexity: O(n) — the required output array.
 *
 * Needed hint? no!
 * Notes : Create an array of size 2n, then place each nums[i] at,2.“New array double size; copy every item at i and i+n.”
 * Revisit on: (7 days from 2026-08-23)
 */

class Solution {
    public int[] getConcatenation(int[] nums) {
    int n = nums.length;
    int[] ans = new int[2*n];
    for(int i=0; i<nums.length; i++){
    ans[i] = nums[i];
    ans[i+n] = nums[i];
    }
    return ans;
  }
}

