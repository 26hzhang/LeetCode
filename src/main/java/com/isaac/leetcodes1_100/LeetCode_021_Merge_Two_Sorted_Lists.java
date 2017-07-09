package com.isaac.leetcodes1_100;

import com.isaac.nodes.ListNode;

public class LeetCode_021_Merge_Two_Sorted_Lists {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode tmp = head;
		tmp.next = l1;
		while (l1 != null && l2 != null) {
			if (l1.val > l2.val) {
				tmp.next = l2;
				l2 = l1;
			}
			tmp = tmp.next;
			l1 = tmp.next;
		}
		if (l2 != null)
			tmp.next = l2;
		return head.next;
	}
}
