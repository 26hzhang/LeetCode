package com.isaac.leetcodes;

public class LeetCode_074_Search_a_2D_Matrix {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		int target = 3;
		System.out.println(searchMatrix(matrix, target));
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		for (int i = 0; i < matrix.length; i++) {
			if (target >= matrix[i][0]) {
				if ((i < matrix.length - 1 && target < matrix[i + 1][0]) || i == matrix.length - 1) {
					// 二分法查找
					int low = 0, high = matrix[i].length - 1, middle;
					while (low <= high) {
						middle = (low + high) / 2;
						if (matrix[i][middle] > target) {
							high = middle - 1;
						} else if (matrix[i][middle] < target) {
							low = middle + 1;
						} else {
							return true;
						}
					}
					break;
				}
			}
		}
		return false;
	}
}
