package com.isaac.otherAlgorithms;

/**
 * it is a dynamic programming codes
 *
 */
public class Sum_of_Two_Smallest_Integers {
	// Develop a method that calculates the sum of the two smallest integers in
	// an integer array. For example, for the array [34, 7, 63, 15, 42, 11, 91],
	// the result is 7 + 11 = 18
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 34, 7, 63, 15, 42, 16, 91 };
		System.out.println(CalculateSumOfTwoSmallestIntegers(nums));
	}

	public static int CalculateSumOfTwoSmallestIntegers(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		if (nums.length == 2)
			return nums[0] + nums[1];
		int min1 = nums[0];
		int min2 = nums[1];
		for (int i = 2; i < nums.length; i++) {
			int tmp = min1;
			min1 = Math.min(min1, nums[i]);
			if (min1 == tmp)
				min2 = Math.min(min2, nums[i]);
			else
				min2 = Math.min(min2, tmp);
		}
		return min1 + min2;
	}

}
