package com.isaac.leetcodes301_400;

import java.util.Arrays;

/**
 * Question:
 * Given an integer matrix, find the length of the longest increasing path.
 * From each cell, you can either move to four directions: left, right, up or
 * down. You may NOT move diagonally or move outside of the boundary (i.e.
 * wrap-around is not allowed).
 *
 * Example 1:
 * nums = [
 * [9,9,4],
 * [6,6,8],
 * [2,1,1]
 * ]
 * Return 4
 * The longest increasing path is [1, 2, 6, 9].
 *
 * Example 2:
 * nums = [
 * [3,4,5],
 * [3,2,6],
 * [2,2,1]
 * ]
 * Return 4
 * The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not
 * allowed.
 *
 * @author ZHANG HAO
 * @Email isaac.changhau@gmail.com
 *
 *        Depth-first-Search, Topological Sort, Memorization, similar to Skiing
 *        in Singapore
 *
 */
public class LeetCode_329_Longest_Increasing_Path_in_a_Matrix {
	private static int[][] matrix = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };
	private static int row = matrix.length;
	private static int column = matrix[0].length;
	private static int[][] mark = new int[row][column];
	private static int[][] path = new int[row][column];
	private static int[][] drop = new int[row][column];

	private static int[][] map = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };
	private static int maxPath = -1;
	private static int curPath = -1;

	public static void main(String[] args) {

		System.out.println(longestIncreasingPath(matrix));
		System.out.println(Integer.MIN_VALUE);
		//for (int i = 0; i < row; i++) {
		//	System.out.println(Arrays.toString(path[i]));
		//}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				int[] tt = dfsForPath(i, j);
				curPath = tt[0];
				path[i][j] = tt[0];
				drop[i][j] = map[i][j] - map[tt[1]][tt[2]];
				if (curPath > maxPath) {
					maxPath = curPath;
				}
			}
		}
		System.out.println(maxPath);
		for (int i = 0; i < row; i++) {
			System.out.println(Arrays.toString(path[i]));
		}
		for (int i = 0; i < row; i++) {
			System.out.println(Arrays.toString(drop[i]));
		}
	}

	private static int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length < 1 || matrix[0].length < 1)
			return 0;
		int ans = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				int tmp = dfs(matrix, Integer.MIN_VALUE, i, j, row, column, mark);
				ans = Math.max(ans, tmp);
				path[i][j] = ans;
			}
		}
		return ans;
	}

	private static int dfs(int[][] matrix, int min, int i, int j, int row, int column, int[][] mark) {
		if (i < 0 || j < 0 || i >= row || j >= column)
			return 0;
		if (matrix[i][j] <= min)
			return 0;
		if (mark[i][j] != 0)
			return mark[i][j];
		min = matrix[i][j];
		int a = dfs(matrix, min, i - 1, j, row, column, mark) + 1;
		int b = dfs(matrix, min, i + 1, j, row, column, mark) + 1;
		int c = dfs(matrix, min, i, j - 1, row, column, mark) + 1;
		int d = dfs(matrix, min, i, j + 1, row, column, mark) + 1;
		int max = Math.max(a, Math.max(b, Math.max(c, d)));
		mark[i][j] = max;
		return max;
	}

	private static int[] dfsForPath(int x, int y) {
		// if the value of map[x][y] less than maxPath,
		// it means that its maxPath also less than the current maxPath,
		// so do not search this point
		//if (map[x][y] < maxPath)
		//	return 0;
		// int path = 0;
		int[] pathAndDrop = { 0, x, y };
		if (y > 0 && map[x][y] > map[x][y - 1]) { // up
			int[] tmp = dfsForPath(x, y - 1);
			if (tmp[0] > pathAndDrop[0])
				pathAndDrop = Arrays.copyOf(tmp, tmp.length);
		}
		if (y < (column - 1) && map[x][y] > map[x][y + 1]) { // down
			int[] tmp = dfsForPath(x, y + 1);
			if (tmp[0] > pathAndDrop[0])
				pathAndDrop = Arrays.copyOf(tmp, tmp.length);
		}
		if (x > 0 && map[x][y] > map[x - 1][y]) { // left
			int[] tmp = dfsForPath(x - 1, y);
			if (tmp[0] > pathAndDrop[0])
				pathAndDrop = Arrays.copyOf(tmp, tmp.length);
		}
		if (x < (row - 1) && map[x][y] > map[x + 1][y]) { // right
			int[] tmp = dfsForPath(x + 1, y);
			if (tmp[0] > pathAndDrop[0])
				pathAndDrop = Arrays.copyOf(tmp, tmp.length);
		}
		pathAndDrop[0]++;
		return pathAndDrop;
	}
}
