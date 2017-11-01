package com.isaac.skiinginsingapore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Name: Solving skiing in Singapore problem
 * Function: Obtaining the maximal path length and drop, and the corresponding
 * routes
 * Author: Zhang Hao
 * Email: isaac.changhau@gmail.com
 * 09, February, 2016
 */
public class SkiingInSingapore {
	private static int[][] map; // matrix data is stored here
	private static int row; // the row length of the matrix
	private static int column; // the column length of the matrix
	// store the path length of each coordinate
	private static int[][] path;
	// store the drop value of each coordinate
	private static int[][] drop;

	public static void main(String[] args) throws Exception {
		// load data from the mapData.txt and store in a matrix: map
		String fileName = "src/main/resources/SkiingInSingaporeMapData.txt";
		loadData(fileName);

		// update the path matrix and drop matrix using dfs search
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				int[] tmp = dfsForPathAndDrop(i, j);
				path[i][j] = tmp[0];
				drop[i][j] = map[i][j] - map[tmp[1]][tmp[2]];
			}
		}

		int[] maxXY = new int[2]; // record coordinate values of point with max path and drop
		int maxPath = -1; // record the maxPath
		int maxDrop = -1; // record the maxDrop

		// find the maxPath and maxDrop in the path matrix and drop matrix
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (path[i][j] > maxPath) { // if path[i][j] > maxPath, update maxPath, maxDrop
					maxPath = path[i][j];
					maxDrop = drop[i][j];
					maxXY[0] = i; // update the coordinate values of max point
					maxXY[1] = j;
				}
				if (path[i][j] == maxPath) { // if maxPath equals, compare the maxDrop
					if (drop[i][j] > maxDrop) { // if drop[i][j] > maxDrop, update maxDrop
						maxDrop = drop[i][j];
						maxXY[0] = i; // update the coordinate values of max point
						maxXY[1] = j;
					}
				}
			}
		}
		// print max path and max drop
		System.out.println("Maximal Path is: " + maxPath + "\nMaximal Drop is: " + maxDrop);

		// find the path from the maximal point to the minimal point
		List<Integer> list = dfsForPath(maxXY[0], maxXY[1]); // store x, y values in a list
		Collections.reverse(list); // reverse the list
		// print the path of the skiing down process
		System.out.println("The corresponding routes are: ");
		System.out.println("x\t y \t    Height");
		int m = 0;
		int[] XY = new int[2];
		for (int tmp : list) {
			XY[m % 2] = tmp;
			m++;
			System.out.print(tmp + "\t");
			if (m % 2 == 0)
				System.out.println("altitude: " + map[XY[0]][XY[1]]);
		}
	}

	// load data from the txt file
	public static void loadData(String fileName) throws Exception {
		File file = new File(fileName);
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String lineTxt;
		if ((lineTxt = br.readLine()) != null) {
			String[] str = lineTxt.split(" ");
			// the first integer of first line is the row number of the matrix
			row = Integer.parseInt(str[0]);
			// the second integer of first line is the column number of the matrix
			column = Integer.parseInt(str[1]);
			map = new int[row][column];
			path = new int[row][column];
			drop = new int[row][column];
		}
		int i = 0;
		// the following 1000 lines are the 1000 integers of each line of the matrix
		while ((lineTxt = br.readLine()) != null) {
			int j = 0;
			String[] str = lineTxt.split(" ");
			for (String s : str) {
				map[i][j++] = Integer.parseInt(s);
			}
			i++;
		}
		br.close();
	}

	// computing the maximal path length and its drop
	public static int[] dfsForPathAndDrop(int i, int j) {
		int[] pathAndDrop = { 0, i, j }; // first value is path length, follows by x,y values
		int[] curPathAndDrop = new int[2];
		// search from the up direction
		if (j > 0 && map[i][j] > map[i][j - 1]) {
			curPathAndDrop = dfsForPathAndDrop(i, j - 1);
			if (curPathAndDrop[0] > pathAndDrop[0]) // if the current path value is larger
				// update the path length
				pathAndDrop = Arrays.copyOf(curPathAndDrop, curPathAndDrop.length);
		}
		// search from the down direction
		if (j < (column - 1) && map[i][j] > map[i][j + 1]) {
			curPathAndDrop = dfsForPathAndDrop(i, j + 1);
			if (curPathAndDrop[0] > pathAndDrop[0])
				pathAndDrop = Arrays.copyOf(curPathAndDrop, curPathAndDrop.length);
		}
		// search from the left direction
		if (i > 0 && map[i][j] > map[i - 1][j]) {
			curPathAndDrop = dfsForPathAndDrop(i - 1, j);
			if (curPathAndDrop[0] > pathAndDrop[0])
				pathAndDrop = Arrays.copyOf(curPathAndDrop, curPathAndDrop.length);
		}
		// search from the right direction
		if (i < (row - 1) && map[i][j] > map[i + 1][j]) {
			curPathAndDrop = dfsForPathAndDrop(i + 1, j);
			if (curPathAndDrop[0] > pathAndDrop[0])
				pathAndDrop = Arrays.copyOf(curPathAndDrop, curPathAndDrop.length);
		}
		pathAndDrop[0]++; // update the path length for each recursion
		return pathAndDrop;
	}

	// record the path of the maximal path length
	public static List<Integer> dfsForPath(int x, int y) {
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> curPathList = new ArrayList<Integer>();
		// search from the up direction
		if (y > 0 && map[x][y] > map[x][y - 1]) {
			curPathList = dfsForPath(x, y - 1);
			if (curPathList.size() > list.size())
				list = curPathList;
		}
		// search from the down direction
		if (y < (column - 1) && map[x][y] > map[x][y + 1]) {
			curPathList = dfsForPath(x, y + 1);
			if (curPathList.size() > list.size())
				list = curPathList;
		}
		// search from the left direction
		if (x > 0 && map[x][y] > map[x - 1][y]) {
			curPathList = dfsForPath(x - 1, y);
			if (curPathList.size() > list.size())
				list = curPathList;
		}
		// search from the right direction
		if (x < (row - 1) && map[x][y] > map[x + 1][y]) {
			curPathList = dfsForPath(x + 1, y);
			if (curPathList.size() > list.size())
				list = curPathList;
		}
		list.add(y); // add y first, because we will reverse the list later
		list.add(x); // add x
		return list;
	}
}
