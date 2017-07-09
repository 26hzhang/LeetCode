package com.isaac.leetcodes1_100;

import com.isaac.nodes.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_094_Binary_Tree_Inorder_Tranversal {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// using recursion
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;
		recursion(root, list);
		return list;
	}

	public void recursion(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		recursion(root.left, list);
		list.add(root.val);
		recursion(root.right, list);
	}

	// using stack
	public List<Integer> inroderTraversal1(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop();
				list.add(root.val);
				root = root.right;
			}
		}
		return list;
	}
}
