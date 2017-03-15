package com.isaac.leetcodes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_199_Binary_Tree_Right_Side_View {
	// Given a binary tree, imagine yourself standing on the right side of it,
	// return the values of the nodes you can see ordered from top to bottom.
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// BFS Solution -- using queue and iteration
	public static List<Integer> rightSideView1(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		int cDepthLength = 1;
		int nDepthLength = 0;
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node.left != null) {
				queue.offer(node.left);
				nDepthLength++;
			}
			if (node.right != null) {
				queue.offer(node.right);
				nDepthLength++;
			}
			if (cDepthLength > 1) {
				--cDepthLength;
			} else {
				list.add(node.val);
				cDepthLength = nDepthLength;
				nDepthLength = 0;
			}
		}
		return list;
	}

	// DFS Solution----using recursion
	public static List<Integer> rightSideView2(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		recursion(root, 0, list);
		return list;
	}

	public static void recursion(TreeNode root, int depth, List<Integer> list) {
		if (root == null)
			return;
		if (depth == list.size()) {
			list.add(root.val);
		} else {
			list.set(depth, root.val);
		}
		recursion(root.left, depth + 1, list);
		recursion(root.right, depth + 1, list);
	}
}
