/*
 * Problem: Longest Common Prefix (LeetCode #14)
 * Link: https://leetcode.com/problems/longest-common-prefix/
 * Difficulty: Easy
 * Pattern: Horizontal Scanning / Character-by-Character Comparison
 *
 * Approach (in my own words):
 * - Compare characters at the same index across all strings, using the
 *   first string as the reference.
 * - If any string is shorter than the current index, or its character
 *   at that index doesn't match, the prefix ends there — return the
 *   substring up to that point.
 * - If we get through the entire first string without a mismatch,
 *   the whole first string is the common prefix.
 *
 * Time Complexity: O(n * m) — n = number of strings, m = length of shortest string
 * Space Complexity: O(1) — no extra space beyond the output substring
 *
 * Needed hint? No
 *
 * Revisit on: (7 days from 2026-07-09)
 */
// TODO: paste your solved code below
class Solution {
    public String longestCommonPrefix(String[] strs) {
//    if(strs == null || strs.length ==0) return "";
//    String prefix = strs[0]; //Assume first String is prefix
//    for(int i =0; i<strs.length ; i++) {  //Compare with remaining String
//     while(!strs[i].startsWith(prefix)) {
//         prefix = prefix.substring(0, prefix.length() -1);  //Remove Last Character
//         if (prefix.isEmpty()) return "" ;
//     }
//    }
//    return prefix;


// Or
   
   //Compare Character by Character
   if(strs == null || strs.length ==0) return "";
      for(int i =0 ; i< strs[0].length(); i++) {
        char ch = strs[0].charAt(i);
        for(int j = 1 ; j < strs.length ; j++) {
            if( i >= strs[j].length() || strs[j].charAt(i) != ch ) {
                return  strs[0].substring(0,i);
            }
        }
      }
      return strs[0];
  }
}

