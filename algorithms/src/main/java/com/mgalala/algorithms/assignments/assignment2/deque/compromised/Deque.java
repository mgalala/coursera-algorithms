package com.mgalala.algorithms.assignments.assignment2.deque.compromised;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author mgalala
 *
 */
public class Deque<T> implements Iterable<T> {

	private int total;
	private Node<T> first;
	private Node<T> last;

	public Deque() {
		// construct an empty deque
		first = null;
		last = null;
		total = 0;
	}

	public boolean isEmpty() {
		// is the deque empty?
		return total == 0;
	}

	public int size() {
		// return the number of Ts on the deque
		return total;
	}

	public void addFirst(T item) {
		// add the T to the front
		if (null == item) {
			throw new IllegalArgumentException();
		}

		Node<T> oldFirst = first;
		first = new Node<T>();
		first.setValue(item);
		first.setNext(oldFirst);
		if (isEmpty()) {
			last = first;
		} else {
			oldFirst.setPrevious(first);
		}
		total++;
	}

	public void addLast(T item) {
		// add the T to the end
		if (null == item) {
			throw new IllegalArgumentException();
		}

		Node<T> oldLast = last;
		last = new Node<T>();
		last.setValue(item);
		last.setPrevious(oldLast);
		if (isEmpty()) {
			first = last;
		} else {
			oldLast.setNext(last);
		}
		total++;
	}

	public T removeFirst() {
		// remove and return the T from the front
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		T valueToRemove = first.getValue();
		first = first.getNext();
		total--;
		if (isEmpty()) {
			last = null;
		} else {
			first.setPrevious(null);
		}
		return valueToRemove;
	}

	public T removeLast() {
		// remove and return the T from the end
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		T valueToRemove = last.getValue();
		last = last.getPrevious();
		total--;
		if (isEmpty()) {
			first = null;
		} else {
			last.setNext(null);
		}
		return valueToRemove;
	}

	public Iterator<T> iterator() {
		// return an iterator over Ts in order from front to end
		return new QueueIterator<T>(first);
	}

	private class Node<T> {
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

	private class QueueIterator<T> implements Iterator<T> {

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
}