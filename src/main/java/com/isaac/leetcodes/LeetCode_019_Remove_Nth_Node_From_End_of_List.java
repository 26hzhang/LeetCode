package com.isaac.leetcodes;

public class LeetCode_019_Remove_Nth_Node_From_End_of_List {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//双指针思想，两个指针相距n－1，当后面的指针没有后继了，前面的指针的next就是要删除的点
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode l1 = head;
		ListNode l2 = l1;
		int i = 0;
		while (i < n) {
			l1 = l1.next;
			i++;
		}
		if (l1 == null) {
			return head.next;
		}
		while (l1.next != null) {
			l1 = l1.next;
			l2 = l2.next;
		}
		l2.next = l2.next.next;
		return head;
	}
}
