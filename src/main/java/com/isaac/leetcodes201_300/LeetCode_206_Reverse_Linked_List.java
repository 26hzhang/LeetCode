package com.isaac.leetcodes201_300;

import com.isaac.nodes.ListNode;

public class LeetCode_206_Reverse_Linked_List {
	public static void main(String[] args) {

	}

	public static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode buf = head.next;
		head.next = null;

		while (true) {
			if (buf.next == null) {
				buf.next = head;
				return buf;
			}
			ListNode org = buf.next;
			buf.next = head;
			head = buf;
			buf = org;
		}
	}
}
