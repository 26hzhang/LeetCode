package com.isaac.leetcodes101_200;

import com.isaac.nodes.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_145_Binary_Tree_Postorder_Traversal {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// using recursion
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;
		recursion(root, list);
		return list;
	}

	public static void recursion(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		recursion(root.left, list);
		recursion(root.right, list);
		list.add(root.val);
	}

	// using stack
	public List<Integer> postorderTraversal1(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode preNode = root;
		boolean flag = true;
		while (root != null || !stack.isEmpty()) {
			if (root != null && flag) {
				stack.push(root);
				root = root.left;
			} else {
				if (stack.isEmpty())
					break;
				root = stack.peek();
				if (root.right != null && root.right != preNode) {
					root = root.right;
					flag = true;
				} else {
					root = stack.pop();
					list.add(root.val);
					flag = false;
					preNode = root;
				}
			}
		}
		return list;
	}
}
