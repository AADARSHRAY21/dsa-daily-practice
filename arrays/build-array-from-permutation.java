/*
 * Problem: Build Array fromPermutation (LeetCOde #1920)
 * Link: https://leetcode.com/problems/build-array-from-permutation/
 * Topic:Mid level,Array
 * Difficulty: Easy
 * Pattern: Array index Mapping(Direct Mapping)
 *
 * Approach (Quick Remember):
 * - For each index i, the answer is just nums[nums[i]]
 * - No extra logic, no edge cases — just one pass, direct lookup
 * - Trick to remember: "index of index" → ans[i] = nums[nums[i]]
 *
 * Time Complexity: O(n)- Single pass through the Array
 * Space Complexity: O(n)- For the New "ans" Array(O(1) Extra if you Don't 
 * Count Output Space)
 * 
 * Quick note: your loop condition i <= nums.length-1 works fine, but i < nums.length is the more standard/cleaner way to write it — same result, just idiomatic.
 * 
 * Needed hint? No
 *
 * Revisit on: (7 days from solve date)
 */

class Solution {
    public int[] buildArray(int[] nums) {
     int n = nums.length;
     int[] ans = new int[nums.length];
     for(int i =0 ;i<=nums.length-1; i++) {
        ans[i] = nums[nums[i]];
     }   
     return ans;
    }
}