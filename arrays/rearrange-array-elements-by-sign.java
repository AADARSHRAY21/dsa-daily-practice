/*
 * Problem: rearrange array elements by sign (LeetCode #2149)
 * Link: https://leetcode.com/problems/rearrange-array-elements-by-sign
 * Difficulty: Medium
 * Pattern: Array → Rearrangement → Fixed Position Pattern
 * Topics: arrays, two-pointers
 *
 * Approach (in my own words):
 * -
 *
 * Time Complexity: O(n).
 * Space Complexity: O(1) auxiliary, idea- Two indices.
 *
 * Needed hint? Yes
 * Notes : Two pointers + fixed-position placement + stable ordering,You don't need to rearrange the original array; just build the answer in the correct positions.
 * Revisit on: (7 days from 2026-09-04)
 */

class Solution {
    public int[] rearrangeArray(int[] nums) {
    int n = nums.length;
    int[] ans = new int[n];
    int pos =0;
    int neg =1;
    for(int num : nums) {
        if(num > 0) {
            ans[pos] = num;
            pos +=2;
        } else {
            ans[neg] = num;
            neg +=2;
        }
    }   
    return ans;
    }
}

