package com.isaac.leetcodes001_100;

import com.isaac.nodes.ListNode;

public class LeetCode_061_Rotate_List {
	public static void main(String[] args) {

	}

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;
		ListNode tail = head;
		int len = 1;
		while (tail.next != null) {
			len++;
			tail = tail.next;
		}
		tail.next = head;
		k = k % len;
		int i = 0;
		ListNode pre = head;
		while (i < len - k - 1) {
			pre = pre.next;
			i++;
		}
		head = pre.next;
		pre.next = null;
		return head;
	}
}
