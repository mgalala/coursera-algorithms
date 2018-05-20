/**
 * 
 */
package com.mgalala.algorithms.unionfind.excersie;

/**
 * @author mgalala Union-find with specific canonical element. Add a method
 *         \mathtt{find()}find() to the union-find data type so that
 *         \mathtt{find(i)}find(i) returns the largest element in the connected
 *         component containing ii. The operations, \mathtt{union()}union(),
 *         \mathtt{connected()}connected(), and \mathtt{find()}find() should all
 *         take logarithmic time or better.
 * 
 *         For example, if one of the connected components is {1,2,6,9}, then
 *         the find() method should return 9 for each of the four elements in
 *         the connected components.
 */
public class Question2 {
	private int[] id;
	private int[] size;

	private int[] maxOfTheConnectedComponents;

	public Question2(int total) {
		id = new int[total];
		size = new int[total];
		maxOfTheConnectedComponents = new int[total];
		for (int i = 0; i < total; i++) {
			id[i] = i;
			size[i] = 1;
			maxOfTheConnectedComponents[i] = i;
		}
	}

	public int find(int i) {
		return maxOfTheConnectedComponents[rootOf(i)];
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

			if (maxOfTheConnectedComponents[rootOfP] > maxOfTheConnectedComponents[rootOfQ]) {
				maxOfTheConnectedComponents[rootOfQ] = maxOfTheConnectedComponents[rootOfP];
			}
		} else {
			// p is the bigger tree, then move q to be under p and increase the
			// size of p tree.
			id[rootOfQ] = rootOfP;
			// size[rootOfP] = size[rootOfQ] + size[rootOfP];
			size[rootOfP] += size[rootOfQ];
			if (maxOfTheConnectedComponents[rootOfQ] > maxOfTheConnectedComponents[rootOfP]) {
				maxOfTheConnectedComponents[rootOfP] = maxOfTheConnectedComponents[rootOfQ];
			}
		}

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

}
