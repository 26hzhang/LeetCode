package com.isaac.leetcodes301_400;

public class LeetCode_371_Sum_of_Two_Integers {

	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		System.out.println(new LeetCode_371_Sum_of_Two_Integers().getSum(a, b));
	}

	/**
	 * 不用加减乘除做加法；
	 * 十进制中的18和7相加；可以分成这样三步来计算：一.无进位的各个位相加得18+7=15；二.18加7的进位是10
	 * 三.用一和二的结果相加15+10=25
	 * 对数字运算除了使用四则运算，那就剩下位运算了，而位运算是针对二进制的运算
	 * 18在计算机中用：10010 7在计算机中用：111
	 * 一.无进位的各个位相加得10010+111=10101；注意观察相加的结果值和 这两个数进行异或的值相等
	 * 二.进位是10010+111=100 求两数相加的进位，相当于两数做按位与运算后再左移一位
	 * 三.再用10101+100发现还有进位，用10101和100重复第一第二步骤，异或得10001
	 * 按位与后左移一位得 进位值是1000
	 * 此时10001+1000=11001 没有进位，相当于两数做异或运算
	 *
	 * 所以编程时，只要写一个循环 对两个数反复做 异或和按位与后左移一位操作 直到没有进位后
	 * 输出两个数的异或值。
	 *
	 */
	public int getSum(int a, int b) {
		if (a == 0 || b == 0)
			return a == 0 ? b : a;
		int sum = 0;
		while (b != 0) {
			sum = a ^ b;
			b = (a & b) << 1;
			a = sum;
		}
		return sum;
	}

}
