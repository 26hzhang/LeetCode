package com.isaac.leetcodes301_400;

import com.isaac.nodes.TreeNode;

/**
 * The thief has found himself a new place for his thievery again. There is only
 * one entrance to this area, called the "root." Besides the root, each house
 * has one and only one parent house. After a tour, the smart thief realized
 * that "all houses in this place forms a binary tree". It will automatically
 * contact the police if two directly-linked houses were broken into on the same
 * night.
 *
 * Determine the maximum amount of money the thief can rob tonight without
 * alerting the police.
 *
 * Example 1:
 * 3
 * / \
 * 2 3
 * \ \
 * 3 1
 * Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
 * Example 2:
 * 3
 * / \
 * 4 5
 * / \ \
 * 1 3 1
 * Maximum amount of money the thief can rob = 4 + 5 = 9.
 *
 * Tags: Tree, Depth-First Search.
 *
 * @author ZHANG HAO
 *
 *         Explain: DFS遍历分为两种情况，一种是从root开始，一种是不从root开始，
 *         如此迭代至所有的节点被遍历一遍，取最大值
 *
 */
public class LeetCode_337_House_Robber_III {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int rob(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(hasRoot(root), noRoot(root));
	}

	public static int noRoot(TreeNode root) {
		if (root == null)
			return 0;
		return rob(root.left) + rob(root.right);
	}

	public static int hasRoot(TreeNode root) {
		if (root == null)
			return 0;
		return noRoot(root.left) + noRoot(root.right) + root.val;
	}

}
