package com.isaac.leetcodes201_300;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 *
 * For example,
 * Consider the following matrix:
 * [
 * [1, 4, 7, 11, 15],
 * [2, 5, 8, 12, 19],
 * [3, 6, 9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 * Given target = 20, return false.
 *
 * Tags: Binary Search, Divide and Conquer
 *
 * @author ZHANG HAO
 *
 */
public class LeetCode_240_Search_a_2D_Matrix_II {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } };
		//int[][] matrix1 = { { 1, 4 }, { 2, 5 } };
		int target = 2;
		System.out.println(searchMatrix(matrix, target));
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;
		int m = matrix.length;
		int n = matrix[0].length;
		for (int i = 0; i < m; i++) {
			if (matrix[i][0] <= target && matrix[i][n - 1] >= target) {
				int high = n - 1;
				int low = 0;
				while (low <= high) {
					int middle = (low + high) / 2;
					if (matrix[i][middle] > target)
						high = middle - 1;
					else if (matrix[i][middle] < target)
						low = middle + 1;
					else
						return true;
				}
			}
		}
		return false;
	}

}
