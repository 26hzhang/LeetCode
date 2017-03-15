package com.isaac.leetcodes;

/**
 * Question:
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 * of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * P---A---H---N
 * A-P-L-S-I-I-G
 * Y---I---R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a
 * number of rows:
 *
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 *
 * @author ZHANG HAO
 * @Email isaac.changhau@gmail.com
 *
 */
public class LeetCode_006_ZigZag_Conversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "PAYPALISHIRING";
		int numRows = 3;
		System.out.println(convert(str, numRows));
	}

	public static String convert(String s, int numRows) {
		if (s.length() <= numRows || numRows == 1)
			return s;
		String str = "";
		int n = 1;
		while (n <= numRows) {
			int i = n - 1;
			if (n == 1 || n == numRows) {
				int step = 2 * numRows - 2;
				while (i < s.length()) {
					str = str + s.charAt(i);
					i += step;
				}
			} else {
				int step1 = 2 * numRows - 2 * n;
				int step2 = 2 * (n - 1);
				int count = 0;
				while (i < s.length()) {
					str = str + s.charAt(i);
					if (count == 0) {
						i += step1;
						count = 1;
					} else {
						i += step2;
						count = 0;
					}
				}
			}
			n++;
		}
		return str;
	}

}
