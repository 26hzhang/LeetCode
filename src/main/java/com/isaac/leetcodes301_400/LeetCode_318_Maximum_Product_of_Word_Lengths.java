package com.isaac.leetcodes301_400;

/**
 * Question:
 * Given a string array words, find the maximum value of length(word[i]) *
 * length(word[j]) where the two words do not share common letters. You may
 * assume that each word will contain only lower case letters. If no such two
 * words exist, return 0.
 *
 * Example 1:
 * Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
 * Return 16
 * The two words can be "abcw", "xtfn".
 *
 * Example 2:
 * Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
 * Return 4
 * The two words can be "ab", "cd".
 *
 * Example 3:
 * Given ["a", "aa", "aaa", "aaaa"]
 * Return 0
 * No such pair of words.
 *
 * Tags: Bit Manipulation
 *
 * @author ZHANG HAO
 * @Email isaac.changhau@gmail.com
 *
 *        Explain: 字符最多只有26个，因此每个字符串可以用一个二进制数来表示它含有哪些字符。
 *        最后循环遍历整个string数列，找到没有相同字符且长度乘积最大的值。
 *
 */
public class LeetCode_318_Maximum_Product_of_Word_Lengths {

	public static void main(String[] args) {
		String[] words = { "abcw", "baz", "foo", "bar", "xtfn", "abcdef" };
		System.out.println(maxProduct(words));
	}

	private static int maxProduct(String[] words) {
		int products = 0;
		int[] binaryIndex = new int[words.length];
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				//相当于建立一个二进制矩阵索引来记录String中各个字符，对于a字符来说，不左移，对于z字符来说，
				//左移25位，然后与上一次结果求或，最终得到索引值
				binaryIndex[i] = binaryIndex[i] | (1 << (words[i].charAt(j) - 'a'));
			}
		}
		for (int i = 0; i < words.length; i++) {
			for (int j = i + 1; j < words.length; j++) {
				if ((binaryIndex[i] & binaryIndex[j]) == 0) {
					products = Math.max(products, words[i].length() * words[j].length());
				}
			}
		}
		return products;
	}

}
