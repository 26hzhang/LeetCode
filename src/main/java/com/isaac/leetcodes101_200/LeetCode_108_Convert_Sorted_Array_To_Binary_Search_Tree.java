package com.isaac.leetcodes101_200;

import com.isaac.nodes.TreeNode;

import java.util.Arrays;

public class LeetCode_108_Convert_Sorted_Array_To_Binary_Search_Tree {
	public static void main(String[] args) {

	}

	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 0 || nums == null)
			return null;
		TreeNode root = new TreeNode(nums[nums.length / 2]);
		root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, nums.length / 2));
		root.right = sortedArrayToBST(Arrays.copyOfRange(nums, nums.length / 2 + 1, nums.length));
		return root;
	}
}
