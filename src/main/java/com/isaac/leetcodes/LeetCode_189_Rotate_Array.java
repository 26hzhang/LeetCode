package com.isaac.leetcodes;

public class LeetCode_189_Rotate_Array {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "I am a Student!";
		System.out.println(rotate(str));
	}

	public static String rotate(String str) {
		char[] arr = str.toCharArray();
		int start = 0;
		int end = 0;
		while (end < arr.length) {
			if (end == arr.length - 1) {
				swap(arr, start, end);
				end++;
			} else if (arr[end] != ' ') {
				end++;
			} else {
				swap(arr, start, end - 1);
				end++;
				start = end;
			}
		}
		swap(arr, 0, arr.length - 1);
		return new StringBuilder().append(arr).toString();
	}

	public static void swap(char[] arr, int start, int end) {
		if (arr == null || arr.length == 1 || start == end)
			return;
		while (start < end) {
			char tmp = arr[start];
			arr[start] = arr[end];
			arr[end] = tmp;
			start++;
			end--;
		}
	}
}
