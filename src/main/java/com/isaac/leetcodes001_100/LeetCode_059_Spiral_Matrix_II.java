package com.isaac.leetcodes001_100;

import java.util.Arrays;

public class LeetCode_059_Spiral_Matrix_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int[][] matrix = generateMatrix(n);
		for (int i = 0; i < matrix.length; i++)
			System.out.println(Arrays.toString(matrix[i]));
	}

	public static int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		if (n == 0)
			return matrix;
		int i = 0;
		int startX = 0, startY = 0, endX = n - 1, endY = n - 1;
		while (startX <= endX && startY <= endY) {
			// 上
			for (int y = startY; y <= endY; y++) {
				matrix[startX][y] = ++i;
			}
			// 右
			for (int x = startX + 1; x <= endX; x++) {
				matrix[x][endY] = ++i;
			}
			// 下
			for (int y = endY - 1; y >= startY; y--) {
				matrix[endX][y] = ++i;
			}
			// 左
			for (int x = endX - 1; x > startX; x--) {
				matrix[x][startY] = ++i;
			}
			startX++;
			startY++;
			endX--;
			endY--;
		}
		return matrix;
	}
}
