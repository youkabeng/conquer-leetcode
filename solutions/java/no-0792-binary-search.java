// @desc-start
// Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. If target exists, then return its index, otherwise return -1.
// 
// Example 1:
// 
// Input: nums = [-1,0,3,5,9,12], target = 9
// Output: 4
// Explanation: 9 exists in nums and its index is 4
// 
// 
// Example 2:
// 
// Input: nums = [-1,0,3,5,9,12], target = 2
// Output: -1
// Explanation: 2 does not exist in nums so return -1
// 
//  
// Note:
// 
// You may assume that all elements in nums are unique.
// n will be in the range [1, 10000].
// The value of each element in nums will be in the range [-9999, 9999].
// 
// 
// @desc-end


// @code-start
class Solution {
    public int search(int[] nums, int target) {
		if(nums == null || nums.length == 0)
			return -1;
		int left = 0;
		int right = nums.length - 1;
		while(left <= right) {
			int m = (left + right) / 2;
			int n = nums[m];
			if(n == target) {
				return m;
			} else if(n > target) {
				right = m - 1;
			} else if(n < target) {
				left = m + 1;
			}
		}
		return -1;
    }
}
// @code-end
