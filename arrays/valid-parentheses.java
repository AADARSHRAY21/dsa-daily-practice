/*
 * Problem: Valid Parentheses (LeetCode #20)
 * Link: https://leetcode.com/problems/valid-parentheses/description/
 * Difficulty: Easy
 * Pattern: String, Stack(LIFO)
 *
 * Approach (in my own words):
 * -
 *
 * Time Complexity: O(?)
 * Space Complexity: O(?)
 *
 * Needed hint? No
 *
 * Revisit on: (7 days from 2026-07-07)
 */

// TODO: paste your solved code below
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        
            map.put('}','{');
            map.put(')','(');
            map.put(']','[');
        
        for(char c : s.toCharArray()){
            if(map.containsValue(c)){
                 stack.push(c);
            }else if(map.containsKey(c)){
                if(stack.isEmpty() || map.get(c) != stack.pop() ){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
