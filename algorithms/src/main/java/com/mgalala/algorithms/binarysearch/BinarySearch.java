/**
 * 
 */
package com.mgalala.algorithms.binarysearch;

/**
 * @author mgalala
 *
 */
public class BinarySearch {

	public int find(int[] input, int key) {
		int low = 0;
		int high = input.length - 1;
		while (low <= high) {
			int middle = low + (high - low) / 2;
			if (key < input[middle]) {
				high = middle - 1;
			} else if (key > input[middle]) {
				low = middle + 1;
			} else {
				return middle;
			}
		}
		return -1;
	}
}
