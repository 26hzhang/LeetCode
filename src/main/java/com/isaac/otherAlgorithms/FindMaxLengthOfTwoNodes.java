package com.isaac.otherAlgorithms;

public class FindMaxLengthOfTwoNodes {
	//  二叉树中节点的最大距离
	static int maxLength = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 无返回值
	public static void getMaxLength(TNode root) {
		if (root == null)
			return;
		if (root.left != null) {
			getMaxLength(root.left);
			root.maxLeftLength = Math.max(root.left.maxLeftLength, root.left.maxRightLength) + 1;
		}
		if (root.right != null) {
			getMaxLength(root.right);
			root.maxRightLength = Math.max(root.right.maxLeftLength, root.right.maxRightLength) + 1;
		}
		maxLength = Math.max(maxLength, root.maxLeftLength + root.maxRightLength);
	}

	// 有返回值
	public static int getMaxLen(TNode root) {
		if (root == null)
			return 0;
		if (root.left != null) {
			root.maxLeftLength = getMaxLen(root.left) + 1;
		} else {
			root.maxLeftLength = 0;
		}
		if (root.right != null) {
			root.maxRightLength = getMaxLen(root.right) + 1;
		} else {
			root.maxRightLength = 0;
		}
		if (maxLength < root.maxLeftLength + root.maxRightLength)
			maxLength = root.maxLeftLength + root.maxRightLength;
		return Math.max(root.maxLeftLength, root.maxRightLength);
	}
}

class TNode {
	int maxRightLength = 0;
	int maxLeftLength = 0;
	TNode left;
	TNode right;
}