package com.isaac.leetcodes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_107_Binary_Tree_Level_Order_Traversal_II {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> listList = new ArrayList<List<Integer>>();
		if (root == null)
			return listList;
		int curLength = 1;
		int nextLength = 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<Integer> list = new ArrayList<Integer>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			list.add(node.val);
			if (node.left != null) {
				queue.offer(node.left);
				nextLength++;
			}
			if (node.right != null) {
				queue.offer(node.right);
				nextLength++;
			}
			if (curLength > 1) {
				curLength--;
			} else {
				listList.add(list);
				list = new ArrayList<Integer>();
				curLength = nextLength;
				nextLength = 0;
			}
		}
		Collections.reverse(listList);
		return listList;
	}
}
