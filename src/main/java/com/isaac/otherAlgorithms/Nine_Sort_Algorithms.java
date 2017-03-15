package com.isaac.otherAlgorithms;

import java.util.Arrays;

public class Nine_Sort_Algorithms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 70, 80, 31, 37, 10, 1, 48, 60, 33, 80 };
		System.out.println("Select Sort: " + Arrays.toString(selectionSort(arr)));
		System.out.println("Insertion Sort: " + Arrays.toString(insertionSort(arr)));
		System.out.println("Bubble Sort: " + Arrays.toString(bubbleSort(arr)));
		System.out.println("Heap Sort: " + Arrays.toString(heapSort(arr)));
		System.out.println("Shaker Sort: " + Arrays.toString(shakerSort(arr)));
		System.out.println("Shell Sort: " + Arrays.toString(shellSort(arr)));
		System.out.println("Quick Sort 1: " + Arrays.toString(quickSort1(arr)));
		System.out.println("Quick Sort 2: " + Arrays.toString(quickSort2(arr)));
		System.out.println("Quick Sort 3: " + Arrays.toString(quickSort3(arr)));
	}

	/**
	 * It separates the array into two parts, one is sorted and another is
	 * unsorted, every time selecting a smallest value from the latter unsorted
	 * part and then put this value at the end of the front part.
	 * For example: an unsorted array, [70, 80, 31, 37, 10, 1, 48, 60, 33, 80]
	 * 1st [1], 70, 80, 31, 37, 10, 48, 60, 33, 80 Select the smallest one: 1
	 * 2nd [1, 10], 70, 80, 31, 37, 48, 60, 33, 80 Select the smallest one: 10
	 * 3rd [1, 10, 31], 70, 80, 37, 48, 60, 33, 80 Select the smallest one: 31
	 * 4th Same as above…
	 * 5th …
	 * 6th …
	 * … …
	 * Finally
	 * [1, 10, 31, 33, 37, 48, 60, 70, 80, 80]
	 *
	 * time complexity are O(n^2).
	 */
	public static int[] selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int m = i; // let i be the position where the element to be put in and m is record the smallest one in the latter array
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[m]) // select the smallest element
					m = j;
			}
			if (m != i) { // executing the exchange process
				int tmp = arr[m];
				arr[m] = arr[i];
				arr[i] = tmp;
			}
		}
		return arr;
	}

	/**
	 * It also separates the array into two parts, and each time we pick the
	 * first value element of the latter part and insert this element into a
	 * proper position of the front array.
	 * For example: an unsorted array, [92, 77, 67, 8, 6, 84, 55, 85, 43, 67]
	 * [77, 92], 67, 8, 6, 84, 55, 85, 43, 67
	 * 77 is picked and insert into the front of 92
	 * [67, 77, 92], 8, 6, 84, 55, 85, 43, 67
	 * 67 is picked and insert into the front of 77
	 * [8, 67, 77, 92], 6, 84, 55, 85, 43, 67
	 * 8 is picked and insert into the front of 67
	 * …… ……
	 * [6, 8, 43, 55, 67, 67, 77, 84, 85, 92] finally
	 *
	 * time complexity are O(n^2).
	 */
	public static int[] insertionSort(int[] arr) {
		for (int j = 1; j < arr.length; j++) {
			int tmp = arr[j]; // record the value need to be add into the front part
			int i = j - 1; // transversal the front part to find the proper position to insert the tmp
			while (tmp < arr[i]) {
				arr[i + 1] = arr[i];
				i--;
				if (i == -1)
					break;
			}
			arr[i + 1] = tmp; // insert the tmp
		}
		return arr;
	}

	/**
	 * For this type of sort, each time the biggest element of the array will
	 * moves to the right side of the array.
	 * For example: [95, 27, 90, 49, 80, 58, 6, 9, 18, 50]
	 * 27, 90, 49, 80, 58, 6, 9, 18, 50, [95]
	 * the biggest one: 95 is moved to right side
	 * 27, 49, 80, 58, 6, 9, 18, 50, [90, 95]
	 * the biggest one: 90 is moved to right side
	 * 27, 49, 58, 6, 9, 18, 50, [80, 90, 95]
	 * the biggest one: 80 is moved to right side
	 * …… ……
	 * 6, 9, 18, [27, 49, 50, 58, 80, 90, 95] finally
	 *
	 * time complexity are O(n^2).
	 */
	public static int[] bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j + 1] < arr[j]) { // if the current element is larger than the latter, executing the exchange
					int tmp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		return arr;
	}

	/**
	 * Heap Sort -- Improved select sort
	 * 首先建立堆积树，每次取出堆积树中的最小元素，最小值的取出方式是将树根与最
	 * 后一个树叶节 点交换,然后切下树叶节点,重新调整树为堆积树
	 *
	 * time complexity are O(nlogn)
	 */
	public static int[] heapSort(int[] arr) {
		int[] arr_tmp = new int[arr.length + 1];
		for (int i = 1; i <= arr.length; i++) {
			arr_tmp[i] = arr[i - 1];
		}
		arr_tmp = createHeap(arr_tmp);
		int m = arr.length;
		while (m > 1) {
			int tmp = arr_tmp[1];
			arr_tmp[1] = arr_tmp[m];
			arr_tmp[m] = tmp;
			m--;
			int p = 1;
			int s = 2 * p;
			while (s <= m) {
				if (s < m && arr_tmp[s + 1] > arr_tmp[s])
					s++;
				if (arr_tmp[p] >= arr_tmp[s])
					break;
				tmp = arr_tmp[p];
				arr_tmp[p] = arr_tmp[s];
				arr_tmp[s] = tmp;
				p = s;
				s = 2 * p;
			}
		}
		for (int i = 1; i <= arr.length; i++) {
			arr[i - 1] = arr_tmp[i];
		}
		return arr;
	}

	//将原数组构造为从下标1开始的一个新数组，便于处理，同时将这个新数组构造为最初始的堆积树结构
	public static int[] createHeap(int[] arr) {
		int[] heap = new int[arr.length];
		for (int i = 1; i < arr.length; i++) {
			heap[i] = arr[i];
			int s = i;
			int p = s / 2;
			while (s >= 2 && heap[p] < heap[s]) {
				int tmp = heap[p];
				heap[p] = heap[s];
				heap[s] = tmp;
				s = p;
				p = s / 2;
			}
		}
		return heap;
	}

	/**
	 * Shaker Sort -- Improved bubble sort
	 * 冒泡排序的双向进行，先让气泡排序由左向右进行,再来让气泡排序由右往左进行,
	 * 如此完成一次排序的动作,而您必须使用left与right两个旗标来记录左右两端已
	 * 排序的元素位置
	 *
	 * time complexity are O(nlogn)
	 */
	public static int[] shakerSort(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		int shift = 0; // 记录双边排序的偏移量
		while (left < right) {
			for (int i = left; i < right; i++) { // 从左到右排序
				if (arr[i] > arr[i + 1]) {
					int tmp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = tmp;
				}
				shift = i;
			}
			right = shift;
			for (int i = right; i > left; i--) { // 从右到左排序
				if (arr[i] < arr[i - 1]) {
					int tmp = arr[i];
					arr[i] = arr[i - 1];
					arr[i - 1] = tmp;
				}
				shift = i;
			}
			left = shift;
		}
		return arr;
	}

	/**
	 * Shell Sort -- Improved insert sort
	 * Shell首先将间隔设定为n/2,然后跳跃进行插入排序,再来将间隔n/4,跳跃进行
	 * 排序动作,再来 间隔设定为n/8、n/16,直到间隔为1之后的最 后一次排序终止,
	 * 由于上一次的排序动作都会将 固定间隔内的元素排序好,所以当间隔越来越小时,
	 * 某些元素位于正确位置的机率越高,因此 最后几次的排序动作将 可以大幅减低。
	 */
	public static int[] shellSort(int[] arr) {
		int gap = arr.length / 2;
		while (gap > 0) {
			for (int k = 0; k < gap; k++) {
				for (int i = k + gap; i < arr.length; i += gap) {
					for (int j = i - gap; j >= k; j -= gap) {
						if (arr[j] > arr[j + gap]) {
							int tmp = arr[j];
							arr[j] = arr[j + gap];
							arr[j + gap] = tmp;
						} else {
							break;
						}
					}
				}
			}
			gap /= 2;
		}
		return arr;
	}

	/*
	 * Quick sort is one of the fastest sort algorithms. Although the time complexity of
	 * quick sort would reach O(n^2) in the worst case, its efficient performance is quiet
	 * great in most cases, O(n*log(n)).
	 * The basic idea of quick sort is finding a proper axis center in the array,
	 * and separating the array into two parts from this axis center, then sorting the left
	 * part array and right part array separately. Moreover, the choice of axis center has a
	 * critical influence on the efficiency of quick sort.
	 */

	/*
	 * The first quick sort algorithm is shown below.
	 * Recursion:
	 * 1.	Set the left-most elements as the axis, and record its value as s.
	 * 2.	Recycle process:
	 * (1) Let index i search from left to right of the array, until find out the value of an element larger than s.
	 * (2) Let index j search from right to left of the array, until find out the value of an element smaller than s.
	 * (3) If i >= j, leave the recycle.
	 * (4) If i < j, exchange the value pointed by index i and index j.
	 * 3. Exchange the left axis and j.
	 * 4. Execute the recursion process of the left part array of the axis.
	 * 5. Execute the recursion process of the right part array of the axis.
	 *
	 * For example, let * denotes the value to be exchanged, [] denotes the axis.
	 * According to this algorithm, the values in the left part of the axis will smaller than s,
	 * and the values in the right part of the axis will larger than s.
	 * [41] 24 76* 11 45 64 21 69 19 36*
	 * [41] 24 36 11 45* 64 21 69 19* 76
	 * [41] 24 36 11 19 64* 21* 69 45 76
	 * [41] 24 36 11 19 21 64 69 45 76
	 * 21 24 36 11 19 [41] 64 69 45 76
	 * In the example above, the values in the left part of 41 are smaller than 41,
	 * and in the right is larger than 41, then we can simple execute the recursion process
	 * to both left and right parts to finish the sort.
	 */
	public static int[] quickSort1(int[] arr) {
		if (arr.length > 1) {
			recursion1(arr, 0, arr.length - 1);
		}
		return arr;
	}

	public static void recursion1(int[] arr, int low, int high) {
		if (low < high) {
			int middle = getMiddle(arr, low, high);
			recursion1(arr, low, middle - 1);
			recursion1(arr, middle + 1, high);
		}
	}

	public static int getMiddle(int[] arr, int low, int high) {
		int tmp = arr[low];
		while (low < high) {
			while (low < high && arr[high] >= tmp)
				high--;
			arr[low] = arr[high];
			while (low < high && arr[low] <= tmp)
				low++;
			arr[high] = arr[low];
		}
		arr[low] = tmp;
		return low;
	}

	/*
	 * In the quick sort (1), each time we set the left-most element as the axis,
	 * and we have mentioned before that the speed up of quick sort is contributed by
	 * the choice of axis. In this algorithm, the axis is always set in the middle element,
	 * and it is used as the comparison standard, which is able to speed up the efficiency.
	 *
	 * Setting the middle element as the axis s, index i search from left to right to find the
	 * value larger than s, and index j search from right to left to find the value smaller than s,
	 * then exchange the value pointed by i and j. This process is executed until the index i is
	 * larger than j. For this case, the value of axis also joins the exchange process.
	 *
	 * For example:
	 * 41 24 76 11 45 64 21 69 19 36
	 * Firstly, set left as 0, and right as 9, (left + right) / 2 = 4, so the index of axis is 4,
	 * so the standard is 45, then finding the value larger than 45 from left and the value
	 * smaller than 45 from right.
	 * 41 24 76* 11 [45] 64 21 69 19 *36
	 * 41 24 36 11 45* 64 21 69 19* 76
	 * 41 24 36 11 19 64* 21* 69 45 76
	 * [41 24 36 11 19 21] [64 69 45 76]
	 * Then executing the recursion process for both the left part and right part.
	 *
	 */
	public static int[] quickSort2(int[] arr) {
		recursion2(arr, 0, arr.length - 1);
		return arr;
	}

	public static void recursion2(int[] arr, int left, int right) {
		if (left < right) {
			int tmp = arr[(left + right) / 2];
			int i = left - 1;
			int j = right + 1;
			while (true) {
				while (arr[++i] < tmp)
					; // 从左向右找
				while (arr[--j] > tmp)
					; // 从右向左找
				if (i >= j) {
					break;
				}
				int tmp2 = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp2;
			}
			recursion2(arr, left, i - 1);
			recursion2(arr, j + 1, right);
		}
	}

	/*
	 * In this algorithm, it uses the right-most element as the comparison standard,
	 * and separate the array into three parts, one is smaller than s, one is larger
	 * than s and the rest one is unprocessed, as shown below:
	 *         i            j
	 * ————————|————————————|————————s
	 *   <s          >s        un-process
	 * Within the sort process, i and j will process the comparison and exchange to
	 * the right side, then the array becomes:
	 * —————----———|——————-----——————|s
	 *    <s             >s
	 * Then put the s into the middle, and executing the same process to both left and right parts.
	 * —————----———s——————-----——————
	 *      <s             >s
	 */
	public static int[] quickSort3(int[] arr) {
		recursion3(arr, 0, arr.length - 1);
		return arr;
	}

	public static void recursion3(int[] arr, int left, int right) {
		if (left < right) {
			int p = partition(arr, left, right);
			recursion3(arr, left, p - 1);
			recursion3(arr, p + 1, right);
		}
	}

	public static int partition(int[] arr, int left, int right) {
		int i = left - 1;
		int tmp;
		int s = arr[right];
		for (int j = left; j < right; j++) {
			if (arr[j] <= s) {
				i++;
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		}
		tmp = arr[i + 1];
		arr[i + 1] = arr[right];
		arr[right] = tmp;
		return i + 1;
	}

}
