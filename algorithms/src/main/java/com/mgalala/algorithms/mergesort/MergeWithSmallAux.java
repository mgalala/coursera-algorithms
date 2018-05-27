package com.mgalala.algorithms.mergesort;

import java.util.Arrays;

/**
 * Merging with smaller auxiliary array. Suppose that the subarray a[0] to
 * a[N-1] is sorted and the subarray a[N] to a[2*N-1] is sorted. How can you
 * merge the two subarrays so that a[0] to a[2*N-1] is sorted using an auxiliary
 * array of size N (instead of 2N)?
 * 
 * @author Guibin Zhang <gzhang at radiumone.com>
 */
public class MergeWithSmallAux {

	private boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}

	public void mergeWithSmaller(Comparable[] a, Comparable[] aux) {
		int N = aux.length;
		assert a.length == 2 * N;

		for (int i = 0; i < N; i++) {
			aux[i] = a[i];
		}

		int l = 0;
		int r = N;

		int i = 0;
		for (; i < N; i++) {
			if (less(aux[l], a[r]))
				a[i] = aux[l++];
			else
				a[i] = a[r++];
		}

		while (l < N) {
			if (r >= 2 * N || less(aux[l], a[r]))
				a[i++] = aux[l++];
			else
				a[i++] = a[r++];
		}
	}

	public static void main(String[] args) {

		Comparable[] a = { 40, 61, 70, 71, 99, 20, 51, 55, 75, 100 };
		MergeWithSmallAux m = new MergeWithSmallAux();
		int N = a.length / 2;
		Comparable[] aux = new Comparable[N];
		m.mergeWithSmaller(a, aux);
		System.out.println("After merging:");
		Arrays.stream(a).forEach((c) -> System.out.print(c + ","));
		System.out.println();
	}
}