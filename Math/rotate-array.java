/*
 * Problem: Rotate array (LeetCode #189)
 * Link: https://leetcode.com/problems/rotate-array/
 * Difficulty: Medium
 * Pattern: Index mapping and array reversal.
 * Topics: arrays, Math, two-pointers-sliding-window
 *
 * Approach (in my own words):
 * -
 *
 * Time Complexity: O(n) reverse() swaps elements from both ends toward the middle.
 * Space Complexity: O(1) The original nums array is not counted as extra space because the question already gives it to us, and we modify it in-place.
 *
 * Needed hint? Yes for mapping and reverse.
 * Notes : Even though reverse() is called three times, the number of array operations still grows linearly with n. temp, left, right, n, and k are only a fixed number of variables. They do not increase when the input array gets larger.
 * Revisit on: (7 days from 2026-08-19)
 */

class Solution {
    public void rotate(int[] nums, int k) {
    // int n = nums.length;
    // k = k % n;
    // int[] result = new int[n];
    // for(int i =0; i < n; i++){
    // int newindex = (i+k) % n;            //better Solution
    // result[newindex] = nums[i];
    // }
    // for(int i=0; i < n ; i++) {
    //  nums[i] = result[i];
    // }

    //OR optimal Solution

    int n = nums.length;
    k = k% n;
    reverse(nums,0,n-1);
    reverse(nums,0,k-1);
    reverse(nums,k,n-1);
    }

    private void reverse( int[] nums, int left, int right) {
        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
   
}


