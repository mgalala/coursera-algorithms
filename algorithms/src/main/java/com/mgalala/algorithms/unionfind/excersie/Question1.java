/**
 * 
 */
package com.mgalala.algorithms.unionfind.excersie;

/**
 * @author mgalala Social network connectivity. Given a social network
 *         containing nn members and a log file containing mm timestamps at
 *         which times pairs of members formed friendships, design an algorithm
 *         to determine the earliest time at which all members are connected
 *         (i.e., every member is a friend of a friend of a friend ... of a
 *         friend). Assume that the log file is sorted by timestamp and that
 *         friendship is an equivalence relation. The running time of your
 *         algorithm should be m \log nmlogn or better and use extra space
 *         proportional to nn.
 * 
 *         Note: these interview questions are ungraded and purely for your own
 *         enrichment. To get a hint, submit a solution.
 */
public class Question1 {
	private int[] id;
	private int[] size;

	private int totalConnectedComponents;

	public Question1(int total) {
		id = new int[total];
		size = new int[total];
		totalConnectedComponents = 1;// we begin with 1 because once 2 items are
										// connected then, this will be
										// incremented.
		for (int i = 0; i < total; i++) {
			id[i] = i;
			size[i] = 1;
		}
	}

	public boolean connected(int p, int q) {
		return rootOf(p) == rootOf(q);
	}

	public void union(int p, int q) {
		int rootOfP = rootOf(p);
		int rootOfQ = rootOf(q);
		if (rootOfP == rootOfQ) {
			return;
		}

		if (size[rootOfP] < size[rootOfQ]) {
			// p is the lower tree, then move p to be under q and increase the
			// size of q tree.
			id[rootOfP] = rootOfQ;
			// size[rootOfQ] = size[rootOfQ] + size[rootOfP];
			size[rootOfQ] += size[rootOfP];
		} else {
			// p is the bigger tree, then move q to be under p and increase the
			// size of p tree.
			id[rootOfQ] = rootOfP;
			// size[rootOfP] = size[rootOfQ] + size[rootOfP];
			size[rootOfP] += size[rootOfQ];
		}
		++totalConnectedComponents;
	}

	private int rootOf(int i) {
		while (i != id[i]) {
			id[i] = id[id[i]];
			i = id[i];
		}
		return i;
	}

	public int[] getId() {
		return id;
	}

	public int[] getSize() {
		return size;
	}

	public int getCount() {
		return totalConnectedComponents;
	}

}
