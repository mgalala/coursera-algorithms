package com.mgalala.algorithms.assignments.assignment2;

import java.util.NoSuchElementException;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * 
 * @author mgalala Client. Write a client program Permutation.java that takes an
 *         integer k as a command-line argument; reads in a sequence of strings
 *         from standard input using StdIn.readString(); and prints exactly k of
 *         them, uniformly at random. Print each item from the sequence at most
 *         once.
 * 
 *         Performance requirements. The running time of Permutation must be
 *         linear in the size of the input. You may use only a constant amount
 *         of memory plus either one Deque or RandomizedQueue object of maximum
 *         size at most n. (For an extra challenge, use only one Deque or
 *         RandomizedQueue object of maximum size at most k.)
 */
public class Permutation {
	public static void main(String[] args) {
		int total = Integer.parseInt(args[0]);
		RandomizedQueue<String> queue = new RandomizedQueue<String>();
		try {
			String values = StdIn.readString();
			while (values != null) {
				queue.enqueue(values);
				values = StdIn.readString();
			}
		} catch (NoSuchElementException e) {
		}
		while (total > 0) {
			total--;
			StdOut.println(queue.dequeue());
		}

	}
}