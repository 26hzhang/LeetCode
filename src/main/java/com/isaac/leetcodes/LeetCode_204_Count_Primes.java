package com.isaac.leetcodes;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * Hint: shown in https://leetcode.com/problems/count-primes/
 *
 * Tags: Hash Table, Math.
 *
 * @author ZHANG HAO
 *
 */
public class LeetCode_204_Count_Primes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int countPrimes(int n) {
		boolean[] isComposite = new boolean[n];//initialized with all false;
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (!isComposite[i]) {
				count++;
				if (i < Math.sqrt(n))
					for (int j = i * i; j < n; j += i)
						isComposite[j] = true;// Mark j as a composite number
			}
		}
		return count;
	}

}
