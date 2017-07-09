package com.isaac.otherAlgorithms;

import java.util.LinkedList;
import java.util.Queue;

public class RightPointerForEachNode {
	// it is a test of BitTitan, similar to populate next right pointers in each node
	public static void main(String[] args) {

	}

	public static void connectRight(Node root) {
		if (root == null)
			return;
		Queue<Node> queue = new LinkedList<Node>();
		int cDepthLength = 1;
		int nDepthLength = 0;
		queue.offer(root);
		while (!queue.isEmpty()) {
			Node node = queue.poll(); // return the node in the head and delete it from the queue
			for (int i = 0; i < node.Children.length; i++) { // add its children in the queue
				queue.offer(node.Children[i]);
				nDepthLength++;
			}
			if (cDepthLength > 1) {
				node.Right = queue.peek(); // return the next node in the same level, but not delete
				--cDepthLength; // current number of node in this level reduce 1
			} else { // if the nodes of this level is empty, turning to search the next level
				cDepthLength = nDepthLength;
				nDepthLength = 0;
			}
		}
	}
}

class Node {
	public Node[] Children;
	public Node Right;
}