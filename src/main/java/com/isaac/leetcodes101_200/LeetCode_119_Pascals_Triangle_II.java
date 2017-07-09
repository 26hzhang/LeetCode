package com.isaac.leetcodes101_200;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3,
 * Return [1,3,3,1].
 *
 * Note:
 * • Could you optimize your algorithm to use only O(k) extra space?
 *
 * Tags: Array
 *
 * @author ZHANG HAO
 *
 *         Explain: 同118
 *
 */
public class LeetCode_119_Pascals_Triangle_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static List<Integer> getRow(int rowIndex) {
		List<Integer> triRow = new ArrayList<Integer>();
		triRow.add(1);
		for (int i = 0; i < rowIndex; i++) {
			triRow.add((int) ((long) triRow.get(i) * (rowIndex - i) / (i + 1)));
			//triRow.add( triRow.get(i) * (rowIndex - i) / (i + 1) );
		}
		return triRow;
	}

}
