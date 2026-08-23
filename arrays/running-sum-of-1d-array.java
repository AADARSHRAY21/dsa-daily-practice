/*
 * Problem: Running sum of 1D array. (LeetCode #1480)
 * Link: https://leetcode.com/problems/running-sum-of-1d-array/
 * Difficulty: Easy
 * Pattern: Prefix sum/running sum
 * Topics: arrays
 *
 * Approach (in my own words):
 * -
 *
 * Time Complexity: O(n) — visit each element once.
 * Space Complexity: O(1) — if updating nums directly.
 *
 * Needed hint? yesin logic
 * Notes : “Previous total + current value = current total, nums[i] = nums[i-1] + nums[i].”
 * Revisit on: (7 days from 2026-08-23)
 */

class Solution {
    public int[] runningSum(int[] nums) {
    int n = nums.length;
    int[] ans = new int[n];
    ans[0] = nums[0];
    for(int i =1; i < n; i++){
    ans[i] = ans[i - 1] + nums[i];
    }  
    return ans;
    }
}

