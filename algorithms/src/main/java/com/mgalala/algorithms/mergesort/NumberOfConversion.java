/**
 * 
 */
package com.mgalala.algorithms.mergesort;

/**
 * @author mgalala Question: Counting inversions. An inversion in an array
 *         a[\,]a[] is a pair of entries a[i]a[i] and a[j]a[j] such that i <
 *         ji<j but a[i] > a[j]a[i]>a[j]. Given an array, design a linearithmic
 *         algorithm to count the number of inversions.
 *         
 *         
 */
public class NumberOfConversion {
	// This class should not be instantiated.

	private static int numberOfConveesions;

	private NumberOfConversion() {
	}

	// stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
		// precondition: a[lo .. mid] and a[mid+1 .. hi] are sorted subarrays
		assert isSorted(a, lo, mid);
		assert isSorted(a, mid + 1, hi);

		// copy to aux[]
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}

		// merge back to a[]
		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (less(aux[j], aux[i])) {
				a[k] = aux[j++];
			} else {
				a[k] = aux[i++];
			}

			numberOfConveesions++;
		}

		// postcondition: a[lo .. hi] is sorted
		assert isSorted(a, lo, hi);
	}

	// mergesort a[lo..hi] using auxiliary array aux[lo..hi]
	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
		if (hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid + 1, hi);
		merge(a, aux, lo, mid, hi);
	}

	/**
	 * Rearranges the array in ascending order, using the natural order.
	 * 
	 * @param a
	 *            the array to be sorted
	 */
	public static void sort(Comparable[] a) {
		Comparable[] aux = new Comparable[a.length];
		sort(a, aux, 0, a.length - 1);
		assert isSorted(a);
	}

	/***************************************************************************
	 * Helper sorting function.
	 ***************************************************************************/

	// is v < w ?
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	/***************************************************************************
	 * Check if array is sorted - useful for debugging.
	 ***************************************************************************/
	private static boolean isSorted(Comparable[] a) {
		return isSorted(a, 0, a.length - 1);
	}

	private static boolean isSorted(Comparable[] a, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}

	/**
	 * Reads in a sequence of strings from standard input; mergesorts them; and
	 * prints them to standard output in ascending order.
	 *
	 * @param args
	 *            the command-line arguments
	 */
	public static void main(String[] args) {
		Integer[] a = { 20, 18, 17, 11, 8, 7, 6, 5, 4, 1 };
		NumberOfConversion.sort(a);
		System.out.println(NumberOfConversion.numberOfConveesions);
	}
}
