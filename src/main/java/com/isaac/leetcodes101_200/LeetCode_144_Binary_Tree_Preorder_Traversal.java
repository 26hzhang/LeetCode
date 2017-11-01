package com.isaac.leetcodes101_200;

import com.isaac.nodes.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_144_Binary_Tree_Preorder_Traversal {
	public static void main(String[] args) {

	}

	// using recursion
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;
		recursion(root, list);
		return list;
	}

	public static void recursion(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		list.add(root.val);
		recursion(root.left, list);
		recursion(root.right, list);
	}

	// using stack
	public List<Integer> preorderTraversal1(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			list.add(node.val);
			if (node.right != null)
				stack.push(node.right);
			if (node.left != null)
				stack.push(node.left);
		}
		return list;
	}
}
