package com.isaac.leetcodes;

public class LeetCode_235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (p.val > root.val && q.val > root.val)
			return lowestCommonAncestor(root.right, p, q);
		if (p.val < root.val && q.val < root.val)
			return lowestCommonAncestor(root.left, p, q);
		else
			return root;
	}
}
