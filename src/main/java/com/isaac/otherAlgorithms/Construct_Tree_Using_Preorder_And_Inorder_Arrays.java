package com.isaac.otherAlgorithms;

public class Construct_Tree_Using_Preorder_And_Inorder_Arrays {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static TreeNode treeBuilder(int[] preorder, int[] inorder, int start, int end, int length) {
		if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0 || length <= 0)
			return null;
		int val = preorder[start];
		TreeNode root = new TreeNode(val);
		if (length == 1)
			return root;
		int i = 0;
		while (i < length) {
			if (val == inorder[i])
				break;
			i++;
		}
		root.left = treeBuilder(preorder, inorder, start + 1, end - i - 1, length - 1 - i);
		root.right = treeBuilder(preorder, inorder, start + length - i, end, i);
		return root;
	}

}
