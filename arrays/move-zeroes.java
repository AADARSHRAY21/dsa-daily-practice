/*
 * Problem: Move Zeroes (LeetCode #283)
 * Link: https://leetcode.com/problems/move-zeroes/
 * Difficulty: Easy
 * Pattern: Two pointers, array
 * Topics: arrays, two-pointers
 *
 * Approach (in my own words):
 * -
 *
 * Time Complexity: 0(n).
 * Space Complexity: 0(1).
 *
 * Needed hint? yes move zero to end.
 * Notes : i: reads every element,index: marks where the next non-zero element should go
 * Revisit on: (7 days from 2026-08-23)
 */

class Solution {
    public void moveZeroes(int[] nums) {
    int index =0;
    for(int i : nums) {
        if( i != 0) {
        nums[index] = i;
        index++;
        }
    }
    while( index < nums.length) {
        nums[index] = 0;
        index++;
    }

    //or

    // int index =0;
    // for(int i =0; i < nums.length; i++) {
    //  if(nums[i] != 0) {
    //     int temp = nums[i];
    //     nums[i] = nums[index];
    //     nums[index] = temp;
    //     index++;
    //  }
    // }

    }
}

