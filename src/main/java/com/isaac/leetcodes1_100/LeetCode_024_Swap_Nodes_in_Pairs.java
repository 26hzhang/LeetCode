package com.isaac.leetcodes1_100;

import com.isaac.nodes.ListNode;

public class LeetCode_024_Swap_Nodes_in_Pairs {
	public static void main(String[] args) {

	}

	public static ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode cur1 = head;
		ListNode cur2 = head.next;
		ListNode pre = null;
		head = head.next;
		while (cur1 != null && cur2 != null) {
			cur1.next = cur2.next;
			cur2.next = cur1;
			if (pre != null)
				pre.next = cur2;
			pre = cur1;
			cur1 = cur1.next;
			if (cur1 != null)
				cur2 = cur1.next;
		}
		return head;
	}
}
