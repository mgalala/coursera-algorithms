/**
 * 
 */
package com.mgalala.algorithms.assignments.assignment2.randomizedqueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.introcs.StdRandom;

/**
 * @author mgalala
 *
 */
@SuppressWarnings("unchecked")
public class RandomizedQueue<T> implements Iterable<T> {
	private T[] queue;
	private int total;

	public RandomizedQueue() {
		// construct an empty randomized queue
		queue = (T[]) new Object[1];
		total = 0;
	}

	public boolean isEmpty() {
		// is the randomized queue empty?
		return total == 0;
	}

	public int size() {
		// return the number of items on the randomized queue
		return total;
	}

	public void enqueue(T item) {
		// add the item
		if (item == null)
			throw new IllegalArgumentException();

		if (total == queue.length)
			resize(2 * queue.length);
		queue[total++] = item;
	}

	private void resize(int capacity) {
		T[] copy = (T[]) new Object[capacity];
		for (int i = 0; i < total; i++)
			copy[i] = queue[i];
		queue = copy;
	}

	public T dequeue() {
		// remove and return a random item
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		int random = StdRandom.uniform(total);
		swap(queue, random, total - 1);
		T item = queue[total - 1];
		queue[total - 1] = null;
		total--;
		if (total > 0 && total == queue.length / 4) {
			resize(queue.length / 2);
		}
		return item;
	}

	private void swap(T[] input, int i, int j) {
		T tmp = input[i];
		input[i] = input[j];
		input[j] = tmp;
	}

	public T sample() {
		// return a random item (but do not remove it)
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return queue[StdRandom.uniform(total)];
	}

	public Iterator<T> iterator() {
		// return an independent iterator over items in random order
		return new RandomizedQueueIterator<>(queue, total);
	}

	private class RandomizedQueueIterator<T> implements Iterator<T> {

		private T[] current;
		private int i = 0;
		private int total;

		public RandomizedQueueIterator(T[] queue, int total) {
			current = (T[]) new Object[total];
			for (int i = 0; i < total; i++) {
				this.current[i] = queue[i];
			}
			this.total = total;

			StdRandom.shuffle(current);
		}

		@Override
		public boolean hasNext() {
			return i < total;
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return current[++i];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

}
