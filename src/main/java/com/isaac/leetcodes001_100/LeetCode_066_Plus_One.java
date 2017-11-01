package com.isaac.leetcodes001_100;

/**
 * Given a non-negative number represented as an array of digits, plus one to
 * the number.
 * The digits are stored such that the most significant digit is at the head of
 * the list.
 *
 * Tags: Array, Math.
 *
 * @author ZHANG HAO
 *
 *         Explain: 遇10进1，注意第一位(即最高位)，如果是0的话，则说明最高位也存在进位，
 *         最终的结果Array应该比原Array长度大1。
 *
 */
public class LeetCode_066_Plus_One {

	public static void main(String[] args) {

	}

	public static int[] PlusOne(int[] digits) {
		int[] res = new int[digits.length + 1];
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i] += 1;
				break;
			} else {
				digits[i] = 0;
			}
		}
		if (digits[0] != 0)
			return digits;
		else {
			res[0] = 1;
			System.arraycopy(digits, 0, res, 1, digits.length);
			return res;
		}
	}

}
