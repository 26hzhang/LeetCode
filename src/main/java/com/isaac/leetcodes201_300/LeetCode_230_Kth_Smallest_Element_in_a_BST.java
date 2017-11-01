package com.isaac.leetcodes201_300;

import com.isaac.nodes.TreeNode;

import java.util.Stack;

public class LeetCode_230_Kth_Smallest_Element_in_a_BST {
	// Given a binary search tree, 
	// write a function kthSmallest to find the kth smallest element in it.
	public static void main(String[] args) {

	}

	public int kthSmallest(TreeNode root, int k) {
		Stack<Integer> stack = new Stack<Integer>();
		recursion(root, stack, k);
		return stack.pop();
	}

	public void recursion(TreeNode root, Stack<Integer> stack, int k) {
		if (root == null)
			return;
		recursion(root.left, stack, k);
		if (stack.size() < k)
			stack.push(root.val);
		else
			return;
		recursion(root.right, stack, k);
	}
}
