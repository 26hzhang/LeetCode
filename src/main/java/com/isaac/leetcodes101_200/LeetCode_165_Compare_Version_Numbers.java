package com.isaac.leetcodes101_200;

/**
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise
 * return 0.
 *
 * You may assume that the version strings are non-empty and contain only digits
 * and the . character.
 * The . character does not represent a decimal point and is used to separate
 * number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it
 * is the fifth second-level revision of the second first-level revision.
 *
 * Here is an example of version numbers ordering:
 * 0.1 < 1.1 < 1.2 < 13.37
 *
 * Tags: String
 *
 * @author ZHANG HAO
 *
 */
public class LeetCode_165_Compare_Version_Numbers {

	public static void main(String[] args) {

	}

	public static int compareVersion(String version1, String version2) {
		if (version1.equals(version2))
			return 0;
		String[] v1 = version1.split("\\."), v2 = version2.split("\\.");
		int l1 = v1.length;
		int l2 = v2.length;
		int d = l1 - l2;
		while (d > 0) {
			version2 += ".0";
			d--;
		}
		while (d < 0) {
			version1 += ".0";
			d++;
		}
		v1 = version1.split("\\.");
		v2 = version2.split("\\.");
		int len = v1.length;
		for (int i = 0; i < len; i++) {
			if (Integer.valueOf(v1[i]) < Integer.valueOf(v2[i]))
				return -1;
			else if (Integer.valueOf(v1[i]) > Integer.valueOf(v2[i]))
				return 1;
			else
				continue;
		}
		return 0;
	}

}
