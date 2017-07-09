package com.isaac.otherAlgorithms;

import java.util.Stack;

/**
 * it is a dynamic programming codes
 *
 */
public class Compound_Mode_of_Parentheses {
	//1：从左边起算，左括号一定大于等于右括号
	//2：左括号，右括号个数均不能超过总数一半
	public static int sum = 0;
	public static Stack<Character> stack = new Stack<Character>();

	public static void main(String[] args) {
		System.out.println(compoundMode(0, 0, 8, 8));
	}

	public static int compoundMode(int first, int second, int num, int count) {
		if (first < second || num < 0 || first > (num >> 1) || second > (num >> 1))
			return -1;
		if (first == (num >> 1) && second == (num >> 1) && count == 0) {
			sum++;
			for (char c : stack) {
				System.out.print(c);
			}
			System.out.println();
		}
		first++;
		stack.push('(');
		compoundMode(first, second, num, count - 1);
		first--;
		stack.pop();
		second++;
		stack.push(')');
		compoundMode(first, second, num, count - 1);
		second--;
		stack.pop();
		return sum;
	}

}
