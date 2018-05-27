package com.mgalala.algorithms.assignments.assignment2.deque;

public class Node<T> {
	private T value;
	private Node<T> next;
	private Node<T> previous;

	/**
	 * @return the next
	 */
	public Node<T> getNext() {
		return next;
	}

	/**
	 * @param next
	 *            the next to set
	 */
	public void setNext(Node<T> next) {
		this.next = next;
	}

	/**
	 * @return the previous
	 */
	public Node<T> getPrevious() {
		return previous;
	}

	/**
	 * @param previous
	 *            the previous to set
	 */
	public void setPrevious(Node<T> previous) {
		this.previous = previous;
	}

	/**
	 * @return the self
	 */
	public T getValue() {
		return value;
	}

	/**
	 * @param self
	 *            the self to set
	 */
	public void setValue(T self) {
		this.value = self;
	}
}
