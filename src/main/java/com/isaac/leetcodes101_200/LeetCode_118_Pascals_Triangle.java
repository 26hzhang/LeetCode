package com.isaac.leetcodes101_200;

import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 *
 * Tags: Array
 *
 * @author ZHANG HAO
 *
 *         Explain:
 *         杨辉三角，（行下标从0开始，列下标从0开始）每一行的数据之间是相互关联的，（i代表行，就代表列）以第4行为例，
 *         第0个数为1，第一个数为1*(4-0)/(0+1)=4，第二个数为4*(4-1)/(1+1)
 *         = 6，…，所以关系为：后一个数为：前一个数*(i - j)/(j + 1)。
 *
 */
public class LeetCode_118_Pascals_Triangle {

	public static void main(String[] args) {

	}

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		if (numRows == 0)
			return triangle;
		for (int i = 0; i < numRows; i++) {
			List<Integer> temp = new ArrayList<Integer>();
			temp.add(1);
			if (i == 0) {
				triangle.add(temp);
				continue;
			}
			for (int j = 0; j < i; j++) {
				temp.add((int) ((long) temp.get(j) * (i - j) / (j + 1)));
			}
			triangle.add(temp);
		}
		return triangle;
	}

}
