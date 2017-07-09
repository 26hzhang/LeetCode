package com.isaac.otherAlgorithms;

import com.isaac.nodes.TreeNode;

public class BSTMirroring {
	public static void main(String[] args) {

	}

	// 先序思想
	public static void mirroring(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return;
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		if (root.left != null)
			mirroring(root.left);
		if (root.right != null)
			mirroring(root.right);
	}
}
