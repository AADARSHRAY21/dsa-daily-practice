# Problem Notes Template

Copy this format as a comment block at the top of every solution file, or as a sibling `.md` file next to it.

```
/*
 * Problem: [Name] (LeetCode #___)
 * Link: [url]
 * Difficulty: Easy / Medium / Hard
 * Pattern: [e.g. Sliding Window, Two Pointers, DFS, DP - Knapsack]
 *
 * Approach (in my own words):
 * -
 *
 * Time Complexity: O(?)
 * Space Complexity: O(?)
 *
 * Needed hint? Yes/No — if yes, what part:
 * -
 *
 * Revisit on: [date, 7 days later]
 */
```

### Example

```
/*
 * Problem: Longest Substring Without Repeating Characters (LeetCode #3)
 * Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Difficulty: Medium
 * Pattern: Sliding Window + HashSet
 *
 * Approach (in my own words):
 * - Expand right pointer, add char to set.
 * - If duplicate found, shrink from left until duplicate removed.
 * - Track max window size seen.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(min(n, charset size))
 *
 * Needed hint? No
 *
 * Revisit on: 2026-07-13
 */
```
