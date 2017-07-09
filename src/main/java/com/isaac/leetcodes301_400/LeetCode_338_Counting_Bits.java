package com.isaac.leetcodes301_400;

/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤
 * i ≤ num calculate the number of 1's in their binary representation and return
 * them as an array.
 *
 * Example:
 * For num = 5, you should return [0,1,1,2,1,2].
 *
 * Follow up:
 * • It is very easy to come up with a solution with run time
 * O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a
 * single pass?
 * • Space complexity should be O(n).
 * • Can you do it like a boss? Do it without using any builtin function like
 * _builtin_popcount in C++ or in any other language.
 *
 * Hint:
 * • You should make use of what you have produced already.
 * • Divide the numbers in ranges like [2-3], [4-7], [8-15] and so on. And try
 * to generate new range from previous.
 * • Or does the odd/even status of the number help you in calculating the
 * number of 1s?
 *
 * Tags: Dynamic Programming, Bit Manipulation.
 *
 * @author ZHANG HAO
 *
 *         Explain: 如题中Hint叙述，后面的数据的二进制1的数目与前面的数有关。例如：
 *         0：0个，1：1个；
 *         2：10-->1个，3：11-->2个；
 *         4：100-->1个，5：101-->2个，6：110-->2个，7：111-->3个；
 *         从上面我们可以看出，count[2] = count[2 % 2] + 1，count[3] = count[3 % 2] + 1；
 *         count[4] = count[4%4] +1，count[5] = count[5%4] +1，count[7] =
 *         count[7%4] + 1；
 *         因此，我们可以将数据分为[0-1], [2-3], [4-7], [8-15]这样的组。这样每组的值都可以有前面对应的值+1得到。
 *
 */
public class LeetCode_338_Counting_Bits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int[] countBits(int num) {
		int[] count = new int[num + 1];
		if (num == 0)
			return count;
		count[1] = 1;
		if (num == 1) {
			return count;
		}
		int i = 2;
		int index = 1;
		while (i <= num) {
			if (i == index * 2) {
				index = i;
			}
			count[i] = count[i % index] + 1;
			i++;
		}
		return count;
	}

}
