/*
 * Problem: Shuffle the Array. (LeetCode #1470)
 * Link: https://leetcode.com/problems/shuffle-the-array/
 * Difficulty: Easy
 * Pattern: Array Interleaving / Two Halves
 * Topics: arrays
 *
 * Approach (in my own words):
 * -
 *
 * Time Complexity: O(n) — every 2n element needs to appear in the result.
 * Space Complexity: O(n) — the returned ans array is required.
 *
 * Needed hint? yes in loop.
 * Notes : “First half + second half, pick one-one alternately.”
 * Revisit on: (7 days from 2026-08-24)
 */

class Solution {
    public int[] shuffle(int[] nums, int n) {
    int[] ans = new int[2*n];
    int i =0;
    for(int j=0; j<n; j++){
        ans[i++]= nums[j];
        ans[i++] = nums[j+n];
    }    
    return ans;
    }
}

