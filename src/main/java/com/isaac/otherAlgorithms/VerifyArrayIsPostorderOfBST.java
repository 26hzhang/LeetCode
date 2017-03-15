package com.isaac.otherAlgorithms;

import java.util.Arrays;

public class VerifyArrayIsPostorderOfBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 5, 7, 6, 9, 11, 10, 8 };
		System.out.println(Verify(arr));
	}

	public static boolean Verify(int[] arr) {
		if (arr == null || arr.length <= 0)
			return false;
		if (arr.length == 1)
			return true;
		int root = arr[arr.length - 1];
		int left = 0;
		while (arr[left] < root)
			left++;
		int right = left;
		while (right < arr.length - 1) {
			if (arr[right] < root)
				return false;
			right++;
		}
		boolean leftSubtree = false;
		if (left > 0)
			leftSubtree = Verify(Arrays.copyOfRange(arr, 0, left));
		boolean rightSubtree = false;
		if (left < arr.length - 1)
			rightSubtree = Verify(Arrays.copyOfRange(arr, left, arr.length - 1));
		return (rightSubtree && leftSubtree);
	}

}
