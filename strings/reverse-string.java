/*
 * Problem: Reverse String (LeetCode #344)
 * Link: https://leetcode.com/problems/reverse-string/
 * Difficulty: Easy
 * Pattern: Two Pointers, String
 * Topics: strings
 *
 * Approach (in my own words):
 * -
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Needed hint? Yes in the reverse part
 * Notes : In optimal First use two Pointers Swap Left and right and left >= right Stop.
 * Revisit on: (7 days from 2026-07-27)
 */

class Solution {
    public void reverseString(char[] s) {
    int left =0;
    int right = s.length -1;
     while (left < right) {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;

        left++;
        right--;
     }

    //OR

    // char[] reversed = new char[s.length];
    // for(int i =0; i<s.length; i++) {
    //     reversed[i] = s[s.length-1-i];
    // }
    // for(int i =0; i < s.length; i++) {
    //     s[i] =  reversed[i];
    // }
    }
}

