/**
 * 
 */
package com.mgalala.algorithms.mergesort;

import java.util.Arrays;

/**
 * @author mgalala
 *
 */
public class MergeSortWithSmallAuxArray {
	public void merge(Comparable[] input, Comparable[] aux) {
		int mid = input.length / 2;

		for (int i = 0; i < mid; i++) {
			aux[i] = input[i];
		}

		int i = 0, j = mid;
		int k = 0;

		while (i < aux.length) {
			if (i > mid)
				input[k] = input[j++];
			else if (j >= input.length) {
				input[k] = aux[i];
				i++;
			} else if (aux[i].compareTo(input[mid]) <= 0) {
				input[k] = aux[i];
				i++;
			} else {
				input[k] = input[j];
				j++;
			}
			k++;
		}

		Arrays.stream(aux).forEach((e) -> System.out.print(e + "-"));
	}

	public static void main(String[] args) {
		MergeSortWithSmallAuxArray mergeSortWithSmallAuxArray = new MergeSortWithSmallAuxArray();

		Comparable[] input = { 22, 43, 66, 77, 99, 23, 45, 55, 75, 95 };
		Comparable[] aux = new Comparable[input.length / 2];
		mergeSortWithSmallAuxArray.merge(input, aux);

		System.out.println("-----------------------------");
		Arrays.stream(input).forEach((i) -> System.out.print(i + "-"));
		System.out.println();
	}
}
