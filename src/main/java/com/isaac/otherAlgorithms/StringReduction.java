package com.isaac.otherAlgorithms;

public class StringReduction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "caccccccc";
		String str1 = "ca";
		System.out.println(str.contains(str1));
		System.out.println(reduceLength(str));
	}

	public static int reduceLength(String str) {
		if (str == null || str.isEmpty())
			return 0;

		int counta = 0;
		int countb = 0;
		int countc = 0;
		for (int i = 0; i < str.length(); i++) {
			switch (str.charAt(i)) {
			case ('a'):
				counta++;
				break;
			case ('b'):
				countb++;
				break;
			case ('c'):
				countc++;
				break;
			}
		}
		if ((counta != 0 && countb == 0 && countc == 0) || (countb != 0 && counta == 0 && countc == 0) || (countc != 0 && counta == 0 && countb == 0))
			return str.length();
		else if ((counta % 2 == 0 && countb % 2 == 0 && countc % 2 == 0) || (counta % 2 == 1 && countb % 2 == 1 && countc % 2 == 1))
			return 2;
		else
			return 1;
	}

}
