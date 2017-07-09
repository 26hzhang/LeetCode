package com.isaac.leetcodes101_200;

import com.isaac.nodes.ListNode;

/**
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null.
 * Note: Do not modify the linked list.
 *
 * Follow up:
 * Can you solve it without using extra space?
 *
 * Tags: Linked List, Two Pointers.
 *
 * @author ZHANG HAO
 *
 *         Explain: First Step: Assume the first pointer runs from head at a
 *         speed of 1-by-1 step, as S, and the second pointer runs at a speed of
 *         2-by-2 step, as 2S, then two pointers will meet at MEET-POINT, using
 *         the same time. Define outer loop is A, the distance from
 *         CIRCLE-START-POINT to MEET-POINT is B, and the distance from
 *         MEET-POINT to CIRCLE-START-POINT is C (Apparently, C=loop-B), then (n
 *         * loop + a + b) / 2S = (a + b) / S, n=1,2,3,4,5,....
 *         Converting that equation can get A/S=n loop / S – B / S. Since C =
 *         loop - B, get A/S = ((n-1) loop + C)/S.
 *         That means, as second step, assuming a pointer running from head and
 *         another pointer running from MEET-POINT both at a speed S will meet
 *         at CIRCLE-START-POINT;
 *
 */
public class LeetCode_142_Linked_List_Cycle_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null)
			return null;
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) { // detect the circle
				slow = head;
				while (slow != fast) {
					fast = fast.next;
					slow = slow.next;
				}
				return slow;
			}
		}
		return null;
	}

}
