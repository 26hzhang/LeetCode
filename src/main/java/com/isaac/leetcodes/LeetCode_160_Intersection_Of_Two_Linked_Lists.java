package com.isaac.leetcodes;

public class LeetCode_160_Intersection_Of_Two_Linked_Lists {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;
		int lengthA = 0;
		int lengthB = 0;
		ListNode tmpA = headA;
		ListNode tmpB = headB;
		while (tmpA != null) {
			tmpA = tmpA.next;
			lengthA++;
		}
		while (tmpB != null) {
			tmpB = tmpB.next;
			lengthB++;
		}
		int shiftNum = Math.abs(lengthA - lengthB);
		tmpA = headA;
		tmpB = headB;
		if (lengthA > lengthB) {
			while (--shiftNum >= 0)
				tmpA = tmpA.next;
		} else {
			while (--shiftNum >= 0)
				tmpB = tmpB.next;
		}
		while (tmpA != null) {
			if (tmpA.val == tmpB.val)
				return tmpA;
			tmpA = tmpA.next;
			tmpB = tmpB.next;

		}
		return null;
	}

	/**
	 * 扩展
	 */

	// 判断两个链表是否相交，首先可以遍历一个链表到尾部，然后让尾部指向另一个链表的头部，再遍历另一个链表
	// 如果相交，那么第二个链表会形成环，这样保存第二个链表头部的hashCode，遍历第二个链表的话迟早会遍历回头部
	// 这样如果hashCode相等，说明有环，则相交
	public static boolean intersection(ListNode node1, ListNode node2) {
		ListNode tmp1 = node1;
		ListNode tmp2 = node2;
		while (tmp1.next != null) {
			tmp1 = tmp1.next;
		}
		tmp1.next = tmp2;
		int hash = node2.hashCode();
		while (tmp2.next != null) {
			tmp2 = tmp2.next;
			if (tmp2.hashCode() == hash) {
				tmp1.next = null;
				return true;
			}
		}
		tmp1.next = null;
		return false;
	}

	// 找到相交的点
	public static ListNode getPoint(ListNode node1, ListNode node2) {
		if (node1 == null || node2 == null)
			return null;
		int node1Length = 0;
		int node2Length = 0;
		ListNode tmp1 = node1;
		ListNode tmp2 = node2;
		while (tmp1 != null) {
			node1Length++;
			tmp1 = tmp1.next;
		}
		while (tmp2 != null) {
			node2Length++;
			tmp2 = tmp2.next;
		}
		int shiftNum = Math.abs(node2Length - node1Length);
		tmp1 = node1;
		tmp2 = node2;
		int i = 0;
		if (node2Length > node1Length) {
			while (i < shiftNum)
				tmp2 = tmp2.next;
		} else {
			while (i < shiftNum)
				tmp1 = tmp1.next;
		}
		while (tmp1 != null) {
			if (tmp1.hashCode() == tmp2.hashCode()) {
				return tmp1;
			}
			tmp1 = tmp1.next;
			tmp2 = tmp2.next;
		}
		return null;
	}
}
