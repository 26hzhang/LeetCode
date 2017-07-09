package com.isaac.otherAlgorithms;

/**
 * Jeff loves playing games, Gluttonous snake (an old game in NOKIA era) is one
 * of his favourites. However, after playing gluttonous snake so many times, he
 * finally got bored with the original rules.
 * In order to bring new challenge to this old game, Jeff introduced new rules :
 * • The ground is a grid, with n rows and m columns(1 <= n, m <= 500).
 * • Each cell contains a value v (-1 ≤ vi ≤ 99999), if v is -1, then this cell
 * is blocked, and the snake can not go through, otherwise, after the snake
 * visited this cell, you can get v point.
 * • The snake can start from any cell along the left border of this ground and
 * travel until it finally stops at one cell in the right border.
 * • During this trip, the snake can only go up/down/right, and can visit each
 * cell only once.
 * Special cases :
 * • a. Even in the left border and right border, the snake can go up and down.
 * • b. When the snake is at the top cell of one column, it can still go up,
 * which demands the player to pay all current points , then the snake will be
 * teleported to the bottom cell of this column and vice versa.
 * After creating such a new game, Jeff is confused how to get the highest
 * score. Please help him to write a program to solve this problem.
 * Input
 * • The first line contains two integers n (rows) and m (columns), (1 <= n, m
 * <= 500), separated by a single space.
 * • Next n lines describe the grid. Each line contains m integers vi (-1 ≤ vi ≤
 * 99999) vi = -1 means the cell is blocked.
 * Output
 * • Output the highest score you can get. If the snake can not reach the right
 * side, output -1.
 * Limits
 * • Memory limit per test : 256 megabytes
 * • Time limit per test : The faster the better
 * Compile & Environment
 * C++
 * g++ Main.cc -o Main –fno -asm -Wall -lm --static -std=c++ 0x -DONLINE_JUDGE
 * Java
 * Java 7
 * Maximum stack size is 50m
 * Sample Test:
 * Input
 * 4 4
 * -1 4 5 1
 * 2 -1 2 4
 * 3 3 -1 3
 * 4 2 1 2
 * output
 * 23
 *
 * Input
 * 4 4
 * -1 4 5 1
 * 2 -1 2 4
 * 3 3 -1 -1
 * 4 2 1 2
 * Output
 * 16
 *
 *
 * @author ZHANG HAO
 *
 */
public class Game_WorksApp_Test {
	private static int max = 0;

	public static void main(String[] args) {
		int[][] grid = { { -1, 4, 5, 1 }, { 2, -1, 2, 4 }, { 3, 3, -1, -1 }, { 4, 2, 1, 2 } };
		int row = grid.length;
		int column = grid[0].length;
		/*Scanner in = new Scanner(System.in);
		int row = in.nextInt();
		int column = in.nextInt();
		int[][] grid = new int[row][column];
		for (int i = 0; i < row; i++)
			for (int j = 0; j < column; j++)
				grid[i][j] = in.nextInt();*/
		maxPath(grid, row, column);
		System.out.println(max);
	}

	public static void maxPath(int[][] grid, int row, int column) {
		//int max = 0;
		int[][] mark = new int[row][column];
		for (int i = 0; i < row; i++) {
			mark[i][0] = 1;
			recursion(grid, mark, i, 0, 0, row, column);
			mark[i][0] = 0;
		}
	}

	public static void recursion(int[][] grid, int[][] mark, int x, int y, int sum, int row, int column) {
		int[] dx = { -1, 0, 1 };
		int[] dy = { 0, 1, 0 };
		if (y == column - 1 && sum > max) {
			max = sum;
		}
		for (int i = 0; i < 3; i++) {
			boolean flag = false;
			int nx = x + dx[i];
			if (nx == -1) {
				nx = row - 1;
				flag = true;
			} else if (nx == row) {
				nx = 0;
				flag = true;
			}
			int ny = y + dy[i];
			if (ny == column || mark[nx][ny] == 1 || grid[nx][ny] == -1)
				continue;
			mark[nx][ny] = 1;
			if (flag)
				recursion(grid, mark, nx, ny, sum / 2 + grid[nx][ny], row, column);
			else
				recursion(grid, mark, nx, ny, sum + grid[nx][ny], row, column);
			mark[nx][ny] = 0;
		}
	}

}
