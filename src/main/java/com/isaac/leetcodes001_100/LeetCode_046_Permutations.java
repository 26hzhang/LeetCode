package com.isaac.leetcodes001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Question:
 * Given a collection of distinct numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 *
 * @author: ZHANG HAO
 *
 *         Explain: 此题给定的Array每个元素均不同，对于字符串的排列组合问题，均可以利用backtrack的思想求解。
 *         如题目中例子给出的[1,2,3]，其所有排列组合结果如下：
 *         [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 *         首先考虑[2,1,3]和[3,2,1]是如何得出的。显然这两个数均是由1和后面的2或者3置换得到的结果。
 *         然后可以将[1,2,3]中第二个数和第三个数置换得到[1,3,2]。同理可以根据[2,1,3]和[3,2,1]来得[2,3,1]和[3,1,2]。
 *         因此可以知道——全排列就是从第一个数字起每个数分别与它后面的数字交换。找到这个规律之后，我们可以利用递归得出结果。
 *
 */
public class LeetCode_046_Permutations {

	public static void main(String[] args) {
		int[] num = { 1, 2, 3 };
		List<List<Integer>> list = permute(num);
		for (List<Integer> l : list) {
			System.out.println(Arrays.toString(l.toArray()));
		}
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> listList = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return listList;
		recursion(listList, new ArrayList<>(), nums);
		return listList;
	}

	// recursion
	public static void recursion(List<List<Integer>> listList, List<Integer> list, int[] nums) {
		if (nums.length == list.size()) {
			listList.add(new ArrayList<>(list));
			return;
		}
		for (int n : nums) {
			if (!list.contains(n)) {
				list.add(n);
				recursion(listList, list, nums);
				list.remove(list.size() - 1); // backtrack
			}
		}
	}

	// another similar method
	public static List<List<Integer>> permute2(int[] nums) {
		List<List<Integer>> lList = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0)
			return lList;
		recursion(lList, nums, 0);
		return lList;
	}

	public static void recursion(List<List<Integer>> lList, final int[] nums, int start) {
		if (start == nums.length) {
			lList.add(new ArrayList<Integer>() {
				private static final long serialVersionUID = 1L;
				{ // initialization block
					for (int i = 0; i < nums.length; i++)
						add(nums[i]);
				}
			});
			return;
		} else {
			for (int i = start; i < nums.length; i++) {
				int tmp = nums[i];
				nums[i] = nums[start];
				nums[start] = tmp;
				recursion(lList, nums, start + 1);
				tmp = nums[i];
				nums[i] = nums[start];
				nums[start] = tmp;
			}
		}
	}

}
