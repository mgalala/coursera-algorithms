/**
 * 
 */
package com.mgalala.algorithms.balancedsearchtree;

import edu.princeton.cs.algs4.RedBlackBST;

/**
 * @author mgalala Generalized queue. Design a generalized queue data type that
 *         supports all of the following operations in logarithmic time (or
 *         better) in the worst case.
 * 
 *         Create an empty data structure. Append an item to the end of the
 *         queue. Remove an item from the front of the queue. Return the ith
 *         item in the queue. Remove the ith item from the queue.
 */
public class GeneralizedQueue<Node> {
	private int index;
	private RedBlackBST<Integer, Node> data;

	public void create() {
		data = new RedBlackBST<Integer, Node>();
	}

	public void append(Node item) {
		data.put(index++, item);
	}

	public void removeFromFront() {
		data.deleteMin();
	}

	public Node get(int i) {
		int key = data.rank(i);
		return data.get(key);
	}

	public void delete(int i) {
		data.delete(data.rank(i));
	}
}
