package com.isaac.leetcodes201_300;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement the following operations of a stack using queues.
 * • push(x) -- Push element x onto stack.
 * • pop() -- Removes the element on top of the stack.
 * • top() -- Get the top element.
 * • empty() -- Return whether the stack is empty.
 *
 * Notes:
 * • You must use only standard operations of a queue -- which means only push
 * to back, peek/pop from front, size, and is empty operations are valid.
 * • Depending on your language, queue may not be supported natively. You may
 * simulate a queue by using a list or deque (double-ended queue), as long as
 * you use only standard operations of a queue.
 * • You may assume that all operations are valid (for example, no pop or top
 * operations will be called on an empty stack).
 *
 * Tags: Stack, Design
 *
 * @author ZHANG HAO
 *
 *         Explain:
 *         栈是FILO，队列为FIFO，因此使用队列来实现栈需要注意这种区别。基本实现方法是构建两个队列，
 *         一个队列queue用来保存数据，一个队列temp用于辅助数据插入。当有新数据需要入栈(push)时，
 *         将栈queue中原有数据全部弹出入栈到temp中，然后将新数据插入queue中，再将temp中保存的数据弹出放回到
 *         queue中。这样queue中最前面的数据始终为最后插入的数据，因此pop和top操作只需要返回queue中最前面的数据。
 *
 */
public class LeetCode_225_Implement_Stack_using_Queues {

	public static void main(String[] args) {

	}

	Queue<Integer> queue = new LinkedList<Integer>();
	Queue<Integer> temp = new LinkedList<Integer>();

	// Push element x onto stack.
	public void push(int x) {
		if (queue.isEmpty()) {
			queue.offer(x);
		} else {
			while (!queue.isEmpty()) {
				temp.offer(queue.poll());
			}
			queue.offer(x);
			while (!temp.isEmpty()) {
				queue.offer(temp.poll());
			}
		}
	}

	// Removes the element on top of the stack.
	public void pop() {
		queue.poll();
	}

	// Get the top element.
	public int top() {
		return queue.peek();
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return queue.isEmpty();
	}

}
