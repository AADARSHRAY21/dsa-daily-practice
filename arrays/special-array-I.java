/*
 * Problem:Special Array I #3151
 * Link: https://leetcode.com/problems/special-array-i/description/
 * Topic:Mid level,Array
 * Difficulty: Easy
 * Pattern: Array Traversal (Linear Scan) + Adjacent Pair Checking
 *
 * Approach (Quick Remember):
 * -An array is special if every pair of adjacent elements has different parity.
 *
 * Time Complexity: O(n)- We visit each adjacent pair exactly once, where n is * the number of elements.
 * Space Complexity: O(1)-We only use a few variables.
 * 
 * 
 * Needed hint? No
 *
 * Revisit on: (7 days from solve date)
 */

class Solution {
    public boolean isArraySpecial(int[] nums) {
       int n = nums.length;
       if(nums.length ==1  ){
            return true;
        }
       for(int i =0; i<n-1 ; i++){
        if((nums[i] % 2 == nums[i+1] % 2)) return false;
      }
      return true;
    }
}