package com.mgalala.algorithms.collections;

import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

public class MaxStack<T> extends Stack<T> {

	private static final long serialVersionUID = 1L;

	private SortedSet<T> tree = new TreeSet<>();

	public T max() {
		return super.peek();
	}

	public T push(T item) {
		super.push(item);
		tree.add(item);
		return item;
	}

	public T pop() {
		T item = super.pop();
		tree.remove(item);
		return item;
	}

}