package com.mgalala.algorithms.assignments.assignment2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author mgalala Question: A double-ended queue or deque (pronounced “deck”)
 *         is a generalization of a stack and a queue that supports adding and
 *         removing items from either the front or the back of the data
 *         structure.
 * 
 *         Performance requirements. Your deque implementation must support each
 *         deque operation (including construction) in constant worst-case time.
 *         A deque containing n items must use at most 48n + 192 bytes of memory
 *         and use space proportional to the number of items currently in the
 *         deque. Additionally, your iterator implementation must support each
 *         operation (including construction) in constant worst-case time.
 */
public class Deque<Item> implements Iterable<Item> {

	private int total;
	private Node<Item> first;
	private Node<Item> last;

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

	public void addFirst(Item item) {
		// add the Item to the front
		if (null == item) {
			throw new IllegalArgumentException();
		}

		Node<Item> oldFirst = first;
		first = new Node<Item>();
		first.setValue(item);
		first.setNext(oldFirst);
		if (isEmpty()) {
			last = first;
		} else {
			oldFirst.setPrevious(first);
		}
		total++;
	}

	public void addLast(Item item) {
		// add the Item to the end
		if (null == item) {
			throw new IllegalArgumentException();
		}

		Node<Item> oldLast = last;
		last = new Node<Item>();
		last.setValue(item);
		last.setPrevious(oldLast);
		if (isEmpty()) {
			first = last;
		} else {
			oldLast.setNext(last);
		}
		total++;
	}

	public Item removeFirst() {
		// remove and return the Item from the front
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		Item valueToRemove = first.getValue();
		first = first.getNext();
		total--;
		if (isEmpty()) {
			last = null;
		} else {
			first.setPrevious(null);
		}
		return valueToRemove;
	}

	public Item removeLast() {
		// remove and return the Item from the end
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		Item valueToRemove = last.getValue();
		last = last.getPrevious();
		total--;
		if (isEmpty()) {
			first = null;
		} else {
			last.setNext(null);
		}
		return valueToRemove;
	}

	public Iterator<Item> iterator() {
		// return an iterator over Ts in order from front to end
		return new QueueIterator<Item>(first);
	}

	private class Node<Item> {
		private Item value;
		private Node<Item> next;
		private Node<Item> previous;

		/**
		 * @return the next
		 */
		public Node<Item> getNext() {
			return next;
		}

		/**
		 * @param next
		 *            the next to set
		 */
		public void setNext(Node<Item> next) {
			this.next = next;
		}

		/**
		 * @return the previous
		 */
		public Node<Item> getPrevious() {
			return previous;
		}

		/**
		 * @param previous
		 *            the previous to set
		 */
		public void setPrevious(Node<Item> previous) {
			this.previous = previous;
		}

		/**
		 * @return the self
		 */
		public Item getValue() {
			return value;
		}

		/**
		 * @param self
		 *            the self to set
		 */
		public void setValue(Item self) {
			this.value = self;
		}
	}

	private class QueueIterator<Item> implements Iterator<Item> {

		private Node<Item> current;

		public QueueIterator(Node<Item> current) {
			this.current = current;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}

			Item valueToReturn = current.getValue();
			current = current.getNext();
			return valueToReturn;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}
}