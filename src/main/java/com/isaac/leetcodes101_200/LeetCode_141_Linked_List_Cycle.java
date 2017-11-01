package com.isaac.leetcodes101_200;

import com.isaac.nodes.ListNode;

public class LeetCode_141_Linked_List_Cycle {
	public static void main(String[] args) {

	}

	// 指定俩指针，指向链表，一个步进为1(slow)，另一个步进为2(fast)，如果存在循环，
	// 迟早某一步slow == fast，此时，返回ture
	public boolean hasCycle(ListNode head) {
		if (head == null)
			return false;
		ListNode fast = head;
		ListNode slow = head;
		do {
			if (fast.next == null || fast.next.next == null)
				return false;
			fast = fast.next.next;
			slow = slow.next;
		} while (slow != fast);
		return true;
	}
}
