package com.isaac.otherAlgorithms;

import com.isaac.nodes.ListNode;

public class InPlaceSortLinkedList {

	public static void main(String[] args) {

	}

	public static void SortLinkedList(ListNode head) {
		ListNode pre = head; // 记录前驱位置
		ListNode p = head; // 记录当前位置1
		ListNode q = head.next; // 记录当前位置2
		ListNode post = null; // 记录后继
		p.next = null;
		while (q != null) {
			pre = head;
			p = head;
			while (p != null && p.val < q.val) {
				pre = p;
				p = p.next;
			}
			post = q.next;
			pre.next = q;
			q.next = p;
			q = post;
		}
	}
}
