package com.isaac.leetcodes1_100;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_054_Spiral_Matrix {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		//int[][] matrix = {{2,3}};
		List<Integer> list = spiralOrder(matrix);
		System.out.println(list.toString());
	}

	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return list;
		int startX = 0, startY = 0;
		int endX = matrix.length - 1, endY = matrix[0].length - 1;
		int direction = 0;
		while (startX <= endX && startY <= endY) {
			// 上
			if (direction == 0) {
				for (int y = startY; y <= endY; y++) {
					list.add(matrix[startX][y]);
				}
				startX++;
			}
			// 右
			if (direction == 1) {
				for (int x = startX; x <= endX; x++) {
					list.add(matrix[x][endY]);
				}
				endY--;
			}
			// 下
			if (direction == 2) {
				for (int y = endY; y >= startY; y--) {
					list.add(matrix[endX][y]);
				}
				endX--;
			}
			// 左
			if (direction == 3) {
				for (int x = endX; x >= startX; x--) {
					list.add(matrix[x][startY]);
				}
				startY++;
			}
			direction = (direction + 1) % 4;
		}
		return list;
	}
}
