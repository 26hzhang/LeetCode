package com.isaac.leetcodes;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 * For example, given input 43261596 (represented in binary as
 * 00000010100101000001111010011100), return 964176192 (represented in binary as
 * 00111001011110000010100101000000).
 *
 * Follow up:
 * • If this function is called many times, how would you optimize it?
 *
 * Tags: Bit Manipulation.
 *
 * @author ZHANG HAO
 *
 *         Explain: 利用Java自带函数或者转换为binary
 *         string进行交换操作。注意，反转后的数可能值大于Integer.MAX_VALUE，这种情况下返回0。
 *
 */
public class LeetCode_190_Reverse_Bits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int reverseBits(int n) {

		return Integer.reverse(n);
		//		int res = 0;
		//		int num = 0;
		//		String str = Integer.toBinaryString(n);
		//		while (str.length() < 32) {
		//			str = "0" + str;
		//		}
		//		System.out.println(str.length() + " " + str + "\n");
		//		for (int i = 0; i < str.length(); i++) {
		//			//System.out.print(str.charAt(i));
		//			if (str.charAt(i) == '0') {
		//				num += 1;
		//			} else {
		//				res += (int) Math.pow(2, num);
		//				num +=1;
		//				System.out.println(res);
		//			}
		//		}
		//		//System.out.println("\n");
		//		return res;
	}

	// Or
	public int reverseBits2(int n) {
		int ans = 0;
		for (int i = 0; i < 32; i++, n = n >> 1) {
			if ((n & 1) == 1)
				ans++;
			if (i != 31)
				ans *= 2;
		}
		return ans;
	}

}
