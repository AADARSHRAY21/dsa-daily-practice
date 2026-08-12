/*
 * Problem: remove duplicates from sorted array (LeetCode #26)
 * Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array
 * Difficulty: Easy
 * Pattern: Two pointers
 * Topics: arrays, two-pointers-sliding-window
 *
 * Approach (in my own words):
 * -
 *
 * Time Complexity: O(n) because each element is checked once.
 * Space Complexity: O(1) because no extra array is used.
 *
 * Needed hint? yes copy unique value.
 * Notes : Idea: Keep the first value. Start read from index 1. Whenever nums[read] differs from the previous unique value, write it at nums[write].
 * Revisit on: (7 days from 2026-08-12)
 */

class Solution {
    public int removeDuplicates(int[] nums) {
    //   int n = nums.length;
    //   int i = 0;
    //   while(i < n-1) {
    //     if(nums[i] == nums[i+1]) {
    //         for(int j = i+1; j < n-1;  j++) {
    //             nums[j] = nums[j+1];
    //         }
    //         n--;
    //     }else {
    //         i++;
    //     }
    //   }  
    //   return n;

    //better approach

    // int[] unique = new int[nums.length];
    // int k =0;
    // for(int i =0; i< nums.length; i++) {
    //     if( i ==0 || nums[i] != nums[i-1]){
    //         unique[k] =nums[i];
    //         k++;
    //     }
    // }
    // for(int i =0; i < k  ; i++) {
    // nums[i] = unique[i];
    // }
    // return k;

    //Optimal approach
     
    int write = 1;
    for(int read =1; read < nums.length; read++) {
        if(nums[read] != nums[write -1]) {
            nums[write] = nums[read];
            write++;
        }
    }
    return write;
    }
}

