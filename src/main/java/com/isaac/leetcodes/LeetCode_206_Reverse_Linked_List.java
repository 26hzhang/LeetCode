package com.isaac.leetcodes;

public class LeetCode_206_Reverse_Linked_List {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
