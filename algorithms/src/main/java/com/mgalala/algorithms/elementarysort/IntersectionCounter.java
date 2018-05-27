/**
 * 
 */
package com.mgalala.algorithms.elementarysort;

import java.util.Arrays;

/**
 * @author mgalala
 *
 */
public class IntersectionCounter {
	public int count(Point[] first, Point[] second) {
		Arrays.sort(first);
		Arrays.sort(second);

		int i = 0;
		int j = 0;
		int count = 0;

		while (i < first.length && j < second.length) {
			if (first[i].compareTo(second[j]) == 0) {
				count++;
				i++;
				j++;
			} else if (first[i].compareTo(second[j]) < 0)
				i++;
			else
				j++;
		}
		return count;
	}
}
