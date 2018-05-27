package com.mgalala.algorithms.mergesort;

import java.util.Arrays;

/**
 * 
 * @author mgalala Question: Merging with smaller auxiliary array. Suppose that
 *         the subarray \mathtt{a[0]}a[0] to \mathtt{a[n-1]}a[n−1] is sorted and
 *         the subarray \mathtt{a[n]}a[n] to \mathtt{a[2*n-1]}a[2∗n−1] is
 *         sorted. How can you merge the two subarrays so that \mathtt{a[0]}a[0]
 *         to \mathtt{a[2*n-1]}a[2∗n−1] is sorted using an auxiliary array of
 *         length nn (instead of 2n2n)?
 * 
 * 
 */
public class MergeWithSmallAux {

	public void mergeWithSmaller(Comparable[] a, Comparable[] aux) {
		int auxHi = aux.length;

		assert a.length == 2 * auxHi;

		for (int i = 0; i < auxHi; i++) {
			aux[i] = a[i];
		}

		int i = 0;
		int j = auxHi;

		int k = 0;
		while (k < auxHi) {
			if (aux[i].compareTo(a[j]) < 0)
				a[k] = aux[i++];
			else
				a[k] = a[j++];
			k++;
		}

		while (i < auxHi) {
			if (j >= 2 * auxHi || aux[i].compareTo(a[j]) < 0)
				a[k++] = aux[i++];
			else
				a[k++] = a[j++];
		}
	}

	public static void main(String[] args) {

		Comparable[] a = { 40, 61, 70, 71, 99, 20, 51, 55, 75, 100 };
		MergeWithSmallAux m = new MergeWithSmallAux();
		int N = a.length / 2;
		Comparable[] aux = new Comparable[N];
		m.mergeWithSmaller(a, aux);
		System.out.println("Result");
		Arrays.stream(a).forEach((c) -> System.out.print(c + ","));
		System.out.println();
	}
}