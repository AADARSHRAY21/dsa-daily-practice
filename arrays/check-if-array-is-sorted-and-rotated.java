/*
 * Problem: check-if-array-is-sorted-and-rotated (LeetCode #1752)
 * Link: https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
 * Difficulty: Easy
 * Pattern: Array(circular array/Optimal approach!
 * Topics: arrays
 *
 * Approach (in my own words):
 * -
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Needed hint? Yes in rotation
 * Notes : Treat the array as circular. Compare every element with the next element, including the final element with the first.(optimal)
 * Revisit on: (7 days from 2026-08-12)
 */

class Solution {
    public boolean check(int[] nums) {
    // int n = nums.length;
    //   if(n <= 1 ) return true;
    //   int dropindex = -1;
    //   for(int i =0 ; i< nums.length -1; i++) {
    //     if(nums[i] > nums[i+1]) {
    //         if( dropindex != -1){
    //             return false;
    //         }
    //         dropindex = i;
    //     }
    //   }
    //   if(dropindex ==  -1) return true;
      
    //   if(nums[n-1] > nums [0])
    //   { 
    //     return false;
    //   }
    //   return true;


    //or(optimal approach)

    int n = nums.length;
    int drops =0;
    for(int i =0; i < n ; i++) {
        if(nums[i] > nums[(i+1) % n] ) {
            drops++;
        }
     }
     return drops <= 1;
    }
}


