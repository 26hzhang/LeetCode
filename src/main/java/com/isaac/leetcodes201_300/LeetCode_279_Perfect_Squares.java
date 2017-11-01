package com.isaac.leetcodes201_300;

/**
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13,
 * return 2 because 13 = 4 + 9.
 *
 * Tags: Dynamic Programming, Breath-first Search, Math.
 *
 * @author ZHANG HAO
 *
 *        Explain:
 *        方法一是用递归，但是对此题来说会超时。方法二使用动态规划，创建长度为n+1的辅助数组，每个位置记录当前数字的最小表达的个数。
 *        后面的数一定是由前面的数表达得到的，所以只用通过遍历前面的数就可以得到最终的结果。
 *        I'm modifying on the most voted answer.
 *        For the loop, I do from sqrt(i) to 1 instead of 1 to sqrt(i), the idea
 *        is to find good answer faster, and then use j × j × record[i]>i to end
 *        the loop.
 *        The idea is that, e.g., we are doing 12, if we already find an answer
 *        with 3 numbers, then we don't need to do j<=2, because j=2 will give
 *        answer of 3 at best (since 4*3=12), j=1 will give even worse answer.
 *
 */
public class LeetCode_279_Perfect_Squares {

	public static void main(String[] args) {
		int n = 12;
		System.out.println(numSquares(n));
		System.out.println(numSquares2(n));
	}

	// method 1
	public static int numSquares(int n) {
		int num = (int) Math.sqrt(n);
		if (num * num == n)
			return 1;
		int[] res = new int[1];
		res[0] = Integer.MAX_VALUE;
		recursion(res, 0, num, n, 0);
		return res[0];
	}

	public static void recursion(int[] res, int count, int num, int n, int temp) {
		if (n == temp && res[0] > count) {
			res[0] = count;
			return;
		}
		for (int i = num; i > 0; i--) {
			int ans = i * i;
			if (temp + ans <= n) {
				recursion(res, count + 1, num, n, temp + ans);
			}
		}
	}

	// method 2
	public static int numSquares2(int n) {
		int[] res = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			res[i] = i;
			for (int j = (int) Math.sqrt(i); j * j * res[i] > i; j--) {
				res[i] = Math.min(res[i - j * j] + 1, res[i]);
			}
		}
		return res[n];
	}

}
