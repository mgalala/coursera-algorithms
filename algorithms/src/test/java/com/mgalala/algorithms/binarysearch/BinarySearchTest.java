/**
 * 
 */
package com.mgalala.algorithms.binarysearch;

import java.util.Arrays;

import org.apache.commons.lang.time.StopWatch;
import org.junit.Test;

import com.mgalala.algorithms.binarysearch.BinarySearch;

/**
 * @author mgalala
 *
 */
public class BinarySearchTest {
	private BinarySearch binarySearch;

	@Test
	public void testSearch() {
		binarySearch = new BinarySearch();
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();

		int[] input = new int[] { 0, 5, 7, 10, 15, 18, 20, 30, 33, 34, 35 };
		int actual = binarySearch.find(input, 20);
		int binarySearch2 = Arrays.binarySearch(input, 20);

		org.junit.Assert.assertEquals(6, actual);
		org.junit.Assert.assertEquals(6, binarySearch2);
		System.out.printf("Consumed time %s", stopwatch.getTime());
	}

}
