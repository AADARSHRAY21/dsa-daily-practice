/*
 * Problem: Longest Common prefix (LeetCode #14)
 * Link: https://leetcode.com/problems/longest-common-prefix/description/
 * Difficulty: //    if(strs == null || strs.length ==0) return "";
 * Pattern: //    for(int i =0; i<strs.length ; i++) {  //Compare with remaining String
 *
 * Approach (in my own words):
 * -
 *
 * Time Complexity: O(?)
 * Space Complexity: O(?)
 *
 * Needed hint? //         prefix = prefix.substring(0, prefix.length() -1);  //Remove Last Character
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

