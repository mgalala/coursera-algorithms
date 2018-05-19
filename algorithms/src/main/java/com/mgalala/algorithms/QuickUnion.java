/**
 * 
 */
package com.mgalala.algorithms;

/**
 * @author mgalala
 *
 */
public class QuickUnion {
	private int[] id;

	public QuickUnion(int total) {
		id = new int[total];
		for (int i = 0; i < total; i++) {
			getId()[i] = i;
		}
	}

	public boolean connected(int p, int q) {
		return rootOf(p) == rootOf(q);
	}

	public void union(int p, int q) {
		int rootOfP = rootOf(p);
		int rootOfQ = rootOf(q);
		getId()[rootOfP] = rootOfQ;
	}

	private int rootOf(int i) {
		while (i != getId()[i]) {
			i = getId()[i];
		}
		return i;
	}

	public int[] getId() {
		return id;
	}

}
