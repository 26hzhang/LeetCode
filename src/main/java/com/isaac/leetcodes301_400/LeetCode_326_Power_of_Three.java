package com.isaac.leetcodes301_400;

public class LeetCode_326_Power_of_Three {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 27;
		System.out.println(isPowerOfThree(n));
		//int m = n / 10 * 10;
		//System.out.println(m);
	}

	public static boolean isPowerOfThree(int n) {
		while ((n % 3) == 0 && (n = n / 3) >= 1) {
		}
		if (n == 1)
			return true;
		else
			return false;
	}
}
