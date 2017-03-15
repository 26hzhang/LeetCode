package com.isaac.otherAlgorithms;

/**
 * it is a dynamic programming codes
 *
 */
public class Money_Change {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int money = 100;
		int[] values = { 1, 5, 10, 25, 50 };
		System.out.println(changeMoney(money, values));
	}

	// recursion solution
	public static int changeMoney(int money, int[] values) {
		return recursion(money, values, values.length);
	}

	public static int recursion(int money, int[] values, int index) {
		if (money == 0)
			return 1;
		if (money < 0 || index == 0)
			return 0;
		return recursion(money, values, index - 1) + recursion(money - values[index - 1], values, index);
	}

}
