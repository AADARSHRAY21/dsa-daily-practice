/*
 * Problem: Contain Duplicate (LeetCode #217)
 * Link: https://leetcode.com/problems/contains-duplicate/
 * Difficulty: Easy
 * Pattern: Hahsing(HashSet,HashMap)
 * Topics: arrays
 *
 * Approach (in my own words):
 * -
 *
 * Time Complexity: : O(n) average — each element is processed once, and HashSet.add() is O(1) average.
 * Space Complexity: : O(n) — in the worst case, all elements are unique and stored in the set.
 *
 * Needed hint? yes
 * Notes : 1.Use a HashSet to track seen elements. If add() returns false, the element already exists, so return true. 2.HashSet stores unique elements only. 3.add() directly helps detect duplicates because it returns false if the element already exists. 4.Early exit: As soon as a duplicate is found, return true. 5.No need to use contains() and then add() separately.
 * Revisit on: (7 days from 2026-07-18)
 */

// TODO: paste your solved code below

