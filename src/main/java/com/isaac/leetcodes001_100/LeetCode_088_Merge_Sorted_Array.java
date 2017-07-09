package com.isaac.leetcodes001_100;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
 * one sorted array.
 *
 * Note:
 * • You may assume that nums1 has enough space (size that is greater or equal
 * to m + n) to hold additional elements from nums2. The number of elements
 * initialized in nums1 and nums2 are m and n respectively.
 *
 * Tags: Array, Two Pointers.
 *
 * @author ZHANG HAO
 *
 *         Explain:
 *         题目中，nums1和muns2均是排序后的array，所以进行直接合并，从后往前进行操作，在nums1中，
 *         每次最后面的未处理位置均放置当前nums1和nums2中最大的数，然后对应pointer前移。外层循环用n不用m的原因是，
 *         题目要求将nums2融合到nums1中，所以当nums2遍历完了，整个过程就结束了，无论nums1是否遍历完。
 *
 */
public class LeetCode_088_Merge_Sorted_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		while (n > 0) {
			if (m > 0 && nums1[m - 1] > nums2[n - 1]) {
				nums1[m + n - 1] = nums1[m - 1];
				m--;
			} else {
				nums1[m + n - 1] = nums2[n - 1];
				n--;
			}
		}
	}

}
