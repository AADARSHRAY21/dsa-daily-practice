/*
 * Problem: Number of good pairs (LeetCode #1512)
 * Link: https://leetcode.com/problems/number-of-good-pairs/
 * Difficulty: Easy
 * Pattern: Frequency map / count previous occurrences
 * Topics: arrays, Math
 *
 * Approach (in my own words):
 * -
 *
 * Time Complexity: 0(n).
 * Space Complexity: O(1) because the array size is always 101.
 *
 * Needed hint? no
 * Notes : When you see a number again, it forms one pair with every same number seen before.
 * Revisit on: (7 days from 2026-08-25)
 */

class Solution {
    public int numIdenticalPairs(int[] nums) {
    // int n = nums.length;
    // int count =0;
    // for(int i =0; i < n; i++) {
        
    //     for(int j =i+1 ; j < n; j++) {
           
    //         if(nums[i] == nums[j]) {
    //             count++;
    //         }
    //     }  
    // }  
    //  return count;

    //OR

    // Map<Integer, Integer> frequency = new HashMap<>();
    // int pairs =0;
    // for(int num : nums) {
    //     int seenbefore = frequency.getOrDefault(num,0);
    //     pairs += seenbefore;
    //     frequency.put(num, seenbefore + 1);
    // }
    // return pairs;

    //OR


    int[] frequency = new int[101];
    int pairs =0;
    for(int num : nums) {
        pairs +=  frequency[num];
        frequency[num]++;
    }
    return pairs;
    }
}

