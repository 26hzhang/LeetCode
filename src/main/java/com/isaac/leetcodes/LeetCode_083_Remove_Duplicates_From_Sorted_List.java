package com.isaac.leetcodes;

public class LeetCode_083_Remove_Duplicates_From_Sorted_List {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return head;
		ListNode tmp = head;
		ListNode tmp1 = head.next;
		while (tmp1 != null) {
			if (tmp.val == tmp1.val) {
				tmp.next = tmp1.next;
			} else {
				tmp = tmp1;
			}
			tmp1 = tmp.next;
		}
		return head;
	}
}
