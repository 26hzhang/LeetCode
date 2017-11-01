package com.isaac.leetcodes201_300;

import java.util.Stack;

/**
 * Implement the following operations of a queue using stacks.
 * • push(x) -- Push element x to the back of queue.
 * • pop() -- Removes the element from in front of queue.
 * • peek() -- Get the front element.
 * • empty() -- Return whether the queue is empty.
 *
 * Notes:
 * • You must use only standard operations of a stack -- which means only push
 * to top, peek/pop from top, size, and is empty operations are valid.
 * • Depending on your language, stack may not be supported natively. You may
 * simulate a stack by using a list or deque (double-ended queue), as long as
 * you use only standard operations of a stack.
 * • You may assume that all operations are valid (for example, no pop or peek
 * operations will be called on an empty queue).
 *
 * Tags: Stack, Design
 *
 * @author ZHANG HAO
 *
 *         Explain:
 *         栈是FILO，队列为FIFO，因此使用栈来实现队列需要注意这种区别。基本实现方法是构建两个栈，
 *         一个栈stack用来保存数据，一个栈temp用于辅助数据插入。当有新数据需要入栈(push)时，
 *         将栈stack中原有数据全部弹出入栈到temp中，然后将新数据插入stack中，再将temp中保存的数据弹出放回到
 *         stack中。这样stack中最上层的数据始终为最先插入的数据，因此pop和peek操作只需要返回stack中最上层的数据。
 *
 */
public class LeetCode_232_Implement_Queue_using_Stacks {

	public static void main(String[] args) {

	}

	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> temp = new Stack<Integer>();

	// Push element x to the back of queue.
	public void push(int x) {
		if (stack.isEmpty()) {
			stack.push(x);
		} else {
			while (!stack.isEmpty()) {
				temp.push(stack.pop());
			}
			stack.push(x);
			while (!temp.isEmpty()) {
				stack.push(temp.pop());
			}
		}
	}

	// Removes the element from in front of queue.
	public void pop() {
		stack.pop();
	}

	// Get the front element.
	public int peek() {
		return stack.peek();
	}

	// Return whether the queue is empty.
	public boolean empty() {
		return stack.isEmpty();
	}

}
