package com.isaac.leetcodes201_300;

import java.util.HashMap;

/**
 * Given an array of integers and an integer k, find out whether there are two
 * distinct indices i and j in the array such that nums[i] = nums[j] and the
 * difference between i and j is at most k.
 *
 * Tags: Array, Hash Table
 *
 * @author ZHANG HAO
 *
 *         Explain:
 *         利用HashMap的性质，HashMap的key值不可重复，null可以做为key/value。
 *         另外HashMap线程不安全，而HashTable线程安全，但是null不可以做为key/value。
 *
 */
public class LeetCode_219_Contains_Duplicate_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (hashMap.containsKey(nums[i]) && i - hashMap.get(nums[i]) <= k)
				return true;
			hashMap.put(nums[i], i);
		}
		return false;
	}

}
