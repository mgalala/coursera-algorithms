/**
 * 
 */
package com.mgalala.algorithms.the3sum;

/**
 * @author mgalala Brute-Force is n(2) n square
 */
public class BruteForce3Sum {
	public int count(int[] input) {
		int length = input.length;
		int count = 0;
		for (int i = 0; i < input.length; i++) {
			for (int j = i + 1; j < length; j++) {
				for (int k = j + 1; k < input.length; k++) {
					if (input[i] + input[j] + input[k] == 0) {
						count++;
					}
				}
			}

		}
		return count;
	}
}
