package com.isaac.leetcodes201_300;

/**
 * Write a program to check whether a given number is an ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 6, 8 are ugly while 14 is not ugly since it includes another
 * prime factor 7.
 * Note that 1 is typically treated as an ugly number.
 *
 * Tags: Math.
 *
 * @author ZHANG HAO
 *
 */
public class LeetCode_263_Ugly_Number {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static boolean isUgly(int num) {
		if (num == 1)
			return true;
		while (num > 1) {
			if (num % 2 == 0)
				num /= 2;
			else if (num % 3 == 0)
				num /= 3;
			else if (num % 5 == 0)
				num /= 5;
			else
				break;
		}
		return (num == 1) ? true : false;
	}

}
