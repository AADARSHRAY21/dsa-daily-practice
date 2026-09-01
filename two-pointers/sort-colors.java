/*
 * Problem: Sort colors (LeetCode #75)
 * Link: https://leetcode.com/problems/sort-colors/
 * Difficulty: medium
 * Pattern: Dutch National Flag
 * Topics: arrays, Sorting, two-pointers
 *
 * Approach (in my own words):
 * -
 *
 * Time Complexity: |O(n).
 * Space Complexity: 0(1).
 *
 * Needed hint? yes
 * Notes : Sort array containing only 0, 1, 2. 3-way partition Dutch National Flag - 3 pointers-O(n) time O(1) space
 * Revisit on: (7 days from 2026-09-01)
 */

class Solution {
    public void sortColors(int[] nums) {
    // int n = nums.length;
    // for(int i=0; i<n; i++){
    //     for(int j =0; j < n-i-1 ; j++){
    //         if(nums[j] > nums[j+1]) {
    //             int temp = nums[j];
    //             nums[j] = nums[j+1];
    //             nums[j+1] = temp;
    //         }
    //     }
    // }

    // OR

    // int min = nums[0];
    // int max = nums[0];

    // //find range
    // for(int num : nums) {
    //     min = Math.min(min, num);
    //     max = Math.max(max, num);
    // }
    // int[] freq = new int[max -min +1];

    // //count
    // for(int num : nums) {
    //     freq[num - min]++;
    // }

    // //rebuild array
    // int index =0;
    // for(int i =0; i < freq.length; i++) {
    //     while(freq[i] > 0) {
    //         nums[index++] =i + min;
    //         freq[i]--;
    //     }
    // }

    //OR

    int low =0;
    int mid =0;
    int high = nums.length -1;
    while(mid <= high) {
        if(nums[mid] == 0) {
            swap(nums, low, mid);
            low++;
            mid++;
        }
        else if(nums[mid] ==1) {
            mid++;
        }else {
            swap(nums, mid, high);
            high--;
        }
    }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

