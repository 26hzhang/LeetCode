package com.isaac.leetcodes201_300;

/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 *
 * Each rectangle is defined by its bottom left corner and top right corner as
 * shown in the figure. (See website)
 *
 * Assume that the total area is never beyond the maximum possible value of int.
 *
 * Tags: Math.
 *
 * @author ZHANG HAO
 *
 *         Explain:
 *         先不考虑特殊情况，计算两个矩形的面积之和。考虑可能出现重复的可能性，
 *         点C和G之间更小的值大于点A和E之间的更大值且点D和H之间的更小值大于点B和F之间的更大值时，
 *         说明两者肯定相交，相应的计算相交区域就好了。
 *
 *
 */
public class LeetCode_223_Rectangle_Area {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int area = 0;
		//先不考虑重合问题，直接求两个矩形的面积
		area = (C - A) * (D - B) + (G - E) * (H - F);
		if (Math.min(C, G) > Math.max(A, E) && Math.min(D, H) > Math.max(B, F))
			area = area - (Math.min(C, G) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F));
		return area;
	}

	//注意特殊情况：
	int A = -1500000001;
	int B = 0;
	int C = -1500000000;
	int D = 1;
	int E = 1500000000;
	int F = 0;
	int G = 1500000001;
	int H = 1;

}
