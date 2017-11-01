package com.isaac.leetcodes001_100;

public class LeetCode_084_Largest_Rectangle_In_Histogram {
	public static void main(String[] args) {
		int[] heights = { 2, 1, 5, 6, 2, 3 };
		System.out.println(largestRectangleArea(heights));
	}

	/*public static int largestRectangleArea(int[] heights) {
	    int max = 0;
	    int length = heights.length;
	    int area = 0;
	    for (int i = 0; i < length; i++) {
	    	if (i > 0 && heights[i] <= heights[i - 1] && heights[i - 1] != 0) {
	    		area = heights[i] * (area / heights[i - 1] + 1);
	    	} else 
	    		area = heights[i];
	    	int k = i + 1;
	    	while (k < length) {
	    		if (heights[k] >= heights[i]) {
	    			area += heights[i];
	    			k++;
	    		} else
	    			break;
	    	}
	    	max = Math.max(max, area);
	    }
	    return max;
	}*/
	private static int largestRectangleArea(int[] heights) {
		int length = heights.length;
		if (heights == null || length == 0)
			return 0;
		int max = 0;
		int[] left = new int[length];
		int[] right = new int[length];
		left[0] = -1;
		right[length - 1] = length;

		for (int i = 1; i < length; i++) {
			if (heights[i] > heights[i - 1]) {
				left[i] = i - 1;
			} else {
				int p = i - 1;
				while (p >= 0 && heights[p] >= heights[i])
					p = left[p];
				left[i] = p;
			}
		}

		for (int i = length - 2; i >= 0; i--) {
			if (heights[i] > heights[i + 1]) {
				right[i] = i + 1;
			} else {
				int p = i + 1;
				while (p < length && heights[p] >= heights[i])
					p = right[p];
				right[i] = p;
			}
		}
		for (int i = 0; i < length; i++) {
			max = Math.max(max, heights[i] * (right[i] - left[i] - 1));
		}
		return max;
	}
}
