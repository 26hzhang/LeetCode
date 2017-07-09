package com.isaac.leetcodes101_200;

import com.isaac.nodes.ListNode;
import com.isaac.nodes.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_109_Convert_Sorted_List_To_Binary_Search_Tree {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		List<Integer> list = new ArrayList<Integer>();
		while (head != null) {
			list.add(head.val);
			head = head.next;
		}
		int[] nums = new int[list.size()];
		for (int i = 0; i < list.size(); i++)
			nums[i] = list.get(i);
		TreeNode root = recursion(nums);
		return root;
	}

	public static TreeNode recursion(int[] nums) {
		if (nums.length == 0 || nums == null)
			return null;
		TreeNode root = new TreeNode(nums[nums.length / 2]);
		root.left = recursion(Arrays.copyOfRange(nums, 0, nums.length / 2));
		root.right = recursion(Arrays.copyOfRange(nums, nums.length / 2 + 1, nums.length));
		return root;
	}
}
