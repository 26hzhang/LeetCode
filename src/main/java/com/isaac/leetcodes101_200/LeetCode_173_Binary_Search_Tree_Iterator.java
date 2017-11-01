package com.isaac.leetcodes101_200;

import com.isaac.nodes.TreeNode;

import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be
 * initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 *
 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
 * memory, where h is the height of the tree.
 *
 * Tags: Tree, Stack, Design
 *
 * @author ZHANG HAO
 *
 *         Explain:
 *         创建一个stack用于存储tree的最左边的节点，一直到最小的节点。之后每弹出一个最小节点，
 *         如果这个节点的右子树不空，则压入该右子树的根节点及所有的左节点。
 *
 */
public class LeetCode_173_Binary_Search_Tree_Iterator {

	public static void main(String[] args) {

	}

	class BSTIterator {
		Stack<TreeNode> stack = new Stack<TreeNode>();

		public BSTIterator(TreeNode root) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
		}

		public boolean hasNext() {
			return !stack.isEmpty();
		}

		public int next() {
			TreeNode res = stack.pop();
			TreeNode temp = res.right;
			if (temp != null) {
				stack.push(temp);
				temp = temp.left;
			}
			return res.val;
		}

	}

}
