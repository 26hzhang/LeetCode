package com.isaac.leetcodes001_100;

public class LeetCode_048_Rotate_Image {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return;
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - i - 1; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - j][i];
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
				matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
				matrix[j][n - 1 - i] = tmp;
			}
		}
	}

}
