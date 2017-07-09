package com.isaac.leetcodes201_300;

import com.isaac.nodes.ListNode;

public class LeetCode_234_Palindrome_Linked_List {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;
		//求list的长度
		ListNode tmp = head;
		int count = 0;
		while (tmp != null) {
			count++;
			tmp = tmp.next;
		}
		ListNode right = head;
		//找到对称的右边的起始点
		for (int i = 0; i < ((count % 2 == 0) ? count / 2 : count / 2 + 1); i++) {
			right = right.next;
		}
		//反转左边的list，将左边和右边进行比较
		ListNode left = null;
		while (head != right) {
			tmp = head.next;
			head.next = left;
			left = head;
			head = tmp;
		}
		if ((count % 2) != 0) // 若为奇数长度，删除第一个元素，从left第二个元素开始
			left = left.next;
		while (left != null && right != null) {
			if (left.val != right.val)
				return false;
			left = left.next;
			right = right.next;
		}
		return true;
	}
}
