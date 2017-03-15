package com.isaac.leetcodes;

/**
 * Question:
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 * Tags: Math, String.
 *
 * @author ZHANG HAO
 * @Email isaac.changhau@gmail.com
 *
 *        Explain: 罗马数字中M=1000，D=500，C=100，L=50，X=10，V=5，I=1。
 *        特殊情况就是e.g.：IX表示9，IV表示4。temp<value用来排除这种特殊情况。
 */
public class LeetCode_013_Roman_to_Integer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int romanToInt(String s) {
		int result = 0;
		int value = 0;
		int temp = 0; //用于记录上一次的索引值，解决前面字母更小的情况
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) { //判断当前字母代表的值
			case 'M': {
				value = 1000;
				break;
			}
			case 'D': {
				value = 500;
				break;
			}
			case 'C': {
				value = 100;
				break;
			}
			case 'L': {
				value = 50;
				break;
			}
			case 'X': {
				value = 10;
				break;
			}
			case 'V': {
				value = 5;
				break;
			}
			case 'I': {
				value = 1;
				break;
			}
			}
			if (temp < value) // 因为上一次加上了temp值，所以当下一次发现小于
				result -= temp * 2;
			temp = value;
			result += value;
		}
		return result;
	}

}
