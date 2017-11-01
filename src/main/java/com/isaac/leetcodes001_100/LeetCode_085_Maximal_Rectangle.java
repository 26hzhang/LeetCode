package com.isaac.leetcodes001_100;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
 * containing all ones and return its area.
 *
 * Tags: Array, Hash table, Stack, Dynamic Programming
 *
 * @author ZHANG HAO
 *
 */
public class LeetCode_085_Maximal_Rectangle {

	public static void main(String[] args) {
		//char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } };
		char[][] mat = { { '1', '0', '1', '0' }, { '1', '0', '1', '1' }, { '1', '0', '1', '1' }, { '1', '1', '1', '1' } };
		System.out.println(maximalRectangle(mat));

	}

	private static int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] vertical = new int[m][n];
		for (int i = 0; i < n; i++)
			vertical[0][i] = matrix[0][i] - '0';
		// update vertical map
		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '0')
					vertical[i][j] = 0;
				else
					vertical[i][j] = vertical[i - 1][j] + 1;
			}
		}
		int max = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int area = vertical[i][j];
				int k = j - 1;
				while (k >= 0) {
					if (vertical[i][k] >= vertical[i][j]) {
						area += vertical[i][j];
						k--;
					} else
						break;
				}
				k = j + 1;
				while (k < n) {
					if (vertical[i][k] >= vertical[i][j]) {
						area += vertical[i][j];
						k++;
					} else
						break;
				}
				max = Math.max(area, max);
			}
		}
		return max;
	}

}
