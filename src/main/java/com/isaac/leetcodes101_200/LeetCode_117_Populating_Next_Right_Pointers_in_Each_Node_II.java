package com.isaac.leetcodes101_200;

import com.isaac.nodes.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_117_Populating_Next_Right_Pointers_in_Each_Node_II {
	public static void main(String[] args) {

	}

	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
		int cDepthLength = 1;
		int nDepthLength = 0;
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeLinkNode node = queue.poll();
			if (node.left != null) {
				queue.offer(node.left);
				nDepthLength++;
			}
			if (node.right != null) {
				queue.offer(node.right);
				nDepthLength++;
			}
			if (cDepthLength > 1) {
				node.next = queue.peek();
				--cDepthLength;
			} else {
				node.next = null;
				cDepthLength = nDepthLength;
				nDepthLength = 0;
			}
		}
	}
}
