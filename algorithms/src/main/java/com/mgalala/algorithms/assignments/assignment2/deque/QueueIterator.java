/**
 * 
 */
package com.mgalala.algorithms.assignments.assignment2.deque;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author mgalala
 *
 */
public class QueueIterator<T> implements Iterator<T> {

	private Node<T> current;

	public QueueIterator(Node<T> current) {
		this.current = current;
	}

	@Override
	public boolean hasNext() {
		return current != null;
	}

	@Override
	public T next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}

		T valueToReturn = current.getValue();
		current = current.getNext();
		return valueToReturn;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
