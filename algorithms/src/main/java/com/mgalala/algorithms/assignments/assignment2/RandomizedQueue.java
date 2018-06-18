package com.mgalala.algorithms.assignments.assignment2;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

/**
 * @author mgalala Question: Randomized queue. A randomized queue is similar to
 *         a stack or queue, except that the item removed is chosen uniformly at
 *         random from items in the data structure. Create a generic data type
 *         RandomizedQueue that implements the following API:
 * 
 *         Iterator. Each iterator must return the items in uniformly random
 *         order. The order of two or more iterators to the same randomized
 *         queue must be mutually independent; each iterator must maintain its
 *         own random order.
 * 
 *         Performance requirements. Your randomized queue implementation must
 *         support each randomized queue operation (besides creating an
 *         iterator) in constant amortized time. That is, any sequence of m
 *         randomized queue operations (starting from an empty queue) must take
 *         at most cm steps in the worst case, for some constant c. A randomized
 *         queue containing n items must use at most 48n + 192 bytes of memory.
 *         Additionally, your iterator implementation must support operations
 *         next() and hasNext() in constant worst-case time; and construction in
 *         linear time; you may (and will need to) use a linear amount of extra
 *         memory per iterator.
 * 
 * 
 * 
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
	private Item[] queue;
	private int total;

	public RandomizedQueue() {
		// construct an empty randomized queue
		queue = (Item[]) new Object[1];
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

	public void enqueue(Item item) {
		// add the item
		if (item == null)
			throw new IllegalArgumentException();

		if (total == queue.length)
			resize(2 * queue.length);
		queue[total++] = item;
	}

	private void resize(int capacity) {
		Item[] copy = (Item[]) new Object[capacity];
		for (int i = 0; i < total; i++)
			copy[i] = queue[i];
		queue = copy;
	}

	public Item dequeue() {
		// remove and return a random item
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		int random = StdRandom.uniform(total);
		swap(queue, random, total - 1);
		Item item = queue[total - 1];
		queue[total - 1] = null;
		total--;
		if (total > 0 && total == queue.length / 4) {
			resize(queue.length / 2);
		}
		return item;
	}

	private void swap(Item[] input, int i, int j) {
		Item tmp = input[i];
		input[i] = input[j];
		input[j] = tmp;
	}

	public Item sample() {
		// return a random item (but do not remove it)
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		return queue[StdRandom.uniform(total)];
	}

	public Iterator<Item> iterator() {
		// return an independent iterator over items in random order
		return new RandomizedQueueIterator<>(queue, total);
	}

	private class RandomizedQueueIterator<Item> implements Iterator<Item> {

		private final Item[] current;
		private int index = 0;
		private final int total;

		public RandomizedQueueIterator(Item[] queue, int total) {
			current = (Item[]) new Object[total];
			for (int i = 0; i < total; i++) {
				this.current[i] = queue[i];
			}
			this.total = total;

			StdRandom.shuffle(current);
		}

		@Override
		public boolean hasNext() {
			return index < total;
		}

		@Override
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return current[index++];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

}
