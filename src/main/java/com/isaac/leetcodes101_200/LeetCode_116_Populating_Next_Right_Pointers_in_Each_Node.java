package com.isaac.leetcodes101_200;

import com.isaac.nodes.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_116_Populating_Next_Right_Pointers_in_Each_Node {
	// Given a binary tree
	// Populate each next pointer to point to its next right node. 
	// If there is no next right node, the next pointer should be set to NULL.
	public static void main(String[] args) {

	}

	// it is a specific situation for full binary tree
	// DFS Solution----using recursion
	public void connect1(TreeLinkNode root) {
		recursion(root.left, root);
		recursion(root.right, root);
	}

	public static void recursion(TreeLinkNode node, TreeLinkNode parent) {
		if (node == null)
			return;
		if (parent.left == node) {
			node.next = parent.right;
		} else if (parent.right == node) {
			if (parent.next != null) {
				node.next = parent.next.left;
			} else {
				node.next = null;
			}
		}
		recursion(node.left, node);
		recursion(node.right, node);
	}

	// BFS solution----using a queue to support, iteration
	public void connect2(TreeLinkNode root) {
		if (root == null)
			return;
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		int nodeNum = 1, depth = 0;
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeLinkNode node = queue.poll();
			if (nodeNum > 1) {
				node.next = queue.peek(); // queue.peek() return the element of queue head
				--nodeNum;
			} else {
				node.next = null;
				nodeNum = (int) Math.pow(2.0, ++depth);
			}
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
	}
}
