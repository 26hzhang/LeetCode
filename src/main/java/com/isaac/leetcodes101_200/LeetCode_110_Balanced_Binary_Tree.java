package com.isaac.leetcodes101_200;

import com.isaac.nodes.TreeNode;

public class LeetCode_110_Balanced_Binary_Tree {
	public static void main(String[] args) {

	}

	public static boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		if (Math.abs(getDepth(root.left) - getDepth(root.right)) > 1)
			return false;
		return isBalanced(root.left) && isBalanced(root.right);
	}

	public static int getDepth(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
	}
}
