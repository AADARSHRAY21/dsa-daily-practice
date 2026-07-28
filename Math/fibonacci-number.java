/*
 * Problem: Fibonacci number (LeetCode #509)
 * Link: https://leetcode.com/problems/fibonacci-number/
 * Difficulty: Easy
 * Pattern: DP,Math,recursion.
 * Topics: Math, dp, recursion
 *
 * Approach (in my own words):
 * -
 *
 * Time Complexity: O(n)because the loop runs from 2 through n.
 * Space Complexity: O(1) because it only uses three variables (a, b, next), no matter how large n is.
 *
 * Needed hint? Yes in loop.
 * Notes : 1.Smaller elements go to the left of pivot. 2.Larger elements go to the right of pivot. 3.Repeat the same process for left and right parts.
 * Revisit on: (7 days from 2026-07-28)
 */

class Solution {
    public int fib(int n) {
    if( n <= 0) return n;
    int pre =0;
    int current =1;
    for(int i=2; i <= n; i++) {
        int nxt = pre + current;
        pre = current;
        current = nxt;
    }
    return current;
    }
}

