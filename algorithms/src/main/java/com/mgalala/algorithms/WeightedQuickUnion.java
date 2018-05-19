/**
 * 
 */
package com.mgalala.algorithms;

/**
 * @author mgalala
 *
 */
public class WeightedQuickUnion {
	private int[] id;
	private int[] size;

	public WeightedQuickUnion(int total) {
		id = new int[total];
		size = new int[total];

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
	}

	private int rootOf(int i) {
		while (i != id[i]) {
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

}
