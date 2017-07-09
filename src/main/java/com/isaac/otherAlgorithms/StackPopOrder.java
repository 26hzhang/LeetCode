package com.isaac.otherAlgorithms;

import java.util.Stack;

public class StackPopOrder {

	public static void main(String[] args) {
		int[] pushArr = { 1, 2, 3, 4, 5 };
		int[] popArr1 = { 4, 5, 3, 2, 1 };
		int[] popArr2 = { 4, 3, 5, 1, 2 };
		System.out.println(popOrder(pushArr, popArr1));
		System.out.println(popOrder(pushArr, popArr2));
	}

	public static boolean popOrder(int[] pushArr, int[] popArr) {
		int length = pushArr.length;
		if (pushArr != null && popArr != null) {
			int nextPush = 0;
			int nextPop = 0;
			Stack<Integer> stack = new Stack<Integer>();
			while (nextPop < length) {
				// 若当前栈为空或当前栈顶元素不等于popArr当前指针指向值，则将新元素压入栈，知道相等或元素压完
				while (stack.isEmpty() || stack.peek() != popArr[nextPop]) {
					if (nextPush >= length)
						break;
					stack.push(pushArr[nextPush]);
					nextPush++;
				}
				if (stack.peek() != popArr[nextPop])
					break;
				stack.pop();
				nextPop++;
			}
			if (stack.isEmpty() && nextPop == length)
				return true;
		}
		return false;
	}
}
