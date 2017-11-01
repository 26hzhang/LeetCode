package com.isaac.leetcodes101_200;

import com.isaac.nodes.TreeNode;

public class LeetCode_104_Maximum_Depth_of_Binary_Tree {
	public static void main(String[] args) {

	}

	public static int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		int leftMax = maxDepth(root.left);
		int rightMax = maxDepth(root.right);
		return Math.max(leftMax, rightMax) + 1;
	}
}
