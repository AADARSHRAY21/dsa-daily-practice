/*
 * Problem: Plus One (LeetCode #66)
 * Link: https://leetcode.com/problems/plus-one
 * Difficulty: Easy
 * Pattern: add plus one to last index of array
 * Topics: arrays, Math
 *
 * Approach (in my own words):
 * -
 *
 * Time Complexity: O(n).
 * Space Complexity: O(1).
 *
 * Needed hint? yes in logic part
 * Notes : 
 * Revisit on: (7 days from 2026-09-08)
 */

class Solution {
    public int[] plusOne(int[] digits) {
    int n = digits.length;
    for(int i =n-1; i >=0; i--) {
        if(digits[i] < 9) {
            digits[i]++;
            return digits;
        }
        digits[i]=0;
    }  
     int[] result = new int[n+1];
     result[0] =1;
     return result;
    }
}

