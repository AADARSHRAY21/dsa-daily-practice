/*
 * Problem:how-many-numbers-are-smaller-than-the-current-number
 * Link:https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 * Difficulty: Easy
 * Pattern: Frequency/counting array
 * Topics: arrays, sorting
 *
 * Approach (in my own words):
 * -
 *
 * Time Complexity: O(n + range) → O(n + 101) ≈ O(n)
 * Space Complexity: O(range) → O(101) ≈ O(1)
 *
 * Needed hint? yes
 * Notes : Brute: for every number, count smaller numbers → O(n²).
           Sort: first index in sorted array = smaller-count → O(n log n).
           Counting: freq[value] then prefix totals → O(n + range).
           Duplicates: count only values strictly <, so all equal values get the same answer.
 * Revisit on: (7 days from 2026-08-27)
 */

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
    //  int n = nums.length;
    //  int[] ans = new int[n];
    //  for(int i =0; i< n; i++){
    //     int count =0;
    //     for(int j =0; j < n; j++) {
    //         if(nums[j] < nums[i]){
    //             count++;
    //         }
    //     }
    //     ans[i] = count;
    //  }
    //  return ans;

    //or optimal

    int[] frequency = new int[101];
    
    //count occurence
    for(int num : nums) {
        frequency[num]++;
    }

    //frequency[value] becomes count of numbers < value
    int smaller =0;
    for(int value =0; value <= 100; value++) {
        int currentFrequency = frequency[value];
        frequency[value] = smaller;
        smaller += currentFrequency;
    }
    int[] ans = new int[nums.length];
    for(int i=0; i< nums.length; i++) {
        ans[i] = frequency[nums[i]];
    }
    return ans;


    //OR sorting

    // int n = nums.length;
    // int[] sorted = nums.clone();
    // Arrays.sort(sorted);

    // Map<Integer, Integer> smallerCount = new HashMap<>();
    // for(int i =0; i<n; i++) {
    //     smallerCount.putIfAbsent(sorted[i], i);
    // }
    // int[] answer = new int[n];
    // for(int i =0; i< n; i++){
    //     answer[i] = smallerCount.get(nums[i]);
    // }
    // return answer;
    
    }
}

