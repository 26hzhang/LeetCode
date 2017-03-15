package com.isaac.otherAlgorithms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Travel_Info_Centre_WorksApp_Test {
	//private static int cityNum;
	//private static int inquiryNum;
	private static int[][] cityMap;
	private static int[][] inquiries;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("TravelInfoData.txt"))));
		/*Scanner in = new Scanner(System.in);
		cityNum = in.nextInt();
		inquiryNum = in.nextInt();
		cityMap = new int[cityNum][cityNum];
		inquiries = new int[inquiryNum][2];
		//System.out.println(cityMap.length);
		//System.out.println(inquiries.length);
		for (int i = 0; i < cityNum - 1; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			cityMap[x - 1][y - 1] = 1;
			cityMap[y - 1][x - 1] = 1;
		}
		for (int i = 0; i < inquiryNum; i++) {
			inquiries[i][0] = in.nextInt();
			inquiries[i][1] = in.nextInt();
		}*/

		int festiveCity = 1;
		// 利用图论算法构建最短路径图
		findShortestMap(cityMap);
		// 输出结果
		for (int k = 0; k < inquiries.length; k++) {
			if (inquiries[k][0] == 1) {
				festiveCity = inquiries[k][1];
			} else {
				System.out.println(cityMap[inquiries[k][1] - 1][festiveCity - 1]);
			}
		}
		br.close();
	}

	// Floyd algorithm
	public static void findShortestMap(int[][] cityMap) {
		for (int i = 0; i < cityMap.length; i++)
			for (int j = 0; j < cityMap[i].length; j++)
				if (cityMap[i][j] == 0 && i != j)
					cityMap[i][j] = 999999;
		for (int k = 0; k < cityMap.length; k++) {
			for (int i = 0; i < cityMap.length; i++) {
				for (int j = 0; j < cityMap[i].length; j++) {
					if (cityMap[i][j] > (cityMap[i][k] + cityMap[k][j])) {
						cityMap[i][j] = cityMap[i][k] + cityMap[k][j];
					}
				}
			}
		}

	}

}
