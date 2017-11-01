package com.isaac.leetcodes201_300;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square
 * containing all 1's and return its area.
 *
 * For example, given the following matrix:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * Return 4.
 *
 * Tags: Dynamic Programming
 *
 * @author ZHANG HAO
 *
 */
public class LeetCode_221_Maximal_Square {

	public static void main(String[] args) {
		char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } };
		//char[][] matrix1 = {};
		System.out.println(maximalSquare(matrix));
	}

	public static int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] map = new int[m][n];
		for (int i = 0; i < m; i++)
			map[i][0] = matrix[i][0] - '0';
		for (int i = 0; i < n; i++)
			map[0][i] = matrix[0][i] - '0';
		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == '0')
					map[i][j] = 0;
				else {
					map[i][j] = Math.min(map[i - 1][j], Math.min(map[i][j - 1], map[i - 1][j - 1])) + 1;
				}
			}
		int max = 0;
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				if (map[i][j] > max)
					max = map[i][j];
			}
		return max * max;
	}

}
