package com.isaac.leetcodes1_100;

/**
 * Question:
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container.
 *
 * Tags: Array, Two Pointers.
 *
 * @author ZHANG HAO
 * @Email isaac.changhau@gmail.com
 *
 *        Explain:
 *        大致题意为随意找2个木板构成木桶，容量最大，我之前以为是所有的木板已经在它的位置上了，
 *        然后找其中容量最大的——你加的水是可以漫过中间比较短的板子的。初始化max＝0，使用两个指针
 *        来限定两个木板的位置，初始状态下，left在0位置，right在length-1位置。当前的
 *        max=Math.max(max, Math.min(height[left], height[right]) * (right
 *        -left))，
 *        然后移动左右木板高度更短的那个木板，继续上一次的计算，直到left和right相交。
 *
 */
public class LeetCode_011_Container_with_Most_Water {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxArea(int[] height) {
		if (height == null || height.length <= 1)
			return 0;
		int max = 0;
		int left = 0;
		int right = height.length - 1;
		while (left <= right) {
			max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
			if (height[left] <= height[right]) {
				left++;
			} else
				right--;
		}
		return max;
	}

}
