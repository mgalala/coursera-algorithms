/**
 * 
 */
package com.mgalala.algorithms.elementarysort;

import java.util.Arrays;

/**
 * @author mgalala
 *
 */
public class Permutation {

	private int numberOfCompares;

	public boolean checkPermutation(Integer[] first, Integer[] second) {

		if (first == null || second == null) {
			return false;
		}

		if (first.length != second.length) {
			return false;
		}

		Arrays.sort(first);
		Arrays.sort(second);

		boolean identical = true;
		for (int i = 0; i < first.length; i++) {
			numberOfCompares++;
			if (first[i] != second[i]) {
				identical = false;
				break;
			}
		}
		return identical;
	}

	public int getNumberOfCompares() {
		return numberOfCompares;
	}
}
