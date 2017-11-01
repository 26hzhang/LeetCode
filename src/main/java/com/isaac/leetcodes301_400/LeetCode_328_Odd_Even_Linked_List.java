package com.isaac.leetcodes301_400;

import com.isaac.nodes.ListNode;

public class LeetCode_328_Odd_Even_Linked_List {
	// Given a singly linked list, group all odd nodes together followed by the even nodes. 
	// Please note here we are talking about the node number and not the value in the nodes.
	// You should try to do it in place. 
	// The program should run in O(1) space complexity and O(nodes) time complexity.
	// Example:
	// Given 1->2->3->4->5->NULL,
	// return 1->3->5->2->4->NULL.
	public static void main(String[] args) {

	}

	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null)
			return head;
		ListNode markEven = head.next;
		ListNode tmp1 = head;
		ListNode tmp2 = head.next;
		ListNode tmp3 = head;
		while (tmp3 != null && tmp3.next != null && tmp3.next.next != null) {
			tmp3 = tmp3.next.next;
			tmp1.next = tmp3;
			tmp2.next = tmp3.next;
			tmp1 = tmp1.next;
			tmp2 = tmp2.next;
		}
		tmp1.next = markEven;
		return head;
	}
}
