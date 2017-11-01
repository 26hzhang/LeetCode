package com.isaac.leetcodes401_500;

public class LeetCode_463_Island_Perimeter {

	public static void main(String[] args) {
		int[][] grid = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
		System.out.println(new LeetCode_463_Island_Perimeter().islandPerimeter(grid));
	}

	private int islandPerimeter(int[][] grid) {
		int[] count = new int[1];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					dfs(grid, count, i, j);
					return count[0];
				}
			}
		}
		return count[0];
	}

	private void dfs(int[][] grid, int[] count, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
			return;
		}
		grid[i][j] = -1; // mark the traversed location
		if (j + 1 >= grid[0].length || grid[i][j + 1] == 0) // check right
			count[0] += 1;
		if (i - 1 < 0 || grid[i - 1][j] == 0) // check up
			count[0] += 1;
		if (j - 1 < 0 || grid[i][j - 1] == 0) // check left
			count[0] += 1;
		if (i + 1 >= grid.length || grid[i + 1][j] == 0) // check down
			count[0] += 1;
		dfs(grid, count, i, j + 1);
		dfs(grid, count, i - 1, j);
		dfs(grid, count, i, j - 1);
		dfs(grid, count, i + 1, j);
	}

}
