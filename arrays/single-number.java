/*
 * Problem: Single number (LeetCode #136)
 * Link: https://leetcode.com/problems/single-number/
 * Difficulty: Easy
 * Pattern: bit manipulation, xor cancellation.
 * Topics: arrays
 *
 * Approach (in my own words):
 * -
 *
 * Time Complexity: 0(n).
 * Space Complexity: 0(1).
 *
 * Needed hint? yes
 * Notes : every number appears exactly twice except one,you need O(n) time,you need O(1) extra space.
 * Revisit on: (7 days from 2026-08-25)
 */

class Solution {
    public int singleNumber(int[] nums) {
    int n = nums.length;
    //brute force
    // for( int i =0; i < n; i++) {
    //     int count =0;
    //     for(int j =0; j <n ; j++) {
    //         if(nums[i] == nums[j] ) {
    //             count++;
    //         }
    //     }
    //     if(count == 1){
    //         return nums[i];
    //     }
    // }
    // return -1;

    //OR
    
    //better 
    // Map<Integer, Integer> frequency = new HashMap<>();
    // for(int num : nums) {
    //     frequency.put(num, frequency.getOrDefault(num , 0) + 1);
    // }
    // for(int num : nums) {
    //     if(frequency.get(num) == 1) {
    //         return num;        
    //     }
    // }
    // return -1;

    //OR optimal

    int ans =0;
    for(int num : nums) {
        ans = ans ^ num;
    }
    return ans;
    }
}
