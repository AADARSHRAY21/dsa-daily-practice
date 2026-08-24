/*
 * Problem: Missing Number (LeetCode #268)
 * Link: https://leetcode.com/problems/missing-number/
 * Difficulty: Easy
 * Pattern: Expected value − Actual value
 * Topics: arrays, Math
 *
 * Approach (in my own words):
 * -
 *
 * Time Complexity: O(n) — the loop visits every array element once.
 * Space Complexity: O(1) — only fixed variables (n, expectedSum, actualSum) are used.
 *
 * Needed hint? yes in missinmg logic
 * Notes : Full range sum − array sum = missing number.
 * Revisit on: (7 days from 2026-08-24)
 */

class Solution {
    public int missingNumber(int[] nums) {
    int n = nums.length;
    int expectedsum = n * (n+1)/2;
    int actualsum =0;
    for(int i : nums) {
    actualsum += i;
    }   
    return expectedsum - actualsum;
    }
}

