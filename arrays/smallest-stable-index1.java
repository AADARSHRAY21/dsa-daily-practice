/*
 * Problem: Smallest Stable index1 (LeetCode #3903)
 * Link: https://leetcode.com/problems/smallest-stable-index-i
 * Difficulty: Easy
 * Pattern: 
 * Topics: arrays
 *
 * Approach (in my own words):
 * -
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1).
 *
 * Needed hint? Yes
 * Notes : 
 * Revisit on: (7 days from 2026-09-09)
 */

class Solution {
    public int firstStableIndex(int[] nums, int k) {
    int n = nums.length;
    int[] minFromIndex = new int[n];
    int min = Integer.MAX_VALUE;
    for(int i =n-1; i>=0 ; i--) {
        min = Math.min(min , nums[i]);
        minFromIndex[i] = min;
    }
    int max = Integer.MIN_VALUE;
        for(int  i=0; i < n ; i++) {
            max = Math.max(max , nums[i]);
            if(max - minFromIndex[i] <= k) {
            return i;
        }
    }    
    return -1;
    }
}

