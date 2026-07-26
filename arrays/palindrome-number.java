/*
 * Problem: Palindrome number (LeetCode #9)
 * Link: https://leetcode.com/problems/palindrome-number/
 * Difficulty: Easy
 * Pattern: Math
 * Topics: arrays, Maths
 *
 * Approach (in my own words):
 * -
 *
 * Time Complexity: O(log₁₀ x),Each loop removes one digit from x, and a number with d digits takes about d / 2 iterations.
 * Space Complexity: O(1)
 *
 * Needed hint? yes in the logic part like how to reverse!
 * Notes : O(1)Only a few integer variables are used (x and reversedHalf), regardless of the input size.Negative or ending with 0 → not palindrome (0 is valid).Reverse only half the digits → avoids overflow.Stop when reversedHalf >= x.Even digits: x == reversedHalf.Odd digits: x == reversedHalf / 10.Time: O(log₁₀ n) | Space: O(1)
 * Revisit on: (7 days from 2026-07-26)
 */
class Solution {
    public boolean isPalindrome(int x) {
    // if(x < 0){
    //     return false;
    // }
    // int reverse =0;
    // int temp = x;
    // while ( x > 0) {
    //     reverse = (reverse * 10) + (x %10);
    //     x /= 10;
    // }
    // return reverse == temp;

    //OR


    if( x < 0 || (x % 10 == 0 && x != 0)) return false;

    int reverse =0;
    
    while( x > reverse) {
        reverse = reverse * 10 + ( x % 10 );
        x /= 10;

    }
    return  x == reverse  || x == reverse / 10;
    }
}

