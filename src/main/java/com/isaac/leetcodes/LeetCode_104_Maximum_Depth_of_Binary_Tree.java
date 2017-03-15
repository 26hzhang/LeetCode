package com.isaac.leetcodes;

public class LeetCode_104_Maximum_Depth_of_Binary_Tree {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		int leftMax = maxDepth(root.left);
		int rightMax = maxDepth(root.right);
		return Math.max(leftMax, rightMax) + 1;
	}
}
