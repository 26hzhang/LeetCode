package com.isaac.leetcodes101_200;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_155_Min_Stack {

	class MinStack {
		List<Integer> list = new ArrayList<Integer>();

		public void push(int x) {
			list.add(x);
		}

		public void pop() {
			list.remove(list.size() - 1);
		}

		public int top() {
			return list.get(list.size() - 1);
		}

		public int getMin() {
			int min = Integer.MAX_VALUE;
			for (int i : list) {
				min = Math.min(min, i);
			}
			return min;
		}
	}

}