package com.isaac.leetcodes;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_101_Symmetric_Tree {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// recursive method
	public static boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return isSymmetricTree(root.left, root.right);
	}

	public static boolean isSymmetricTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if ((p == null && q != null) || (p != null && q == null))
			return false;
		if (p.val == q.val)
			return isSymmetricTree(p.left, q.right) & isSymmetricTree(p.right, q.left);
		return false;
	}

	// iterative method
	public static boolean isSymmetric1(TreeNode root) {
		if (root == null)
			return true;
		String left = getEachNode(root.left, 0);
		String right = getEachNode(root.right, 1);
		return left.equals(right);
	}

	public static String getEachNode(TreeNode root, int side) {
		String str = "";
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node == null)
				str += "#";
			else
				str += String.valueOf(node.val);
			if (side == 0 && node != null) {
				queue.offer(node.left);
				queue.offer(node.right);
			}
			if (side == 1 && node != null) {
				queue.offer(node.right);
				queue.offer(node.left);
			}
		}
		return str;
	}
}
