package com.isaac.leetcodes;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an Iterator class interface with methods: next() and hasNext(), design
 * and implement a PeekingIterator that support the peek() operation -- it
 * essentially peek() at the element that will be returned by the next call to
 * next().
 * Here is an example. Assume that the iterator is initialized to the beginning
 * of the list: [1, 2, 3].
 * Call next() gets you 1, the first element in the list.
 * Now you call peek() and it returns 2, the next element. Calling next() after
 * that still return 2.
 * You call next() the final time and it returns 3, the last element. Calling
 * hasNext() after that should return false.
 *
 * Hint:
 * • Think of "looking ahead". You want to cache the next element.
 * • Is one variable sufficient? Why or why not?
 * • Test your design with call order of peek() before next() vs next() before
 * peek().
 * For a clean implementation, check out:
 * https://github.com/google/guava/blob/703ef758b8621cfbab16814f01ddcc5324bdea33/guava-gwt/src-super/com/google/common/collect/super/com/google/common/collect/Iterators.java#L1125
 *
 * Tags: Design.
 *
 * @author ZHANG HAO
 * @Email isaac.changhau@gmail.com
 *
 *        Explain: 利用queue保存iterator指向的数据，queue中包含peek()，poll()，offer()等方法。
 */
public class LeetCode_284_Peeking_Iterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class PeekingIterator implements Iterator<Integer> {

	Queue<Integer> queue = new LinkedList<Integer>();

	public PeekingIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		while (iterator.hasNext()) {
			queue.offer((Integer) iterator.next());
		}
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {

		return queue.peek();
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return !queue.isEmpty();
	}

	public Integer next() {
		// TODO Auto-generated method stub
		return queue.poll();
	}

}
