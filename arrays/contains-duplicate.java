/*
 * Problem: Contains Duplicate (LeetCode #217)
 * Link: https://leetcode.com/problems/contains-duplicate/
 * Difficulty: Easy
 * Pattern: Hashing(HashSte, HashMap)
 * Topics: arrays
 *
 * Approach (in my own words):
 * -
 *
 * Time Complexity: O(n) average — each element is processed once, and HashSet.add() is O(1) average.
 * Space Complexity: O(n) — in the worst case, all elements are unique and stored in the set.
 *
 * Needed hint? yes
 * Notes : 1.HashSet stores unique elements only. 2.add() directly helps detect duplicates because it returns false if the element already exists. 3.Early exit: As soon as a duplicate is found, return true. 4No need to use contains() and then add() separately.
 * Revisit on: (7 days from 2026-07-18)
 */

class Solution {
    public boolean containsDuplicate(int[] nums) {
     HashSet<Integer> intset = new HashSet<>();
     for( int num : nums) {
        if(!intset.add(num))  return true;
     }   
      return false;
    }
}

