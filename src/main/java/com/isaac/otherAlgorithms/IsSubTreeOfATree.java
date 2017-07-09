package com.isaac.otherAlgorithms;

import com.isaac.nodes.TreeNode;

public class IsSubTreeOfATree {
	// 判断一个二叉树是不是另一个二叉树的子结构
	public static void main(String[] args) {

	}

	public static boolean isSubtree(TreeNode root1, TreeNode root2) {
		boolean result = false;
		if (root1 != null && root2 != null) {
			if (root1.val == root2.val)
				result = isSame(root1, root2);
			if (!result)
				result = isSubtree(root1.left, root2);
			if (!result)
				result = isSubtree(root1.right, root2);
		}
		return result;
	}

	public static boolean isSame(TreeNode root1, TreeNode root2) {
		if (root2 == null)
			return true;
		if (root1 == null)
			return false;
		if (root1.val != root2.val)
			return false;
		return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
	}
}
