package com.isaac.leetcodes;

/**
 * Given an array with n objects colored red, white or blue, sort them so that
 * objects of the same color are adjacent, with the colors in the order red,
 * white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 *
 * Note:
 * • You are not supposed to use the library's sort function for this problem.
 *
 * Follow up:
 * • A rather straight forward solution is a two-pass algorithm using counting
 * sort.
 * • First, iterate the array counting number of 0's, 1's, and 2's, then
 * overwrite array with total number of 0's, then 1's and followed by 2's.
 * • Could you come up with an one-pass algorithm using only constant space?
 *
 * Tags: Array, Two Pointers, Sort.
 *
 * @author ZHANG HAO
 *
 *         Explain:
 *         因为只有3种值，我们可以使用三个指针，指针i指向起始位置，指针n指向末尾位置，指针j从起始位置开始遍历nums。
 *         当nums[j]==0时，将nums[j]和nums[i]交换，并且i加1，j加1；当nums[j]==1时，j加1；
 *         当nums[j]==2时，nums[j]和nums[n]交换，n减1，j不做处理，因为从后面交换回来的数没有处理过，
 *         需要被处理。当j<=n，执行循环。
 *
 */
public class LeetCode_075_Sort_Colors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void sortColors(int[] nums) {
		if (nums == null || nums.length <= 1)
			return;
		int n = nums.length - 1, i = 0, j = 0;
		while (j <= n) {
			if (nums[j] == 0) {
				swap(nums, i++, j++);
			} else if (nums[j] == 1) {
				j++;
			} else {
				swap(nums, j, n--);
			}
		}
	}

	public static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

}
