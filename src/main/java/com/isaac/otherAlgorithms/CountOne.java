package com.isaac.otherAlgorithms;

public class CountOne {

	public static void main(String[] args) {
		int n = 111;
		System.out.println(count(n));
	}

	public static int count(int n) {
		int count = 0;
		int factor = 1;
		while (n / factor != 0) {
			int lowNum = n % factor;
			int curNum = (n / factor) % 10;
			int highNum = n / (factor * 10);
			if (curNum == 0) {
				// 如果为0,出现1的次数由高位决定
				count += highNum * factor;
			} else if (curNum == 1) {
				// 如果为1,出现1的次数由高位和低位决定
				count += highNum * factor + lowNum + 1;
			} else {
				// 如果大于1,出现1的次数由高位决定
				count += (highNum + 1) * factor;
			}
			factor *= 10;
		}
		return count;
	}

}
