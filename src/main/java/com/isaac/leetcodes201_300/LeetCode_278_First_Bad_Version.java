package com.isaac.leetcodes201_300;

/**
 * You are a product manager and currently leading a team to develop a new
 * product. Unfortunately, the latest version of your product fails the quality
 * check. Since each version is developed based on the previous version, all the
 * versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first
 * bad one, which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which will return whether
 * version is bad. Implement a function to find the first bad version. You
 * should minimize the number of calls to the API.
 *
 * Tags: Binary Search.
 *
 * @author ZHANG HAO
 *
 */
public class LeetCode_278_First_Bad_Version {

	public static void main(String[] args) {

	}

	/* The isBadVersion API is defined in the parent class VersionControl.*/
	// assume to be this, drop this function while submit to leetcode
	boolean isBadVersion(int version) {
		return false;
	}

	public int firstBadVersion(int n) {
		int low = 1, high = n;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			boolean curState = isBadVersion(mid);
			if (mid > 1 && isBadVersion(mid - 1))
				high = mid - 1;
			else if (curState)
				return mid;
			else
				low = mid + 1;
		}
		return -1;
	}

}
