package com.isaac.leetcodes001_100;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_089_Gray_Code {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		System.out.println(grayCode(n).toString());
	}

	public static List<Integer> grayCode(int n) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < (1 << n); i++) {
			list.add(i ^ (i >> 1));
		}
		return list;
	}
}
