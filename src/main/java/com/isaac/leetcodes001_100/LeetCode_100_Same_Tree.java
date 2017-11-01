package com.isaac.leetcodes001_100;

import com.isaac.nodes.TreeNode;

public class LeetCode_100_Same_Tree {
	public static void main(String[] args) {

	}

	private boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if ((p == null && q != null) || (p != null && q == null))
			return false;
		if (p.val == q.val) {
			boolean leftBool = isSameTree(p.left, q.left);
			boolean rightBool = isSameTree(p.right, q.right);
			return (leftBool & rightBool);
		}
		return false;
	}
}
