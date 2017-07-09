package com.isaac.leetcodes201_300;

import java.util.HashSet;

/**
 * Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process: Starting with
 * any positive integer, replace the number by the sum of the squares of its
 * digits, and repeat the process until the number equals 1 (where it will
 * stay), or it loops endlessly in a cycle which does not include 1. Those
 * numbers for which this process ends in 1 are happy numbers.
 *
 * Example: 19 is a happy number
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 *
 * Tags: Hash Table, Math
 *
 * @author ZHANG HAO
 *
 *         Explain:
 *         利用HashSet的性质，HashSet的元素不能重复。因此，每次将计算结果放置在HashSet中，
 *         如果添加成功，继续循环操作，如果res值为1，说明是happy
 *         number，如果添加失败，说明之前操作已经产生了这个数据，产生了环，所以不是happy number。
 *
 *
 */
public class LeetCode_202_Happy_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isHappy(int n) {
		HashSet<Integer> hashInt = new HashSet<Integer>();
		while (true) {
			int res = 0;
			while (n > 0) {
				res += (n % 10) * (n % 10);
				n /= 10;
			}
			if (res == 1)
				return true;
			if (!hashInt.add(res))
				return false;
			n = res;
		}
	}

}
