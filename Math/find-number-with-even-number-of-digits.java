/*
 * Problem: find Number with even number of digits (LeetCode #1295)
 * Link: https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 * Difficulty: easy
 * Pattern: Digit Manipulation
 * Topics: arrays
 *
 * Approach (in my own words):
 * -
 *
 * Time Complexity: O(?)
 * Space Complexity: O(?)
 *
 * Needed hint? Yes in the logic part for itteration for then while
 * notes:Traverse the array, count digits of each number by repeatedly dividing by 10, and
 * increment the answer whenever the digit count is even. Time complexity is O(N × log(maxNum)) and space complexity is 
 * O(1).
 *
 * Revisit on: (7 days from 2026-07-13)
 */

// TODO: paste your solved code below
class Solution {
    public int findNumbers(int[] nums) {
    //  int count =0;
    //  for(int num : nums) {
    //     int temp =num;
    //     int digit =0;

    //     while( temp > 0) {
    //         temp /= 10;
    //         digit++;
    //     }
    //     if(digit % 2 ==0)
    //     count++;
    //  }
    //  return count;

    //OR

    int count =0;
    for(int num : nums) {
        int digit = String.valueOf(Math.abs(num)).length();

        if(digit % 2 ==0)
        count++;
    }
    return count;
    }
     
  }


