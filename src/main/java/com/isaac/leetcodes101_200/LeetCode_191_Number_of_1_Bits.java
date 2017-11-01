package com.isaac.leetcodes101_200;

/**
 * Write a function that takes an unsigned integer and returns the number of ’1'
 * bits it has (also known as the Hamming weight).
 * For example, the 32-bit integer ’11' has binary representation
 * 00000000000000000000000000001011, so the function should return 3.
 *
 * Hamming weight link:
 * https://en.wikipedia.org/wiki/Hamming_weight
 *
 * Tags: Bit Manipulation
 *
 * @author ZHANG HAO
 *
 *         Explain: 常规解法，bit manipulation解法：s is number of set bits in n. n & ~
 *         (n - 1) reserves the lowest set bit of n. xor with itself removes
 *         that set bit.
 *
 *
 */
public class LeetCode_191_Number_of_1_Bits {

	public static void main(String[] args) {

	}

	public static int hammingWeight(int n) {
		int count = 0;
		String str = Integer.toBinaryString(n);
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1')
				count++;
		}
		return count;
	}

	// Bit Manipulation
	public int hammingWeight1(int n) {
		int count = 0;
		//int y;
		while (n != 0) {
			count++;
			n ^= n & ~(n - 1);
		}
		return count;
	}

	// Bit Manipulation (1)
	public static int findBinaryOne(int num) {
		int count = 0;
		while (num != 0) {
			num = num & (num - 1);
			count++;
		}
		return count;
	}

	// Bit Manipulation (2)
	public static int findBinaryOne1(int num) {
		int count = 0;
		int i = 1;
		while (i != 0) {
			if ((num & i) != 0)
				count++;
			i <<= 1;
		}
		return count;
	}

}
