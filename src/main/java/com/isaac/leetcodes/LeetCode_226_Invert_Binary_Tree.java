package com.isaac.leetcodes;

public class LeetCode_226_Invert_Binary_Tree {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		}
		//交换操作
		TreeNode tmp;
		tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}
}
