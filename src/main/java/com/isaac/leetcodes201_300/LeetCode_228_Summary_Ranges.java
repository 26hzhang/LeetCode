package com.isaac.leetcodes201_300;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its
 * ranges.
 *
 * For example:
 * given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 *
 * Tags: Array.
 *
 * @author ZHANG HAO
 *
 */
public class LeetCode_228_Summary_Ranges {

	public static void main(String[] args) {

	}

	public static List<String> summaryRanges(int[] nums) {
		List<String> list = new ArrayList<String>();
		if (nums == null || nums.length == 0)
			return list;
		int start = 0;
		int end = 0;
		int length = nums.length;
		while (end < length) {
			if (end < length - 1 && nums[end] + 1 == nums[end + 1])
				end++;
			else {
				if (start == end)
					list.add(String.valueOf(nums[end]));
				else {
					StringBuilder sb = new StringBuilder(String.valueOf(nums[start]));
					sb.append("->").append(String.valueOf(nums[end]));
					list.add(sb.toString());
				}
				end++;
				start = end;
			}
		}
		return list;
	}

}
