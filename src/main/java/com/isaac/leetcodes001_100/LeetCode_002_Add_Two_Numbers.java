package com.isaac.leetcodes001_100;

import com.isaac.nodes.ListNode;

/**
 * Created by zhanghao on 9/7/17.
 * @author ZHANG HAO
 */
public class LeetCode_002_Add_Two_Numbers {
    public static void main (String[] args) {
        ListNode list1 = new ListNode(2);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(3);
        ListNode list2 = new ListNode(5);
        list2.next = new ListNode(6);
        list2.next.next = new ListNode(4);
        ListNode res = addTwoNumbers(list1, list2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(carry);
        ListNode index = head;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            index.next = new ListNode(carry % 10);
            carry = carry / 10;
            index = index.next;
        }
        if (carry == 1)
            index.next = new ListNode(1);
        return head.next;
    }
}
