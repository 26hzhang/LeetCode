package com.isaac.otherAlgorithms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Game_WorksApp_Text_Another_Method {

	private static int row;
	private static int column;
	private static int[][] grid;
	private static int[][] mark;
	private static int maxSum = 0;
	private static int[] cx = { -1, 0, 1 };
	private static int[] cy = { 0, 1, 0 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "files/SnakeGameData2.txt";
		try {
			loadData(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*Scanner in = new Scanner(System.in);
		row = in.nextInt();
		column = in.nextInt();
		grid=new int[row][column];
		mark = new int[row][column];
		for(int i = 0; i < row; i++)
		   for(int j = 0;j < column; j++)
			   grid[i][j]=in.nextInt();*/

		for (int i = 0; i < row; i++) {
			if (grid[i][0] != -1) {
				mark[i][0] = 1;
				dfsForMaxSum(i, 0, grid[i][0]);
				//dfs(grid[i][0], i, 0);
				mark[i][0] = 0;
			}
		}
		System.out.println((maxSum == 0 ? -1 : maxSum));
	}

	public static void loadData(String fileName) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileName))));
		String lineTxt;
		if ((lineTxt = br.readLine()) != null) {
			String[] str = lineTxt.split(" ");
			// the first integer of first line is the row number of the matrix
			row = Integer.parseInt(str[0]);
			// the second integer of first line is the column number of the matrix
			column = Integer.parseInt(str[1]);
			grid = new int[row][column];
			mark = new int[row][column];
		}
		int i = 0;
		while ((lineTxt = br.readLine()) != null) {
			int j = 0;
			String[] str = lineTxt.split(" ");
			for (String s : str) {
				grid[i][j] = Integer.parseInt(s);
				j++;
			}
			i++;
		}
		br.close();
	}

	public static void dfsForMaxSum(int x, int y, int sum) {
		// only when the snake arrives the right side and current sum is larger than maxSum
		// then update the maxSum
		if (y == column - 1 && sum > maxSum)
			maxSum = sum;
		// go up to find the path
		if (x == 0 && mark[row - 1][y] != 1 && grid[row - 1][y] != -1) { // jump: top-->bottom
			mark[row - 1][y] = 1; // mark the point who has been traversed
			dfsForMaxSum(row - 1, y, sum / 2 + grid[row - 1][y]); // when jump, clear current sum
			// eliminate the mark when back, since may a better path also needs to use this point
			mark[row - 1][y] = 0;
		} else if (x != 0 && mark[x - 1][y] != 1 && grid[x - 1][y] != -1) { // go up
			mark[x - 1][y] = 1;
			dfsForMaxSum(x - 1, y, sum + grid[x - 1][y]); // recursion to find the best path
			mark[x - 1][y] = 0;
		}
		// go right to find the path
		if (y < column - 1 && mark[x][y + 1] != 1 && grid[x][y + 1] != -1) {
			mark[x][y + 1] = 1; // mark the point who has been traversed
			dfsForMaxSum(x, y + 1, sum + grid[x][y + 1]); // recursion to find the best path
			// eliminate the mark when back, since may a better path also needs to use this point
			mark[x][y + 1] = 0;
		}
		// go down to find the path
		if (x == row - 1 && mark[0][y] != 1 && grid[0][y] != -1) { // jump: bottom-->top
			mark[0][y] = 1; // mark the point who has been traversed
			dfsForMaxSum(0, y, sum / 2 + grid[0][y]); // when jump, clear current sum
			// eliminate the mark when back, since may a better path also needs to use this point
			mark[0][y] = 0;
		} else if (x != row - 1 && mark[x + 1][y] != 1 && grid[x + 1][y] != -1) { // go down
			mark[x + 1][y] = 1;
			dfsForMaxSum(x + 1, y, sum + grid[x + 1][y]); // recursion to find the best path
			mark[x + 1][y] = 0;
		}
	}

	public static void dfs(int sum, int x, int y) {
		if (y == column - 1 && sum > maxSum)
			maxSum = sum;
		for (int i = 0; i < 3; i++) {
			boolean flag = false;
			int nx = x + cx[i];
			if (nx == -1) {
				nx = row - 1;
				flag = true;
			}
			if (nx == row) {
				nx = 0;
				flag = true;
			}
			int ny = y + cy[i];
			if (ny == column)
				continue;
			if (mark[nx][ny] == 1 || grid[nx][ny] == -1)
				continue;
			mark[nx][ny] = 1;
			if (flag)
				dfs(sum / 2 + grid[nx][ny], nx, ny);
			else
				dfs(sum + grid[nx][ny], nx, ny);
			mark[nx][ny] = 0;
		}
	}

}
