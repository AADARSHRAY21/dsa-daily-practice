/*
 * Problem: Two Sum (LeetCode #1)
 * Link: https://leetcode.com/problems/two-sum/
 * Difficulty: Easy
 * Pattern: HashMap - complement lookup
 *
 * Approach (in my own words):
 * - Walk through array once.
 * - For each number, check if (target - number) already exists in map.
 * - If yes, return the two indices. If no, store number -> index in map.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Needed hint? No
 *
 * Revisit on: (7 days from solve date)
 */

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (seen.containsKey(complement)) {
                return new int[] { seen.get(complement), i };
            }
            seen.put(nums[i], i);
        }
        return new int[] {};
    }
}
