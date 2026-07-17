/*
 * Problem: Find Numbers with Even numbers Of Diguts (LeetCode #1295)
 * Link: https://leetcode.com/problems/find-numbers-with-even-number-of-digits
 * Difficulty: easy
 * Pattern: Array Math mid level
 * Topics: arrays
 *
 * Approach (in my own words):
 * -
 *
 * Time Complexity: O(?)
 * Space Complexity: O(?)
 *
 * Needed hint? Yes in the logic part we can do with "String.valueof(math" Like some maths operations
 * notes(with T & S comaplexity):
 * Revisit on: (7 days from 2026-07-17)
 */

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


