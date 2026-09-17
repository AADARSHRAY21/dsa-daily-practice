/*
 * Problem: Reverse an array
 * Link: https://www.geeksforgeeks.org/problems/reverse-an-array/1
 * Difficulty: Easy
 * Pattern: Swap, left < right
 * Topics: arrays
 *
 * Approach (in my own words):
 * -left < right, temp = left, left = right, right = temp.
 *
 * Time Complexity: O(n).
 * Space Complexity: O(1).
 *
 * Needed hint? no
 * Notes : left < right, temp = left, left = right, right = temp.
 * Revisit on: (7 days from 2026-09-17)
 */

class Solution {
    public void reverseArray(int arr[]) {
        int n = arr.length;
        int left = 0;
        int right=n-1;
        while( left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            
            left++;
            right--;
        }
        
    }
}

