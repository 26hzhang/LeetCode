package com.isaac.leetcodes;

public class LeetCode_215_Kth_Largest_Element_in_an_Array {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 3, 2, 1, 5, 6, 4 };
		int k = 2;
		System.out.println(findKthLargest(nums, k));
	}

	public static int findKthLargest(int[] nums, int k) {
		if (nums == null || nums.length == 0 || nums.length < k)
			throw new IllegalArgumentException("Error Input");
		return recursion(nums, 0, nums.length - 1, k);
	}

	public static int recursion(int[] nums, int left, int right, int k) {
		int temp = nums[left];
		while (left < right) {
			while (left < right && nums[right] <= temp)
				right--;
			nums[left] = nums[right];
			while (left < right && nums[left] >= temp)
				left++;
			nums[right] = nums[left];
		}
		nums[left] = temp;
		if (left == k - 1) {
			return nums[left];
		} else if (left > k - 1) {
			return recursion(nums, 0, left - 1, k);
		} else {
			return recursion(nums, left + 1, nums.length, k);
		}
	}
}
