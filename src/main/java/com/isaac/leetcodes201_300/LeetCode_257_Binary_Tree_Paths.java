package com.isaac.leetcodes201_300;

import com.isaac.nodes.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 *
 * For example, given the following binary tree:
 * 1
 * / \
 * 2 3
 * \
 * 5
 *
 * All root-to-leaf paths are:
 * ["1->2->5", "1->3"]
 *
 * Tags: Tree, Depth first search
 *
 * @author ZHANG HAO
 *
 *         Explain: 深度优先搜索及回溯法，遍历每个子节点。
 *
 */
public class LeetCode_257_Binary_Tree_Paths {

	public static void main(String[] args) {

	}

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> list = new ArrayList<String>();
		if (root == null)
			return list;
		StringBuffer sb = new StringBuffer();
		recursion(list, sb, root);
		return list;
	}

	public static void recursion(List<String> list, StringBuffer sb, TreeNode root) {
		if (root == null)
			return;
		int length = sb.length();
		sb.append(root.val);
		if (root.left == null && root.right == null)
			list.add(sb.toString());
		else {
			sb.append("->");
			recursion(list, sb, root.left);
			recursion(list, sb, root.right);
		}
		sb.setLength(length);
	}

	// Or
	public List<String> binaryTreePaths1(TreeNode root) {
		List<String> list = new ArrayList<String>();
		if (root == null)
			return list;
		StringBuffer sb = new StringBuffer();
		recursion1(list, sb, root);
		return list;
	}

	public static void recursion1(List<String> list, StringBuffer sb, TreeNode root) {
		if (root.left == null && root.right == null) {
			sb.append(root.val);
			list.add(sb.toString());
			return;
		}
		sb.append(root.val);
		sb.append("->");
		int orgLen = sb.length();
		if (root.left != null)
			recursion1(list, sb, root.left);
		sb.setLength(orgLen);
		if (root.right != null)
			recursion1(list, sb, root.right);
	}

}
