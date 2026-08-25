/*
 * Problem: Max consecutive ones. (LeetCode #485)
 * Link: https://leetcode.com/problems/max-consecutive-ones/
 * Difficulty: Easy
 * Pattern: Running count/reset on break
 * Topics: arrays
 *
 * Approach (in my own words):
 * -
 *
 * Time Complexity: O(n).
 * Space Complexity: O(1).
 *
 * Needed hint? no
 * Notes : 1.1 → increase current streak. 2.0 → reset streak to 0,Keep the largest streak seen.
 * Revisit on: (7 days from 2026-08-25)
 */

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
    int count =0;
    int maxcount =0;
    for(int num : nums) {
        if(num ==1) {
            count++;
            maxcount = Math.max(maxcount, count);
        }else {
            count =0;
        }
    }
    return maxcount;  
    }
}

