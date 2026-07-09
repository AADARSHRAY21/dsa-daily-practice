/*
 * Problem: Valid Parentheses (LeetCode #20)
 * Link: https://leetcode.com/problems/valid-parentheses/
 * Difficulty: Easy
 * Pattern: String, Stack (LIFO)
 * Topics: arrays, strings, stacks-queues
 *
 * Approach (in my own words):
 * 1. Push every opening bracket onto the stack.
 * 2. When a closing bracket appears, check if the stack is empty or if
 *    the top doesn't match its corresponding opening bracket.
 * 3. If either condition is true, return false.
 * 4. After processing all characters, return true only if the stack is empty.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
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
