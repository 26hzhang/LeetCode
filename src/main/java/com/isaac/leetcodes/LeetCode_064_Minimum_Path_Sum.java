package com.isaac.leetcodes;

public class LeetCode_064_Minimum_Path_Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		int m = grid.length;
		int n = grid[0].length;
		int[][] matrix = new int[m][n];
		matrix[0][0] = grid[0][0];
		for (int i = 1; i < m; i++) {
			matrix[i][0] += grid[i][0] + matrix[i - 1][0];
		}
		for (int i = 1; i < n; i++) {
			matrix[0][i] = grid[0][i] + matrix[0][i - 1];
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				matrix[i][j] = Math.min(matrix[i - 1][j], matrix[i][j - 1]) + grid[i][j];
			}
		}
		return matrix[m - 1][n - 1];
	}

}
