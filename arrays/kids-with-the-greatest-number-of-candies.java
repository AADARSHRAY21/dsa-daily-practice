/*
 * Problem: Kids with the Greatest number of candies. (LeetCode #1431)
 * Link: https://leetcode.com/problems/kids-with-the-greatest-number-of-candies
 * Difficulty: Easy
 * Pattern: "Find max, then compare"
 * Topics: arrays
 *
 * Approach (in my own words):
 * -
 *
 * Time Complexity: O(n).
 * Space Complexity: 0(n). including return result.
 *
 * Needed hint? yes in return true false.
 * Notes : Find the current maximum candy count. For each kid, check
 * Revisit on: (7 days from 2026-08-25)
 */

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    // int max =0;
    // //first check the present greatest candies
    // for(int candy : candies) {
    //     if(candy > max) {
    //         max = candy;
    //     }
    // }
    // List<Boolean> result = new ArrayList<>();
    // //check the new candies after giving extra candies
    // for( int candy :  candies) {
    //     if(candy + extraCandies >= max){
    //         result.add(true);
    //     }else result.add(false);
    // }
    // return result;

    //OR

    int max =0;
    for(int candy : candies) {
        max = Math.max(max, candy); 
    }
    List<Boolean> result = new ArrayList<>();
    for(int candy : candies) {
        result.add(candy + extraCandies  >= max);
    }
    return result;
    }
}
