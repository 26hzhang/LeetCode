package com.isaac.leetcodes201_300;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the
 * result has only one digit.
 * For example:
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only
 * one digit, return it.
 *
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 *
 * Hint:
 * 1. A naive implementation of the above process is trivial. Could you come up
 * with other methods?
 * 2. What are all the possible results?
 * 3. How do they occur, periodically or randomly?
 * 4. You may find this Wikipedia article useful.
 *
 * Tags: Math
 *
 * Wikipedia article link:
 * https://en.wikipedia.org/wiki/Digital_root
 *
 * @author ZHANG HAO
 *
 *         Explain: 对于这个问题，如果num小于10，则直接输出。若num大于等于10，只需要求num除以9的余数，即是所求解。
 *
 */
public class LeetCode_258_Add_Digits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int addDigits(int num) {
		if (num < 10) {
			return num;
		} else {
			if ((num % 9) != 0) {
				return num % 9;
			} else {
				return 9;
			}
		}
	}

}
