package com.isaac.leetcodes201_300;

/**
 * According to the Wikipedia's article: "The Game of Life, also known simply as
 * Life, is a cellular automaton devised by the British mathematician John
 * Horton Conway in 1970."
 *
 * Given a board with m by n cells, each cell has an initial state live (1) or
 * dead (0). Each cell interacts with its eight neighbors (horizontal, vertical,
 * diagonal) using the following four rules (taken from the above Wikipedia
 * article):
 * 1. Any live cell with fewer than two live neighbors dies, as if caused by
 * under-population.
 * 2. Any live cell with two or three live neighbors lives on to the next
 * generation.
 * 3. Any live cell with more than three live neighbors dies, as if by
 * over-population.
 * 4. Any dead cell with exactly three live neighbors becomes a live cell, as if
 * by reproduction.
 * Write a function to compute the next state (after one update) of the board
 * given its current state.
 *
 * Follow up:
 * 1. Could you solve it in-place? Remember that the board needs to be updated
 * at the same time: You cannot update some cells first and then use their
 * updated values to update other cells.
 * 2. In this question, we represent the board using a 2D array. In principle,
 * the board is infinite, which would cause problems when the active area
 * encroaches the border of the array. How would you address these problems?
 *
 * Tags: Array
 *
 * Wikipedia's link:
 * https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life
 * eight neighbors' link:
 * https://en.wikipedia.org/wiki/Moore_neighborhood
 *
 * @author ZHANG HAO
 * @Email isaac.changhau@gmail.com
 *
 *        Explain: 注意边界条件，对于此问题使用绝对边界
 *
 */
public class LeetCode_289_Game_of_Life {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void gameOfLife(int[][] board) {
		int row = board.length;
		int col = board[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				int count = 0;
				for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, row - 1); x++) {
					for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, col - 1); y++) {
						if (x != i && y != j) {
							count += (board[x][y] & 1);
						}
					}
				}
				if (count == 3 || (board[i][j] & 1) + count == 3)
					board[i][j] = board[i][j] ^ 2;
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				board[i][j] = board[i][j] >> 1;
			}
		}
	}
}
