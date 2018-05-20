/**
 * 
 */
package com.mgalala.algorithms.unionfind;

/**
 * @author mgalala
 *
 */
public class QuickFind {

	private int[] id;

	public QuickFind(int total) {
		id = new int[total];
		for (int i = 0; i < total; i++) {
			id[i] = i;
		}
	}

	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}

	public void union(int p, int q) {
		int pId = id[p];
		int qId = id[q];
		for (int i = 0; i < id.length; i++) {
			if (id[i] == pId) {
				id[i] = qId;
			}
		}
	}

	public int[] getId() {
		return id;
	}
}
